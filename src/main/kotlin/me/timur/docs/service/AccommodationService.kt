package me.timur.docs.service

import me.timur.docs.domain.Accommodation
import me.timur.docs.domain.Group
import me.timur.docs.enums.ClaimDetailStatus
import me.timur.docs.enums.ClaimStatus
import me.timur.docs.exception.ResourceNotFoundException
import me.timur.docs.model.AccommodationListDto
import me.timur.docs.repository.AccommodationRepository
import me.timur.docs.repository.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat

@Service
class AccommodationService
    @Autowired constructor(private val accommodationRepository: AccommodationRepository,
                            private val groupRepository: GroupRepository) {


    fun findAll(): Map<Group?, List<Accommodation>> {
        return accommodationRepository.findAll().groupBy { it.group }
    }

    fun findById(id: Long): Accommodation{
        return accommodationRepository.findById(id).orElseThrow { ResourceNotFoundException(id) }
    }

    fun save(accommodation: Accommodation){
        accommodationRepository.save(accommodation)
    }

    fun saveAll(claim: AccommodationListDto, id: Long){
        val accommodations = claim.accommodationList
        val finalList = ArrayList<Accommodation>()
        val group = groupRepository.findById(id).orElseThrow { ResourceNotFoundException(id) }
        for (accom in accommodations){
            if(accom.arrivalInString != "" || accom.departureInString != ""){
                accom.group = group
                accom.arrival = Timestamp.valueOf("${accom.arrivalInString} ${accom.checkIn}:00")
                accom.departure = Timestamp.valueOf("${accom.departureInString} ${accom.checkIn}:00")

                if ((accom.rooms == null) || (accom.rooms =="")){
                    var rooms: String = ""
                    if(claim.sgl != 0)
                        rooms = "single: ${claim.sgl}; "
                    if (claim.dbl != 0)
                        rooms = "${rooms}double: ${claim.dbl}; "
                    if (claim.twn != 0)
                        rooms = "${rooms}, twin: ${claim.twn}; "
                    if (claim.trpl != 0)
                        rooms = "${rooms}, triple: ${claim.trpl}; "
                    if (claim.other != 0)
                        rooms = "${rooms}, ${claim.otherName}: ${claim.other}; "
                    accom.rooms = rooms
                }
                finalList.add(accom)
            }
        }
        accommodationRepository.saveAll(finalList)
    }

    fun update(claim: AccommodationListDto){
        val accommodations = claim.accommodationList
        for (accom in accommodations) {
            if (accom.arrivalInString != "" || accom.departureInString != "") {
                accom.arrival = Timestamp.valueOf("${accom.arrivalInString} ${accom.checkIn}:00")
                accom.departure = Timestamp.valueOf("${accom.departureInString} ${accom.checkIn}:00")
            }
        }
    }
}
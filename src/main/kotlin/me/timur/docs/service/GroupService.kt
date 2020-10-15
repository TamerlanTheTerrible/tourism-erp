package me.timur.docs.service

import me.timur.docs.domain.Group
import me.timur.docs.domain.User
import me.timur.docs.enums.ClaimDetailStatus
import me.timur.docs.enums.GroupStatus
import me.timur.docs.exception.ResourceNotFoundException
import me.timur.docs.repository.AccommodationRepository
import me.timur.docs.repository.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat
import kotlin.streams.toList

@Service
class GroupService
@Autowired constructor(private val groupRepo : GroupRepository,
                       private val accommodationRepository: AccommodationRepository)
{
    fun findAll() : List<Group>{
        return groupRepo.findAll().sortedBy { it.arrival }
    }

    fun findAllByStatus(status: GroupStatus): List<Group>{
        return groupRepo.findAllByStatus(status).sortedBy { it.arrival }
    }

    fun findAllByTourOperator(user: User): List<Group>{
        val sortedBy = groupRepo.findAllByTourOperator(user).sortedBy { it.arrival }
        return sortedBy
    }

    fun findAllByTourOperatorAndStatus(user: User, status: GroupStatus): List<Group>{
        return groupRepo.findAllByTourOperatorAndStatus(user, status).sortedBy { it.arrival }
    }

    fun findById(id: Long): Group{
        return groupRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
    }

    fun save(group: Group, user: User){
        if(group.arrivalInString != null)
        group.arrival = (SimpleDateFormat("yyyy-MM-dd").parse(group.arrivalInString))

        group.tourOperator = user
        group.groupNumber = setGroupNumber(group)
        groupRepo.save(group)
    }

    fun update(group: Group, user: User){
        if(group.arrivalInString != null)
        group.arrival = SimpleDateFormat("yyyy-MM-dd").parse(group.arrivalInString)

        if(group.dateCreatedInString !=null)
        group.dateCreated = Timestamp(SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(group.dateCreatedInString).time)

        group.tourOperator = user
        groupRepo.save(group)
    }

    fun setGroupNumber(group: Group): String{
        val month = group.getMonth(group.arrival)
        val filteredList = findAll().stream().filter { it.getMonth(it.arrival) == month }.toList()
        val groupOrder = filteredList.count()+1
        val initial = group.tourOperator?.employee?.initials;
        return "${month+1}/$groupOrder-$initial"
    }

    fun cancel(id: Long){
        val group = findById(id)
        val accomClaim = accommodationRepository.findAllByGroup(group)

        for (accom in accomClaim){
            accom.status = ClaimDetailStatus.CANCELLED
        }

        group.status = GroupStatus.CANCELLED
        group.isActive = false

        groupRepo.save(group)
    }
}
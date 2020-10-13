//package me.timur.docs.service
//
//import me.timur.docs.domain.AccomClaim
//import me.timur.docs.enums.ClaimStatus
//import me.timur.docs.exception.ResourceNotFoundException
//import me.timur.docs.repository.AccomClaimRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//class AccomClaimService (@Autowired private val accomClaimRepo: AccomClaimRepository){
//
//    fun findAll(): List<AccomClaim>{
//        return accomClaimRepo.findAll().sortedBy { it.group?.arrival }
//    }
//
////    fun findAllByStatus(status: ClaimStatus): List<AccomClaim>{
////        return accomClaimRepo.findAllByStatus(status).sortedBy { it.group?.arrival }
////    }
//
//    fun findAllActive(): List<AccomClaim>{
//        return findAll().filter { it.status != ClaimStatus.CANCELLED }
//    }
//
//    fun findById(id: Long): AccomClaim{
//        return accomClaimRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
//    }
//
//    fun delete(id: Long){
//        accomClaimRepo.deleteById(id)
//    }
//
//    fun save(claim: AccomClaim){
//        accomClaimRepo.save(claim)
//    }
//
//    fun cancel(id: Long){
//        val claim = findById(id)
//        claim.status = ClaimStatus.CANCELLED
//        save(claim)
//    }
//
//    fun changeStatus(id: Long, status: ClaimStatus){
//        val claim = findById(id)
//        claim.status = status
//        save(claim)
//    }
//}
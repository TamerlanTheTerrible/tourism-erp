package me.timur.docs.repository

import me.timur.docs.domain.Accommodation
import me.timur.docs.domain.Group
import me.timur.docs.enums.ClaimDetailStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccommodationRepository: JpaRepository<Accommodation, Long> {

    fun findAllByGroup(group: Group): List<Accommodation>

}
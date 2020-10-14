package me.timur.docs.repository

import me.timur.docs.domain.Accommodation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccommodationRepository: JpaRepository<Accommodation, Long>
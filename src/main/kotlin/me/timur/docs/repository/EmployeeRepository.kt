package me.timur.docs.repository

import me.timur.docs.domain.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
//    fun findByUser(user: User): Employee?
}


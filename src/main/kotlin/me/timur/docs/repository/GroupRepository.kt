package me.timur.docs.repository

import jdk.jshell.Snippet
import me.timur.docs.domain.Group
import me.timur.docs.domain.User
import me.timur.docs.enums.GroupStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : JpaRepository<Group, Long> {

    fun findAllByTourOperator(user: User): List<Group>

    fun findAllByStatus(status: GroupStatus): List<Group>

    fun findAllByTourOperatorAndStatus(user: User, status: GroupStatus): List<Group>

}
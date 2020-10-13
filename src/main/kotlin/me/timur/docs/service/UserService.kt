package me.timur.docs.service

import me.timur.docs.domain.User
import me.timur.docs.exception.ResourceNotFoundException
import me.timur.docs.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class UserService(@Autowired private val userRepo : UserRepository) {
    fun findAll() : List<User>{
        return userRepo.findAll()
    }

    fun save(user: User){
        val encodedPassword = BCryptPasswordEncoder().encode(user.password)
        user.password = encodedPassword
        userRepo.save(user)
    }

    fun findById(id: Long): User {
        return userRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
    }

    fun delete(id: Long){
        val user: User = userRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
        user.isActive = false
        userRepo.save(user);
    }

    fun findActiveUsers(isActive: Boolean): List<User>{
//        val activeUsers = userRepo.findAllByActive(isActive)
        val activeUsers = findAll().stream().filter{it.isActive}.toList()
        return activeUsers
    }

    fun updatePassword(id: Long, password: String?) {
        val user = findById(id)
        val encoder = BCryptPasswordEncoder()
        user.password = encoder.encode(password)
        userRepo.save(user)
    }


}

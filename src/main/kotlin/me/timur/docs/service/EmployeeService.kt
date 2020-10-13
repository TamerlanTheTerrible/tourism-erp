package me.timur.docs.service

import me.timur.docs.domain.Employee
import me.timur.docs.domain.User
import me.timur.docs.exception.ResourceNotFoundException
import me.timur.docs.repository.EmployeeRepository
import me.timur.docs.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class EmployeeService(@Autowired private val employeeRepo: EmployeeRepository,
                                private val userRepo: UserRepository) {
    fun findAll() : List<Employee>{
        return employeeRepo.findAll()
    }

    fun save(employee: Employee){
        employeeRepo.save(employee)
    }

//    fun edit(employee: Employee, id: Long){
//        val oldEmployee = findById(id)
//        oldEmployee.user = emp
//        employeeRepo.save(employee)
//    }

    fun findById(id: Long): Employee {
        return employeeRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
    }

    fun delete(id: Long){
        val employee: Employee = employeeRepo.findById(id).orElseThrow { ResourceNotFoundException(id) }
        val user: User = userRepo.findByEmployee(employee)
        user.isActive = false
        userRepo.save(user);
    }

//    fun findActiveEmployees(isActive: Boolean): List<Employee>{
//        val activeEmployee = findAll().stream().filter{it.user!!.isActive}.toList()
//        return activeEmployee
//    }

}
package me.timur.docs.service

import javassist.NotFoundException
import me.timur.docs.domain.Company
import me.timur.docs.repository.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyService(@Autowired private val companyRepository: CompanyRepository) {

    fun findById(id: Int): Company {
        return companyRepository.findById(id).orElseThrow { NotFoundException("no record with id: $id") }
    }
}
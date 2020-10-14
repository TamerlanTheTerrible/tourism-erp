package me.timur.docs.controller

import me.timur.docs.repository.AccommodationRepository
import me.timur.docs.service.AccommodationService
import me.timur.docs.service.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("hotel")
class HotelController

@Autowired constructor (
//                        private val accomService: AccommodationService,
//                        private val groupService: GroupService,
                        private val accomRepo: AccommodationRepository
                        )
{

    @GetMapping("/all","/")
    fun hotels(model: Model): String {
        val accommodations = accomRepo.findAll()
        model.addAttribute("accommodations", accommodations)
        return "/tour_operator/accommodation/accommodation"
    }
}
package me.timur.docs.controller

import me.timur.docs.domain.Accommodation
import me.timur.docs.model.AccommodationListDto
import me.timur.docs.service.AccommodationService
import me.timur.docs.service.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("to/accommodation")
class AccomController
    @Autowired constructor
        (private val accomService: AccommodationService,
         private val groupService: GroupService) {

    @GetMapping("/", "/all")
    fun findAll(model: Model): String {
        val accommodations = accomService.findAll()
        model.addAttribute("accommodations", accommodations)
        return "/tour_operator/accommodation/accommodation"
    }

    @RequestMapping("/new/{id}")
    fun new(@PathVariable(name="id") id: Long,
            model: Model): String {
        val claim = AccommodationListDto()
        val group = groupService.findById(id)
        for (i in 1..4) {
            val accom = Accommodation()
            accom.checkIn="14:00"
            accom.checkOut="18:00"
            claim.addAccommodation(accom)

        }

        model.addAttribute("claim", claim)
        model.addAttribute("group", group)
        return "/index"
    }

    @PostMapping("/save-all/{id}")
    fun saveAll(@PathVariable(name = "id") id: Long,
                @ModelAttribute("claim") claim: AccommodationListDto): String {
        accomService.saveAll(claim, id)
        return "redirect:/to/accommodation/all"
    }
}
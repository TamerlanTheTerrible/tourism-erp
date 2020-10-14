package me.timur.docs.controller

import me.timur.docs.domain.Accommodation
import me.timur.docs.model.AccommodationListDto
import me.timur.docs.service.AccommodationService
import me.timur.docs.service.GroupService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.jvmName

@Controller
@RequestMapping("to/accommodation")
class AccommodationController
    @Autowired constructor
        (private val accomService: AccommodationService,
         private val groupService: GroupService) {

    private val logger = LoggerFactory.getLogger(AccommodationController::class.jvmName)

    @GetMapping("/", "/all")
    fun findAll(model: Model): String {
        val accommodations = accomService.findAll()
        model.addAttribute("accommodations", accommodations)
        return "tour_operator/accommodation/accommodation"
    }

    @GetMapping("/new/{id}")
    fun new(@PathVariable(name="id") id: Long,
            model: Model): String {

        logger.warn("NEW enter")
        val claim = AccommodationListDto()

        logger.warn("NEW find group by ID")
        val group = groupService.findById(id)

        logger.warn("NEW assign default values to 'checkIn' and 'checkOut' ")
        for (i in 1..4) {
            val accom = Accommodation()
            accom.checkIn="14:00"
            accom.checkOut="18:00"
            claim.addAccommodation(accom)
        }

        logger.warn("NEW add model attributes")
        model.addAttribute("claim", claim)
        model.addAttribute("group", group)

        logger.warn("NEW exit")
        return "tour_operator/accommodation/accommodation_new"
    }

    @PostMapping("/save-all/{id}")
    fun saveAll(@PathVariable(name = "id") id: Long,
                @ModelAttribute("claim") claim: AccommodationListDto): String {
        accomService.saveAll(claim, id)
        return "redirect: tour_operator/accommodation/all"
    }
}
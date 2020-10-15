package me.timur.docs.controller

import me.timur.docs.domain.Accommodation
import me.timur.docs.domain.Employee
import me.timur.docs.enums.ClaimDetailStatus
import me.timur.docs.model.AccommodationListDto
import me.timur.docs.service.AccommodationService
import me.timur.docs.service.GroupService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
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
        val accommodations = accomService.findAllByStatus(ClaimDetailStatus.CONFIRMED)
        model.addAttribute("accommodations", accommodations)
        return "tour_operator/accommodation/accommodation"
    }

    @GetMapping("/new/{id}")
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
        return "tour_operator/accommodation/accommodation_new"
    }

    @PostMapping("/save-all/{id}")
    fun saveAll(@PathVariable(name = "id") id: Long,
                @ModelAttribute("claim") claim: AccommodationListDto): String {
        accomService.saveAll(claim, id)
        return "redirect:/to/accommodation/"
    }

    @PostMapping("/save")
    fun save(@ModelAttribute("accommodation") accommodation: Accommodation) : String {
        accomService.save(accommodation)
        return "redirect:/to/accommodation/"
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable(name = "id") id: Long): String{
        accomService.cancel(id)
        return "redirect:/to/accommodation/"
    }

    @RequestMapping("/edit/{id}")
    fun edit(@PathVariable(name="id") id : Long) : ModelAndView {
        val mav = ModelAndView("tour_operator/accommodation/accommodation_edit")
        val accommodation = accomService.findById(id)
        mav.addObject("accommodation", accommodation)
        return mav
    }

}
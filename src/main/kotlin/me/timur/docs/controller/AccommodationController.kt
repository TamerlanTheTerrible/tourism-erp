//package me.timur.docs.controller
//
//import me.timur.docs.domain.Accommodation
//import me.timur.docs.service.AccommodationService
//import me.timur.docs.model.AccommodationListDto
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Controller
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.ModelAttribute
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import kotlin.streams.toList
//
//@Controller
//@RequestMapping("to/accommodation")
//class AccommodationController(@Autowired private val accomService: AccommodationService) {
//
//    @GetMapping("/", "/all")
//    fun findAll(model: Model): String {
//        val accommodations = accomService.findAll()
//        model.addAttribute("accommodations", accommodations)
//        return "/tour_operator/accommodation/accommodation"
//    }
//
//    @GetMapping("/new")
//    fun new(model: Model): String {
//        var accommdations = ArrayList<Accommodation>(5)
//        model.addAttribute("accommodations", accommodationListDto)
//        return "/tour_operator/accommodation/accommodation_new"
//    }
//
//    @PostMapping("/save-all")
//    fun saveAll(@ModelAttribute("accommodations") claimDto: AccommodationListDto): String {
//        val accommodations = claimDto.accommodationList
//
//        accomService.saveAll(accommodations)
//        return "redirect:/to/accommodation/"
//    }
//}
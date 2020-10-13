//package me.timur.docs.controller
//
//import me.timur.docs.domain.AccomClaim
//import me.timur.docs.domain.Accommodation
//import me.timur.docs.service.AccomClaimService
//import me.timur.docs.service.AccommodationService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Controller
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RequestMapping
//
//@Controller
//@RequestMapping("to/accommodation")
//class AccomClaimController
//    @Autowired constructor(private val accomClaimService: AccomClaimService,
//                            private val accommodationService: AccommodationService) {
//
//    @GetMapping("/", "/all-active")
//    fun allActive(model: Model):String {
//        val claims = accomClaimService.findAllActive()
//        model.addAttribute("claims", claims)
//        return "tour_operator/accommodation/accommodation"
//    }
//
//    @GetMapping("/save")
//    fun save(claim: AccomClaim, accommodations: List<Accommodation>): String{
//        accomClaimService.save(claim)
//        accommodationService.saveAll(accommodations)
//        return "redirect:/to/accommodation/all-active"
//    }
//}
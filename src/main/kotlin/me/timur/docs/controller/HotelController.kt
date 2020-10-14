package me.timur.docs.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("hotel")
class HotelController {

    @GetMapping("/all","/")
    fun hotels(): String{
        return "index"
    }
}
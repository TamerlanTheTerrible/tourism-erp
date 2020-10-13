package me.timur.docs.controller

import me.timur.docs.domain.Group
import me.timur.docs.domain.User
import me.timur.docs.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("admin/user")
class UserController (@Autowired private val userService: UserService){

    @GetMapping("/all")
    fun all(model: Model): String{
        model.addAttribute("users", userService.findAll())
        return "admin/users"
    }

    @GetMapping("/all-active")
    fun allActive(model: Model): String{
        model.addAttribute("users", userService.findActiveUsers(true))
        return "admin/users"
    }

    @GetMapping("/{id}")
    fun single(@PathVariable(name="id") id : Long, model: Model): String {
        model.addAttribute("user", userService.findById(id))
        return "admin/user"
    }

    @RequestMapping("/new")
    fun registerUser(model : Model) : String {
        val user  = User()
        model.addAttribute("user", user)
        return "admin/user_new"
    }

    @PostMapping("/save")
    fun save(@ModelAttribute("user") user: User) : String {
        userService.save(user)
        return "redirect:/admin/user/all"
    }

    @PostMapping("/save-model")
    fun saveModel(user: User) : String {
        userService.save(user)
        return "redirect:/"
    }

    @RequestMapping("/edit/{id}")
    fun edit(@PathVariable(name="id") id : Long) : ModelAndView {
        val mav = ModelAndView("admin/user_edit")
        mav.addObject("user", userService.findById(id))
        return mav
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable(name="id")id : Long) : String{
        userService.delete(id)
        return "redirect:admin/users"
    }
}
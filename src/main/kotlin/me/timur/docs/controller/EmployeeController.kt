package me.timur.docs.controller

import me.timur.docs.domain.Employee
import me.timur.docs.domain.Group
import me.timur.docs.repository.EmployeeRepository
import me.timur.docs.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("accounting/employee")
class EmployeeController(@Autowired private val employeeService: EmployeeService) {

    @GetMapping("/all")
    fun all(model: Model): String{
        model.addAttribute("employees", employeeService.findAll())
        return "accounting/employees"
    }

//    @GetMapping("/all-active")
//    fun allActive(model: Model): String{
//        model.addAttribute("employees", employeeService.findActiveEmployees(true))
//        return "accounting/employees"
//    }

    @GetMapping("/{id}")
    fun single(@PathVariable(name="id") id : Long, model: Model): String {
        model.addAttribute("employee", employeeService.findById(id))
        return "accounting/employee"
    }

    @RequestMapping("/new")
    fun registerEmployee(model : Model) : String {
        val employee  = Employee()
        model.addAttribute("employee", employee)
        return "accounting/employee_new"
    }

    @PostMapping("/save")
    fun save(@ModelAttribute("employee") employee: Employee) : String {
        employeeService.save(employee)
        return "redirect:/accounting/employee/all"
    }

    @RequestMapping("/edit/{id}")
    fun edit(@PathVariable(name="id") id : Long) : ModelAndView {
        val mav = ModelAndView("accounting/employee_edit")
        val employee = employeeService.findById(id)
        mav.addObject("employee", employee)
        return mav
    }

    @RequestMapping("/delete/{id}")
    fun deleteJournal(@PathVariable(name="id")id : Long) : String{
        employeeService.delete(id)
        return "redirect:/"
    }
}
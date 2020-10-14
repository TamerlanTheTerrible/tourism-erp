package me.timur.docs.controller

import me.timur.docs.domain.Group
import me.timur.docs.enums.GroupStatus
import me.timur.docs.security.UserPrincipal
import me.timur.docs.service.AccommodationService
import me.timur.docs.service.GroupService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.jvmName

@Controller
@RequestMapping("to/groups")
class GroupController (@Autowired private val groupService: GroupService,
                        private val accomService: AccommodationService) {

    private val logger = LoggerFactory.getLogger(GroupController::class.jvmName)

    @GetMapping("/all")
    fun all(model : Model) : String {
        val groups = groupService.findAll()
        model.addAttribute("groups", groups)
        return "tour_operator/group/groups_cancelled"
    }

    @GetMapping("/all-booked")
    fun allBooked(model : Model) : String {
        val groups = groupService.findAllByStatus(GroupStatus.BOOKED)
        model.addAttribute("groups", groups)
        return "tour_operator/group/groups"
    }

    @GetMapping("/all-cancelled")
    fun allCancelled(model: Model): String {
        model.addAttribute("groups", groupService.findAllByStatus(GroupStatus.CANCELLED))
        return "tour_operator/group/groups_cancelled"
    }


    @GetMapping("/all-by-to")
    fun allByTourOperator(@AuthenticationPrincipal userPrincipal: UserPrincipal, model : Model): String{
        model.addAttribute("groups", groupService.findAllByTourOperatorAndStatus(userPrincipal.user, GroupStatus.BOOKED))
        return "tour_operator/group/groups"
    }

    @GetMapping("/all-booked-by-to", "/")
    fun allBookedByTourOperator(@AuthenticationPrincipal userPrincipal: UserPrincipal, model : Model): String{

        logger.warn("groups enter")

        val groups= groupService.findAllByTourOperatorAndStatus(userPrincipal.user, GroupStatus.BOOKED)
        model.addAttribute("groups", groups)

        logger.warn("groups exit")

        return "tour_operator/group/groups"
    }

    @GetMapping("/all-cancelled-by-to")
    fun allCancelledByTourOperator(@AuthenticationPrincipal userPrincipal: UserPrincipal,model : Model): String{
        val groups= groupService.findAllByTourOperatorAndStatus(userPrincipal.user, GroupStatus.CANCELLED)
        model.addAttribute("groups", groups)
        return "tour_operator/group/groups"
    }

    //TODO validate the form. Arrival date is must
    @RequestMapping("/new")
    fun new(model : Model) : String {
        val group  = Group()
        model.addAttribute("group", group)
        return "tour_operator/group/group_new"
    }

    @PostMapping("/save")
    fun save(@ModelAttribute("group") group: Group,
             @AuthenticationPrincipal userPrincipal: UserPrincipal) : String {
        groupService.save(group, userPrincipal.user)
        return "redirect:/tour_operator/groups/"
    }

    @RequestMapping("/update")
//        @RequestMapping("/update", method = {RequestMethod.PUT, RequestMethod.GET})
    fun update(group: Group, @AuthenticationPrincipal userPrincipal: UserPrincipal): String{
        groupService.update(group, userPrincipal.user);
        return "redirect:/tour_operator/groups/"
    }

    @RequestMapping("/cancel/{id}")
    fun cancel(@PathVariable(name="id") id: Long): String{
        groupService.cancel(id)
        return "redirect:/tour_operator/groups/"
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long): Group{
        val group = groupService.findById(id)
        group.arrivalInString = group.arrival.toString().substring(0,11);
        group.dateCreatedInString = group.dateCreated.toString();
        return group
    }

//    @PostMapping("/save-model")
//    fun saveModal(group: Group) : String {
//        groupService.save(group)
//        return "redirect:/"
//    }

       @GetMapping("/accommodation")
        fun findAll(model: Model): String {
           val accommodations = accomService.findAll()
           model.addAttribute("accommodations", accommodations)
           return "/tour_operator/accommodation/accommodation"
    }
}
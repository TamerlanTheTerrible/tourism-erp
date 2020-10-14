package me.timur.docs.controller;

import com.sun.istack.logging.Logger;
import me.timur.docs.domain.Group;
import me.timur.docs.service.GroupService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
class HomeController{

    @Autowired
    GroupService groupService;


    @GetMapping("/index")
    public String index(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";}

    @GetMapping("accessDenied")
    public String accessDenied(){return "access_denied";}
}

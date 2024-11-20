package org.Java.Project.School.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={" ", "/", "home"})
    public String display(){
        return  "home.html";
    }
}

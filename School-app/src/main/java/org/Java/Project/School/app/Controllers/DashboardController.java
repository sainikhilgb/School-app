package org.Java.Project.School.app.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication){

        model.addAttribute("userName", authentication.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());
        return "dashboard.html";
    }

}

package org.Java.Project.School.app.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class loginController {


    @GetMapping("/login")
    @PostMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout",required = false) String logout, Model model){

        String errorMessage = null;
        if(errorMessage != null){
            errorMessage="UserName and Password were wrong";
        }
        if(logout != null){
            errorMessage="Logout Successfully";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(httpRequest,httpResponse,auth);
        }

        return  "redirect:/login?logout=true";
    }


}

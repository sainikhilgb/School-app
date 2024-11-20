package org.Java.Project.School.app.Controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.Java.Project.School.app.Services.ContactService;
import org.Java.Project.School.app.models.Contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class ContactController {


    private final ContactService contactService;


    @Autowired
    public ContactController(ContactService contactService){
        this.contactService= contactService;
    }

    @RequestMapping(value="/contact")
    public String displayContacts(Model model){
        model.addAttribute("contact",new Contacts());

        return  "contact.html";
    }


    @PostMapping("/saveMsg")
    public String saveContact(@Valid @ModelAttribute("contact") Contacts contacts, Errors errors){

        if(errors.hasErrors()){
            log.error("Contact from validation failed due to :" + errors.toString());
            return "contact.html";
        }

        contactService.saveMessageDetails(contacts);
        return "redirect:/contact";
    }



}

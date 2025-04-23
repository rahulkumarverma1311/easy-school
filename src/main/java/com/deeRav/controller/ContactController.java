package com.deeRav.controller;

import com.deeRav.entity.Contact;
import com.deeRav.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Controller
public class ContactController {



    private final ContactService contactService;
    @Autowired
    private ContactController(ContactService contactService){
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage(Model model)
    {
        model.addAttribute("contact", new Contact());
        return "contact.html";

    }
//    @PostMapping("/saveMsg")
//    public ModelAndView saveMassage(@RequestParam String name,@RequestParam String mobileNum,@RequestParam String email,@RequestParam String subject,@RequestParam String message){
//        log.info("Name : "+  name );
//        log.info("Mobile Number : "+  mobileNum );
//        log.info("Email : "+  email );
//        log.info("Subject : "+  subject );
//        log.info("Message : "+  message );
//        return new ModelAndView("redirect/contact");
//    }

    @PostMapping("/saveMsg")
    public String saveMassage (@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : "+ errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        contactService.setCount(contactService.getCount() +1);
        log.info("count"+ contactService.getCount());
        return "redirect:/contact";
    }

}

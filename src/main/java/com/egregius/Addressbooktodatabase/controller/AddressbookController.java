package com.egregius.Addressbooktodatabase.controller;


import com.egregius.Addressbooktodatabase.model.Addressbook;
import com.egregius.Addressbooktodatabase.repo.AddressbookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AddressbookController {

    @Autowired
    AddressbookRepository addressbookRepository;



    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String addressbookForm(Model model) {
        model.addAttribute("addressbook", new Addressbook());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String addressbookSubmit(@ModelAttribute Addressbook addressbook, Model model) {

        model.addAttribute("addressbook", addressbook);
        String info = String.format("Addressbook Submission: id = %d, emailaddress = %s, firstname = %s, lastname = %s, phonenumber = %s",
                addressbook.getId(), addressbook.getEmailaddress(), addressbook.getFirstname(), addressbook.getLastname(), addressbook.getPhonenumber());
        log.info(info);
        addressbookRepository.save(addressbook);

        return "result";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String employeerecordSubmit(Model model, @RequestParam("id") long id) {

        Addressbook addressbook = addressbookRepository.findOne(id);
        model.addAttribute("addressbook", addressbook);

        return "load";

    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Addressbook addressbook = addressbookRepository.findOne(id);
        model.addAttribute("addressbook", addressbook);
        return "update";
    }





    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteemployee(Integer id) {
        addressbookRepository.delete(Long.valueOf(id));
        return "delete";
    }



}


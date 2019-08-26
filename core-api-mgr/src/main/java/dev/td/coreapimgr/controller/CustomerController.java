package dev.td.coreapimgr.controller;

import dev.td.coreapimgr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/query/{id}")
    public String query(@PathVariable("id") String id) {
        return customerService.query(id);
    }
}

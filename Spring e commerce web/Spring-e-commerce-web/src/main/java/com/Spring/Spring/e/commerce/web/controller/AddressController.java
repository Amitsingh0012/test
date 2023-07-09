package com.Spring.Spring.e.commerce.web.controller;

import com.Spring.Spring.e.commerce.web.model.Address;
import com.Spring.Spring.e.commerce.web.repository.AddressRepository;
import com.Spring.Spring.e.commerce.web.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;


    @PostMapping
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }
}

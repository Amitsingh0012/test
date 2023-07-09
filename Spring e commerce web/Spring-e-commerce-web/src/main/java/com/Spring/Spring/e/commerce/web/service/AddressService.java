package com.Spring.Spring.e.commerce.web.service;

import com.Spring.Spring.e.commerce.web.model.Address;
import com.Spring.Spring.e.commerce.web.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressService {
    @Autowired
    AddressRepository addressRepoository;

    public void createAddress(Address address) {
        addressRepoository.save(address);
    }
}

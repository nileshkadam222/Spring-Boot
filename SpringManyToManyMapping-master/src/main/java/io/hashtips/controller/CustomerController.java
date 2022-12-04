package io.hashtips.controller;

import io.hashtips.domain.Customer;
import io.hashtips.domain.Vehicle;
import io.hashtips.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> saveCustomer() {
        Customer c = new Customer();
        c.setCustomerId(123L);
        c.setCustomerName("Nilesh");
        List<Vehicle> v = new ArrayList<>();
        Vehicle v1= new Vehicle();
        v1.setVehicleId(1L);
        v1.setVehicleName("Audi");
        v.add(v1);
        c.setVehicles(v);

        return new ResponseEntity<>(customerService.saveCustomer1(c), HttpStatus.CREATED);
    }
}

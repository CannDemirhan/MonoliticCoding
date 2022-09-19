package com.candemirhan._321monoliticcoding.controller;

import com.candemirhan._321monoliticcoding.repository.entity.Customer;
import com.candemirhan._321monoliticcoding.service.CustomerService;
import com.candemirhan._321monoliticcoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/save")
    public ResponseEntity<Customer> save()
    {
        return ResponseEntity.ok(
                customerService.save(
                    Customer.builder()
                        .firstName("Can")
                        .lastName("Demirhan")
                        .address("Adana")
                        .phoneNumber("1234")
                        .email("can@demir.com")
                        .build()));
    }
    @GetMapping("/savealldemo")
    public ResponseEntity<Void> saveAll()
    {
        try {
            customerService.saveAll(new Datas().getCustomerList());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll()
    {
        return ResponseEntity.ok(customerService.findAll());
    }
    @GetMapping("/findallbyaddress")
    public ResponseEntity<List<Customer>> findAllByAddress()
    {
        String address = "İstanbul";
        return ResponseEntity.ok(customerService.findAllByAddress(address));
    }
    @GetMapping("/findallbyfirstname")
    public ResponseEntity<List<Customer>> findAllByFirstName()
    {
        String firstName = "Ali";
        return ResponseEntity.ok(customerService.findAllByFirstName(firstName));
    }
    @GetMapping("/findallbynamelike")
    public ResponseEntity<List<Customer>> findAllByFirstNameLike()
    {
        String name = "Ali";
        name += "%";
        return ResponseEntity.ok(customerService.findAllByFirstNameLike(name));
    }
}

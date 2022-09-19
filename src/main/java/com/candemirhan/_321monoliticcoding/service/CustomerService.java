package com.candemirhan._321monoliticcoding.service;

import com.candemirhan._321monoliticcoding.repository.CustomerRepository;
import com.candemirhan._321monoliticcoding.repository.entity.Customer;
import com.candemirhan._321monoliticcoding.service.model.ServiceMenager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceMenager<Customer,Long> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllByAddress(String address)
    {
        return customerRepository.findAllByAddress(address);
    }
    public List<Customer> findAllByFirstName(String firstName)
    {
        return customerRepository.findAllByFirstName(firstName);
    }
    public List<Customer> findAllByFirstNameLike(String firstName)
    {
        return customerRepository.findAllByFirstNameLike(firstName);
    }
    List<Customer> findAllByFirstNameContaining(String firstName)
    {
        return customerRepository.findAllByFirstNameContaining(firstName);
    }
    List<Customer> findByFirstNameStartsWithAndAddress(String name, String address)
    {
        return customerRepository.findByFirstNameStartsWithAndAddress(name,address);
    }
    List<Customer> findAllByCreatedAtGreaterThan(Long date)
    {
        return customerRepository.findAllByCreatedAtGreaterThan(date);
    }
    Optional<Customer> findTopOptionalByFirstNameOrderByOidDesc(String firstName)
    {
        return customerRepository.findTopOptionalByFirstNameOrderByOidDesc(firstName);
    }
    List<Customer> findAllByCreatedAtBetween(Long startDate, Long endDate)
    {
        return customerRepository.findAllByCreatedAtBetween(startDate,endDate);
    }
    List<Customer> findAllByAddressAndCreatedAtBetween(String address,Long startDate, Long endDate)
    {
        return customerRepository.findAllByAddressAndCreatedAtBetween(address,startDate,endDate);
    }
}

package com.candemirhan._321monoliticcoding.utility;

import com.candemirhan._321monoliticcoding.repository.entity.Customer;
import com.candemirhan._321monoliticcoding.repository.entity.Product;
import com.candemirhan._321monoliticcoding.repository.entity.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Datas {

    private List<Customer> customerList;
    private List<Product> productList;
    private List<Sale> saleList;

    public List<Customer> getCustomerList()
    {
        customerList = new ArrayList<>();
        customerList.add(Customer.builder()
                .firstName("Ali")
                .address("Ankara")
                .phoneNumber("123456789")
                .lastName("Yılmaz")
                .email("muhammet@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Deniz")
                .address("İstanbul")
                .phoneNumber("545456665")
                .lastName("Yılmaz")
                .email("deniz@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Bahar")
                .address("Ankara")
                .phoneNumber("77455512")
                .lastName("Yılmaz")
                .email("bahar@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Gülşen")
                .address("İzmir")
                .phoneNumber("5454654")
                .lastName("Yılmaz")
                .email("gulsen@gmail.com").build());
        customerList.stream().forEach((customer) -> {
            customer.setCreatedAt(1662469617000L);
            customer.setUpdatedAt(1662469617000L);
            customer.setCreatedBy("Developer");
            customer.setUpdatedBy("Developer");
            customer.setState(1);
        });
        return customerList;
    }
    public List<Product> getProductList()
    {
        productList = new ArrayList<>();
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(1000.0)
                .label("Asus")
                .model("X555")
                .amonth(10)
                //.createdAt(1662556017000l)
                .build());
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(2000.0)
                .label("Asus")
                .model("X322")
                .amonth(10)
                .build());
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(3000.0)
                .label("Asus")
                .model("CX33")
                .amonth(10)
                .build());
        productList.stream().forEach((product) -> {
            product.setCreatedAt(1662469617000L);
            product.setUpdatedAt(1662469617000L);
            product.setCreatedBy("Developer");
            product.setUpdatedBy("Developer");
            product.setState(1);
        });
        return productList;
    }
    public List<Sale> getSaleList()
    {
        saleList = new ArrayList<>();
        saleList.add(Sale.builder()
                .amonth(1)
                .price(1000.0)
                .customerId(1L)
                .productId(1L)
                //.createdAt(1662556017000L)
                .build());
        saleList.add(Sale.builder()
                .amonth(1)
                .price(2000.0)
                .customerId(2L)
                .productId(2L)
                .build());
        saleList.add(Sale.builder()
                .amonth(1)
                .price(3000.0)
                .customerId(3L)
                .productId(3L)
                .build());
        saleList.add(Sale.builder()
                .amonth(1)
                .price(3000.0)
                .customerId(4L)
                .productId(2L)
                .build());
        saleList.add(Sale.builder()
                .amonth(1)
                .price(3000.0)
                .customerId(2L)
                .productId(3L)
                .build());
        saleList.stream().forEach((sale) -> {
            sale.setCreatedAt(1662469617000L);
            sale.setUpdatedAt(1662469617000L);
            sale.setCreatedBy("Developer");
            sale.setUpdatedBy("Developer");
            sale.setState(1);
        });
        return saleList;
    }
}

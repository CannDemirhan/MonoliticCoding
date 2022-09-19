package com.candemirhan._321monoliticcoding.service;

import com.candemirhan._321monoliticcoding.dto.request.FindByIdRequestDto;
import com.candemirhan._321monoliticcoding.dto.response.GetAllSaleResponseDto;
import com.candemirhan._321monoliticcoding.repository.CustomerRepository;
import com.candemirhan._321monoliticcoding.repository.ProductRepository;
import com.candemirhan._321monoliticcoding.repository.SaleRepository;
import com.candemirhan._321monoliticcoding.repository.entity.Customer;
import com.candemirhan._321monoliticcoding.repository.entity.Product;
import com.candemirhan._321monoliticcoding.repository.entity.Sale;
import com.candemirhan._321monoliticcoding.service.model.ServiceMenager;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService extends ServiceMenager<Sale,Long> {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, CustomerRepository customerRepository)
    {
        super(saleRepository);
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public Optional<Sale> findById(FindByIdRequestDto dto)
    {
        if(dto.getOid() != null)
            return saleRepository.findById(dto.getOid());
        return Optional.empty();
    }

    public List<GetAllSaleResponseDto> findAllDto(String customerName)
    {
        return findAllDto().stream()
                .filter((dto) -> dto.getCustomerName().contains(customerName))
                .collect(Collectors.toList());
    }
    public List<GetAllSaleResponseDto> findAllDto()
    {
        List<Sale> saleList = saleRepository.findAll();
        List<GetAllSaleResponseDto> responseDtoList = new ArrayList<>();

        saleList.stream().forEach((sale) -> {
            Optional<Customer> customer = customerRepository.findById(sale.getCustomerId());
            Optional<Product> product = productRepository.findById(sale.getProductId());

            if(customer.isPresent() && product.isPresent())
            {
                responseDtoList.add(GetAllSaleResponseDto.builder()
                                .oid(sale.getOid())
                                .customerId(customer.get().getOid())
                                .productId(product.get().getOid())
                                .customerName(customer.get().getFirstName() + " " + customer.get().getLastName())
                                .productName(product.get().getName())
                                .amonth(product.get().getAmonth())
                                .price(product.get().getPrice())
                                .totalPrice(product.get().getPrice() * product.get().getAmonth())
                                .createdAt(
                                        Instant.ofEpochMilli(sale.getCreatedAt())
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate())
                                .build());
            }
            else
                System.out.println("Customer or Product is not Found...: [Sale Id] "+ sale.getOid());
        });
        return responseDtoList;
    }

    public void save(Long customerId, Long productId, Integer amonth, Double price)
    {
        Sale sale = Sale.builder()
                .customerId(customerId)
                .productId(productId)
                .amonth(amonth)
                .price(price)
                .build();
        sale.setCreatedAt(System.currentTimeMillis());
        sale.setUpdatedAt(System.currentTimeMillis());
        saleRepository.save(sale);
    }
    public void update(Long id, Long customerId, Long productId, Integer amonth, Double price)
    {
        Sale sale = saleRepository.findById(id).get();
        sale.setCustomerId(customerId);
        sale.setProductId(productId);
        sale.setAmonth(amonth);
        sale.setPrice(price);
        sale.setUpdatedAt(System.currentTimeMillis());
        saleRepository.save(sale);
    }
}

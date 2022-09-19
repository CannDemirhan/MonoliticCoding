package com.candemirhan._321monoliticcoding.service;

import com.candemirhan._321monoliticcoding.dto.request.ProductSaveRequestDto;
import com.candemirhan._321monoliticcoding.mapper.ProductMapper;
import com.candemirhan._321monoliticcoding.repository.ProductRepository;
import com.candemirhan._321monoliticcoding.repository.entity.Product;
import com.candemirhan._321monoliticcoding.service.model.ServiceMenager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceMenager<Product,Long> {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public Product save(ProductSaveRequestDto dto)
    {
//        Product product = Product.builder()
//                .name(dto.getName())
//                .label(dto.getLabel())
//                .model(dto.getModel())
//                .price(dto.getPrice())
//                .build();
//        product.setCreatedAt(System.currentTimeMillis());
//        product.setUpdatedAt(System.currentTimeMillis());
//        product.setCreatedBy("Developer");
//        product.setCreatedBy("Developer");
//        return product;
        return productRepository.save(ProductMapper.INSTANCE.toProduct(dto));
    }
    public Product saveMapper(ProductSaveRequestDto dto)
    {
        Product product = ProductMapper.INSTANCE.toProduct(dto);
        product.setCreatedAt(System.currentTimeMillis());
        return productRepository.save(product);
    }
}

package com.candemirhan._321monoliticcoding.controller;

import com.candemirhan._321monoliticcoding.dto.request.ProductSaveRequestDto;
import com.candemirhan._321monoliticcoding.repository.entity.Product;
import com.candemirhan._321monoliticcoding.service.ProductService;
import com.candemirhan._321monoliticcoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        productService.saveAll(new Datas().getProductList());
        return ResponseEntity.ok("Kayıt başarılı");
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/saveparam")
    public ResponseEntity<Product> saveParameter(String name,String label,
                                              String model,Double price){
        Product product = Product.builder()
                .name(name)
                .label(label)
                .model(model)
                .price(price)
                .build();
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/saveparamdto")
    public ResponseEntity<Product> saveParamDto(ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.saveMapper(dto));
    }

}

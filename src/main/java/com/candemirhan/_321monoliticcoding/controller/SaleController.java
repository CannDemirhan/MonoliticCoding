package com.candemirhan._321monoliticcoding.controller;

import com.candemirhan._321monoliticcoding.dto.request.FindByIdRequestDto;
import com.candemirhan._321monoliticcoding.dto.response.GetAllSaleResponseDto;
import com.candemirhan._321monoliticcoding.repository.entity.Sale;
import com.candemirhan._321monoliticcoding.service.SaleService;
import com.candemirhan._321monoliticcoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
/**
 * RestAPI
 * -- Kullanıcıdan tüm HTML methodlarında istek alıp yine kullanıyıya
 * response olarak bir Entity dönebildiğimiz yapılandırma şeklidir.
 * -- 3. Parti uygulamaların birbirleriyle haberleşmesi için kullanılır.
 * -- Microservis yapısında anahtar rol oynar ve microservislerin aralarında
 * haberleşmesini sağlar.
 */
@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    /**
     * Action -> Method kendisi
     * localhost:9090/sale/savealldemo
     * GET
     * POST
     * PUT
     * DELETE
     */

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        saleService.saveAll(new Datas().getSaleList());
        return ResponseEntity.ok("Datas are Registered");
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GetAllSaleResponseDto>> findAll(String id){
        System.out.println("Id Received......: " + id);
        return ResponseEntity.ok(saleService.findAllDto());
    }
    @GetMapping("/getallbycustomername")
    public ResponseEntity<List<GetAllSaleResponseDto>> findAllByCustomerNameGet(String customerName){
        System.out.println("Get Mothod is Called");
        return ResponseEntity.ok(saleService.findAllDto(customerName));
    }

    @PostMapping("/getallbycustomername")
    public ResponseEntity<List<GetAllSaleResponseDto>> findAllByCustomerNamePost(String customerName){
        System.out.println("Post Mothod is Called");
        return ResponseEntity.ok(saleService.findAllDto(customerName));
    }
    @PostMapping("/findbyid")
    public ResponseEntity<Sale> findById(FindByIdRequestDto dto){
        Optional<Sale> sale = saleService.findById(dto);
        if(sale.isPresent()){
            return ResponseEntity.ok(sale.get());
        }
        return ResponseEntity.ok(new Sale());
    }

    @GetMapping("/message")
    public String getMessage(){
        return "HELLO";
    }
}

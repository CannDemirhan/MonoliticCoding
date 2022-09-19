package com.candemirhan._321monoliticcoding.dto.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetAllSaleResponseDto {

    private Long oid;
    private Long customerId;
    private Long productId;
    private String customerName;
    private String productName;
    private int amonth;
    private Double price;
    private Double totalPrice;
    private LocalDate createdAt;
}

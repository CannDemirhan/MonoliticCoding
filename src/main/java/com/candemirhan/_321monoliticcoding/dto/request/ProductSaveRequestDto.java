package com.candemirhan._321monoliticcoding.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductSaveRequestDto {

    private String name;
    private String label;
    private String model;
    private Double price;
}

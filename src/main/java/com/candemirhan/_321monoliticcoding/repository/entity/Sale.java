package com.candemirhan._321monoliticcoding.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblsale")
@Entity(name = "sale")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale extends BaseObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "product_id")
    private Long productId;
    private int amonth;
    private double price;
}

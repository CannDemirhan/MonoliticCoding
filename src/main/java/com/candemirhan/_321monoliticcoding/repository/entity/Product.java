package com.candemirhan._321monoliticcoding.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblproduct")
@Entity(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    private String name;
    private String label;
    private String model;

    @Column(precision = 2, nullable = false)
    private double price;
    private int amonth;
}

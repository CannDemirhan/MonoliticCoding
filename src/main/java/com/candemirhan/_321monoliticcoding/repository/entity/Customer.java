package com.candemirhan._321monoliticcoding.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblcustomer")
@Entity(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends BaseObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
}

package com.sunbasedata.task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

}

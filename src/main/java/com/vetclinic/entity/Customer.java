package com.vetclinic.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pin;

    private String firstName;

    private String lastName;

    public int getId() {
        return id;
    }

}

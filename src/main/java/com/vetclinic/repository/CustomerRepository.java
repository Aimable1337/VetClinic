package com.vetclinic.repository;

import com.vetclinic.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByIdAndPin(int id, int pin);

}

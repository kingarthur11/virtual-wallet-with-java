package com.waller.walletapi.repository;

import com.waller.walletapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c where c.email=:email")
    Iterable<Customer> findCustomerByEmail(@Param("email") String email);
}

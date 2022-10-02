package com.example.repository;


import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int id);

    @Modifying
    @Query(value = "update customer set is_delete= 1 where id = :keywordId", nativeQuery = true)
    void deleteById(@Param("keywordId") int id);

    @Query(value = "select * from customer where `name` like %:keyword1% and phone like %:keyword2% and address like %:keyword3% and is_delete=0", nativeQuery = true)
    Page<Customer> searchByName(@Param("keyword1") String name, @Param("keyword2") String phone, @Param("keyword3") String address, Pageable pageable);
}

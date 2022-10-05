package com.example.repository;



import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "update employee set is_delete= 1 where id = :keywordId", nativeQuery = true)
    void deleteById(@Param("keywordId") int id);

    @Query(value = "select * from employee where name_employee like %:keyword1% and phone_number like %:keyword2% and id_card like %:keyword3% and is_delete=0", nativeQuery = true)
    Page<Employee> searchByName(@Param("keyword1") String name, @Param("keyword2") String phone, @Param("keyword3") String idCard, Pageable pageable);


}

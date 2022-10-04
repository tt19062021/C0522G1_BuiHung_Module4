package com.example.repository;

import com.example.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Contract findById(int id);

}

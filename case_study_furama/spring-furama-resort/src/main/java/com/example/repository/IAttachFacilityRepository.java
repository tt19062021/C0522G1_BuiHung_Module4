package com.example.repository;


import com.example.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {


}

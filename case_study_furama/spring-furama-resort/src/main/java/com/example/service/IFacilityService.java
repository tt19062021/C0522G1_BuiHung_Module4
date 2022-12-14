package com.example.service;

import com.example.dto.IFacilityDto;
import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {

    Page<Facility> findAllByQuery(String name,Pageable pageable);

    void save(Facility facility);

    Facility findById(int id);

    Facility update(Facility facility);

    void remove(int id);

    List<Facility> findAll();
    List<IFacilityDto> findIdName();
}

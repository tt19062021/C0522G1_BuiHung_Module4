package com.example.service.impl;

import com.example.model.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByQuery(String name,Pageable pageable) {
        return iFacilityRepository.findAllByQuery(name,pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public Facility update(Facility facility) {
        return iFacilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        iFacilityRepository.deleteLogical(id);
    }
}

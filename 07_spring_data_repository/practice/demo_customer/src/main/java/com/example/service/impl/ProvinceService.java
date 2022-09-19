package com.example.service.impl;

import com.example.model.Province;
import com.example.repository.IProvinceRepository;
import com.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }
}

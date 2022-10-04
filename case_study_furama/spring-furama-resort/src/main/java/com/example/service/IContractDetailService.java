package com.example.service;


import com.example.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();

    ContractDetail findById(int id);

    void save(ContractDetail contractDetail);
}

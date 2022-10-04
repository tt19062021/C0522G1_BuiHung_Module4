package com.example.service.impl;

import com.example.model.Contract;
import com.example.repository.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        iContractRepository.deleteById(id);
    }


}

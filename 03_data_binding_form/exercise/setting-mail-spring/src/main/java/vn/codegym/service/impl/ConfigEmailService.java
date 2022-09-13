package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ConfigEmail;
import vn.codegym.repository.IConfigEmailRepository;
import vn.codegym.service.IConfigEmailService;


import java.util.List;

@Service
public class ConfigEmailService implements IConfigEmailService {

    @Autowired
    private IConfigEmailRepository iConfigEmailRepository;

    @Override
    public List<ConfigEmail> findAll() {
        return iConfigEmailRepository.findAll();
    }

    @Override
    public List<String> listLanguage() {
        return iConfigEmailRepository.listLanguage();
    }

    @Override
    public List<Integer> listPageSize() {
        return iConfigEmailRepository.listPageSize();
    }

    @Override
    public ConfigEmail findById(int id) {
        return iConfigEmailRepository.findById(id);
    }

    @Override
    public void update(ConfigEmail configEmail) {
        iConfigEmailRepository.update(configEmail);
    }

}

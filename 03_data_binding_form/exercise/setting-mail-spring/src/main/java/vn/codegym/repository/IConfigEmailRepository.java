package vn.codegym.repository;

import vn.codegym.model.ConfigEmail;

import java.util.List;

public interface IConfigEmailRepository {
    List<ConfigEmail> findAll();

    List<String> listLanguage();

    List<Integer> listPageSize();

    ConfigEmail findById(int id);

    void update(ConfigEmail configEmail);
}

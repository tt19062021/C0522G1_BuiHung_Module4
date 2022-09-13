package vn.codegym.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.codegym.model.ConfigEmail;
import vn.codegym.repository.IConfigEmailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigEmailRepository implements IConfigEmailRepository {


    private static List<ConfigEmail> configEmailList;

    static {

        configEmailList = new ArrayList<>();
        configEmailList.add(new ConfigEmail(1, "English", 20, "1", "Thor,Agard"));
        configEmailList.add(new ConfigEmail(2, "Vietnamese", 5, "1", "Thor,Agard"));
    }

    @Override
    public List<ConfigEmail> findAll() {
        return configEmailList;
    }

    @Override
    public List<String> listLanguage() {
        List<String> languageList = new ArrayList<>();

        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        return languageList;
    }

    @Override
    public List<Integer> listPageSize() {
        List<Integer> pageSizeList = new ArrayList<>();

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(20);
        pageSizeList.add(50);
        pageSizeList.add(100);

        return pageSizeList;
    }

    @Override
    public ConfigEmail findById(int id) {
        for (ConfigEmail configEmail : configEmailList) {
            if (configEmail.getId() == id) {
                return configEmail;
            }
        }
        return null;
    }

    @Override
    public void update(ConfigEmail configEmail) {
        for (ConfigEmail email : configEmailList) {
            if (configEmail.getId() == email.getId()) {
                configEmailList.remove(email);
                configEmailList.add(configEmail);
                break;
            }
        }
    }
}

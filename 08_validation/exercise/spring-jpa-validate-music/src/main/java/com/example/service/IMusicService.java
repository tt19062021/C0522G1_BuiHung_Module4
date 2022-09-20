package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {

    List<Music> findByAll();

    void save(Music music);

    Music update(Music music);

    Music findById(int id);
}

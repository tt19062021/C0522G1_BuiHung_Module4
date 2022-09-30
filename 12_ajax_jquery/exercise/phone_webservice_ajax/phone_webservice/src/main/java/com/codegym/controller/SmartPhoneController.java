package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/phone/api/v1")
@CrossOrigin
public class SmartPhoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
            return new ResponseEntity<>(smartphoneService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
            return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Smartphone>> findById(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.NO_CONTENT);

    }


}

package com.superhero.controller;

import com.superhero.model.SuperHeroe;
import com.superhero.repository.SuperHeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/super-heroes")
public class SuperHeroeController {

    @Autowired
    private SuperHeroeRepository superHeroeRepository;

    @GetMapping("")
    public ResponseEntity<List<SuperHeroe>> getAllSuperHeroes() {
        try {
            List<SuperHeroe> list = superHeroeRepository.findAll();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHeroe> getSuperHeroe(@PathVariable Long id) {
        Optional<SuperHeroe> superHeroe = superHeroeRepository.findById(id);

        if (superHeroe.isPresent()) {
            return new ResponseEntity<>(superHeroe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byNameCont/{inName}")
    public ResponseEntity<List<SuperHeroe>> getSuperHeroeInName(@PathVariable String inName) {
        try {
            List<SuperHeroe> list = superHeroeRepository.findByNameContaining(inName);

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("")
    public ResponseEntity<SuperHeroe> saveSuperHeroe(@RequestBody SuperHeroe superHeroe) {
        try {
            return new ResponseEntity<>(superHeroeRepository.save(superHeroe), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<SuperHeroe> updateSuperHeroe(@RequestBody SuperHeroe superHeroe) {
        try {
            return new ResponseEntity<>(superHeroeRepository.save(superHeroe), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuperHeroe(@PathVariable Long id) {
        try {
            Optional<SuperHeroe> superHeroe = superHeroeRepository.findById(id);
            if (superHeroe.isPresent()) {
                superHeroeRepository.delete(superHeroe.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

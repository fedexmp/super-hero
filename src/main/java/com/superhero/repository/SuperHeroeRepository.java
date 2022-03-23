package com.superhero.repository;

import com.superhero.model.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Long> {
    List<SuperHeroe> findByNameContaining(String infix);

}



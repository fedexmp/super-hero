package com.superhero;

import com.superhero.model.SuperHeroe;
import com.superhero.repository.SuperHeroeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SuperHeroeRepositoryTest {

    @Autowired
    private SuperHeroeRepository superHeroeRepository;

    @Test
    public void should_create_new_superHeroe() {
        SuperHeroe superHeroe = new SuperHeroe("Batman", "Venganza");
        superHeroeRepository.save(superHeroe);

        Optional<SuperHeroe> superHeroeById = superHeroeRepository.findById(Long.valueOf(1));

        if(superHeroeById.isPresent()){
        assertThat(superHeroeById).isNotNull();
        System.out.println(superHeroeById.get().toString());
        }
    }

    @Test
    public void should_find_all_superHeroes() {
        Iterable<SuperHeroe> superHeroes = superHeroeRepository.findAll();
        assertThat(superHeroes).hasSize(1);
    }

    @Test
    public void should_delete_superHeroe() {
        Optional<SuperHeroe> superHeroeById = superHeroeRepository.findById(Long.valueOf(1));
        assertThat(superHeroeById).isNotNull();

        if(superHeroeById.isPresent()){
            superHeroeRepository.delete(superHeroeById.get());
        }

        Iterable<SuperHeroe> superHeroes = superHeroeRepository.findAll();
        assertThat(superHeroes).hasSize(0);
    }
}
package com.it.app.repository;

import com.it.app.model.Flat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {

    @Query(value = "SELECT f FROM Flat f")
    List<Flat> findAllFlats(Sort sort);

    @Query(value = "SELECT MAX(m.value) FROM Flat m")
    List<Flat> findMaxValue();

}

package com.it.app.repository;

import com.it.app.model.Flat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//интерфейс, где создаются запросы-методы для работы с таблицей Flat, которые потом можно использовать в main классе
public interface FlatRepository extends JpaRepository<Flat, Long> {
    //создаем запрос-метод для вывода всех записей из таблицы Flat по заданному столбцу
    @Query(value = "SELECT f FROM Flat f")
    List<Flat> findAllFlats(Sort sort);

    //создаем запрос-метод для вывода максимального значения стоимости квартиры из имеющихся данных
    @Query(value = "SELECT MAX(m.value) FROM Flat m")
    List<Flat> findMaxValue();

}

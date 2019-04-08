package com.it.app.repository;

import com.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//интерфейс, где создаются запросы-методы для работы с таблицей User, которые потом можно использовать в main классе
public interface UserRepository extends JpaRepository<User, Long> {

    //создаем запрос-метод для нахождения записи из таблицы User по имени
    @Query("SELECT u FROM User u")
    Optional<User> findByName(String name);

    //создаем запрос-метод для определения  количества записей в таблице User по id
    @Query("SELECT count(u.id) FROM User u")
    List<User> findCountOfUsers();

}

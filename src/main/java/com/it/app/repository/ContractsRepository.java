package com.it.app.repository;

import com.it.app.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

//интерфейс, где создаются запросы-методы для работы с таблицей Contract, которые потом можно использовать в main классе
public interface ContractsRepository extends JpaRepository<Contracts, Long> {
}

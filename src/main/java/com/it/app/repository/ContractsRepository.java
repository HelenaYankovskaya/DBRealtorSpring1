package com.it.app.repository;

import com.it.app.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractsRepository extends JpaRepository<Contracts, Long> {
}

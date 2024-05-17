package com.api.apirestbanco.repositorie;

import com.api.apirestbanco.model.LogAccessModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogAccessRepository extends JpaRepository<LogAccessModel, Long> {
}

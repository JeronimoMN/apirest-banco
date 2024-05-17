package com.api.apirestbanco.repositorie;

import com.api.apirestbanco.model.LogTransaccionesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogTransaccionRepository extends JpaRepository<LogTransaccionesModel, Long> {
}
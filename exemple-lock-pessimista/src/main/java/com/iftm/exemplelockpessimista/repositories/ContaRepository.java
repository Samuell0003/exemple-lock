package com.iftm.exemplelockpessimista.repositories;

import com.iftm.exemplelockpessimista.models.Conta;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Conta> findByConta(String conta);

}

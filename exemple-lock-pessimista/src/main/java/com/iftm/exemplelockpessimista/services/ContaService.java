package com.iftm.exemplelockpessimista.services;

import com.iftm.exemplelockpessimista.models.Conta;
import com.iftm.exemplelockpessimista.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ResponseEntity<Conta> save (Conta conta) {
        return ResponseEntity.ok(contaRepository.save(conta));
    }

    @Transactional
    public ResponseEntity<Conta> sacar(String conta, Double valor) {
        var contaDb = contaRepository.findByConta(conta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inecistente"));

        contaDb.sacar(valor);

        return ResponseEntity.ok(contaRepository.save(contaDb));

    }

    @Transactional
    public ResponseEntity<Conta> depositar(String conta, Double valor) {
        var contaDb = contaRepository.findByConta(conta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inecistente"));

        contaDb.depositar(valor);

        return ResponseEntity.ok(contaRepository.save(contaDb));

    }
}

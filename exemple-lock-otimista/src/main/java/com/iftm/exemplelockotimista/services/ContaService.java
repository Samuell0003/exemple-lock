package com.iftm.exemplelockotimista.services;

import com.iftm.exemplelockotimista.models.Conta;
import com.iftm.exemplelockotimista.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;


    public ResponseEntity<Conta> save (Conta conta) {
        return ResponseEntity.ok(contaRepository.save(conta));
    }

    @Transactional
    public ResponseEntity<Conta> sacar(String numConta, Double valor) {
        var conta = contaRepository.findByConta(numConta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        conta.sacar(valor);

        return ResponseEntity.ok(contaRepository.save(conta));
    }

    @Transactional
    public ResponseEntity<Conta> deposito(String numConta, Double valor) {
        var conta = contaRepository.findByConta(numConta).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Conta inexistente"));

        conta.depositar(valor);

        return ResponseEntity.ok(contaRepository.save(conta));
    }
}

package com.iftm.exemplelockpessimista.controller;

import com.iftm.exemplelockpessimista.models.Conta;
import com.iftm.exemplelockpessimista.models.Transacao;
import com.iftm.exemplelockpessimista.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/sacar")
    public ResponseEntity<?> sacar(@RequestBody Transacao transacao) {
        return contaService.sacar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping("/depositar")
    public ResponseEntity<?> depositar(@RequestBody Transacao transacao) {
        return contaService.depositar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping()
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        return contaService.save(conta);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> findAll() {
        return contaService.findAll();
    }
}

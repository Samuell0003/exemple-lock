package com.iftm.exemplelockpessimista.controller;

import com.iftm.exemplelockpessimista.models.Conta;
import com.iftm.exemplelockpessimista.models.Transacao;
import com.iftm.exemplelockpessimista.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/sacar")
    public ResponseEntity<Conta> sacar(@RequestBody Transacao transacao) {
        return contaService.sacar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping("/depositar")
    public ResponseEntity<Conta> depositar(@RequestBody Transacao transacao) {
        return contaService.depositar(transacao.numeroConta(), transacao.valor());
    }

    @PostMapping("")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        return contaService.save(conta);
    }
}
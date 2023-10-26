package com.iftm.exemplelockotimista.controllers;

import com.iftm.exemplelockotimista.models.Conta;
import com.iftm.exemplelockotimista.models.TransacaoConta;
import com.iftm.exemplelockotimista.services.ContaService;
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
    public ResponseEntity<Conta> sacar(@RequestBody TransacaoConta transacaoConta) {
        return contaService.sacar(transacaoConta.numeroConta(), transacaoConta.valor());
    }

    @PostMapping("")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        return contaService.save(conta);
    }

    @PostMapping("/depositar")
    public ResponseEntity<Conta> depositar(@RequestBody TransacaoConta transacaoConta) {
        return contaService.deposito(transacaoConta.numeroConta(), transacaoConta.valor());
    }
}

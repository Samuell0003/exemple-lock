package com.iftm.exemplelockotimista.controllers;

import com.iftm.exemplelockotimista.models.Conta;
import com.iftm.exemplelockotimista.models.TransacaoConta;
import com.iftm.exemplelockotimista.services.ContaService;
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
    public ResponseEntity<?> sacar(@RequestBody TransacaoConta transacaoConta) {
        return contaService.sacar(transacaoConta.numeroConta(), transacaoConta.valor());
    }

    @PostMapping("")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        return contaService.save(conta);
    }

    @PostMapping("/depositar")
    public ResponseEntity<?> depositar(@RequestBody TransacaoConta transacaoConta) {
        return contaService.deposito(transacaoConta.numeroConta(), transacaoConta.valor());
    }
    @GetMapping
    public ResponseEntity<List<Conta>> findAll() {
        return contaService.findAll();
    }
}

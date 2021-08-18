package com.example.atividade001.resource;


import com.example.atividade001.domain.PessoaDomain;
import com.example.atividade001.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public List<PessoaDomain> listarPessoas() {
        return this.pessoaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaDomain> buscarPessoaPorId(@PathVariable Long id) {
        return this.pessoaRepository.findById(id).map(pessoaDomain -> ResponseEntity.ok(pessoaDomain)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PessoaDomain> inserirPessoa(@RequestBody PessoaDomain pessoaDomain) {
        this.pessoaRepository.save(pessoaDomain);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping
    public PessoaDomain editar(@RequestBody PessoaDomain pessoaDomain) {
        return this.pessoaRepository.save(pessoaDomain);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        this.pessoaRepository.deleteById(id);
    }

}



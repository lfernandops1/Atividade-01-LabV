package com.example.atividade001.resource;


import com.example.atividade001.domain.PessoaDomain;
import com.example.atividade001.repository.PessoaRepository;
import com.example.atividade001.service.PessoaService;
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
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDomain> listarPessoas() {
        return pessoaService.listar();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody PessoaDomain pessoaDomain) {
        pessoaService.salvar(pessoaDomain);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @PutMapping
    public void atualizar(@RequestBody PessoaDomain pessoaDomain) {
        pessoaService.atualizar(pessoaDomain);
    }


    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable("id") Long idPessoa) throws Exception {
        pessoaService.deletarPorId(idPessoa);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDomain> buscarPorId(@PathVariable("id") Long idPessoa) throws Exception {
        PessoaDomain pessoaDomain = pessoaService.buscarPorId(idPessoa);
        return ResponseEntity.ok(pessoaDomain);
    }

}



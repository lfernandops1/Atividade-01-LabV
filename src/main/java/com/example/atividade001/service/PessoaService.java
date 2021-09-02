package com.example.atividade001.service;

import com.example.atividade001.domain.PessoaDomain;
import com.example.atividade001.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDomain salvar(PessoaDomain pessoaDomain) {
        PessoaDomain pessoaDomainCriada = pessoaRepository.save(pessoaDomain);
        return pessoaDomainCriada;
    }

    public PessoaDomain atualizar(PessoaDomain pessoaDomain) {
        PessoaDomain editoriaAtualizada = pessoaRepository.save(pessoaDomain);
        return editoriaAtualizada;
    }

    public void deletarPorId(Long id) throws Exception {
        PessoaDomain editoriaExclusao = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

        pessoaRepository.deleteById(id);
    }

    public PessoaDomain buscarPorId(Long id) throws Exception {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
    }

    public List<PessoaDomain> listar() {
        return pessoaRepository.findAll();
    }

}




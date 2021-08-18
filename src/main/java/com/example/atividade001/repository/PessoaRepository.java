package com.example.atividade001.repository;

import com.example.atividade001.domain.PessoaDomain;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaDomain, Long> {


}

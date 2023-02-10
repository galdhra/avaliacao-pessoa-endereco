package com.galdhra.Pessoa.services;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.repositories.*;
import com.galdhra.Pessoa.services.exceptions.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new PessoaDTO(pessoa);
    }
}

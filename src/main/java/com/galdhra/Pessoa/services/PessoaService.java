package com.galdhra.Pessoa.services;

import org.springframework.transaction.annotation.*;

public class PessoaService {

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new PessoaDTO(pessoa);
    }
}

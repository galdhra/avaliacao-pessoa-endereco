package com.galdhra.Pessoa.services;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.repositories.*;
import com.galdhra.Pessoa.services.exceptions.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(String name, Pageable pageable) {
        Page<Pessoa> result = repository.searchByName(name, pageable);
        return result.map(x -> new PessoaDTO(x));
    }
}

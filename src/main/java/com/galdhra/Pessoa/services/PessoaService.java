package com.galdhra.Pessoa.services;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;



    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(String name, Pageable pageable) {
        Page<Pessoa> result = repository.searchByName(name, pageable);
        return result.map(x -> new PessoaDTO(x));
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAllEnderecos(Long id) {
        Optional<Pessoa> result = repository.findById(id);
        List<Endereco> list = result.get().getEnderecos();
        return list.stream().map(x -> new EnderecoDTO(x)).toList();
    }

    @Transactional
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa entity = new Pessoa();
        copyDtoPessoa(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);

    }

    @Transactional
    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa entity = repository.getReferenceById(id);
        copyDtoPessoa(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);
    }

    @Transactional
    public PessoaDTO updateAddress(Long id, EnderecoDTO dto) {
        Pessoa entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);
    }


    private void copyDtoPessoa(PessoaDTO dto, Pessoa entity){
        entity.setNome(dto.getNome());
        entity.setDataDeNascimento(dto.getDataDeNascimento());
    }
    private void copyDtoToEntity(EnderecoDTO dto, Pessoa entity) {

            Endereco endereco = new Endereco();
            endereco.setId(dto.getId());
            endereco.setLogradouro(dto.getLogradouro());
            endereco.setCep(dto.getCep());
            endereco.setNumeroCasa(dto.getNumeroCasa());

            if(dto.getEnderecoPrincipal() == true){
               entity.getEnderecos().stream().forEach(x -> x.setEnderecoPrincipal(false));
               endereco.setEnderecoPrincipal(dto.getEnderecoPrincipal());
            }else {
            endereco.setEnderecoPrincipal(dto.getEnderecoPrincipal());
            }

            endereco.setCidade(dto.getCidade());
            endereco.setUF(dto.getUF());
            endereco.setMorador(entity);
            entity.getEnderecos().add(endereco);
        }

    }


package com.galdhra.Pessoa.services;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Autowired
    EnderecoService enderecoService;

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
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);

    }


    private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
        entity.setNome(dto.getNome());
        entity.setDataDeNascimento(dto.getDataDeNascimento());

        for (EnderecoDTO endDto : dto.getEnderecos()) {
            EnderecoDTO end = enderecoService.update(endDto);
            Endereco endereco = new Endereco();
            endereco.setId(end.getId());
            endereco.setLogradouro(end.getLogradouro());
            endereco.setCep(end.getCep());
            endereco.setNumero(end.getNumero());
            endereco.setPrincipal(end.getPrincipal());
            endDto.setCidade(end.getCidade());
            endDto.setUF(end.getUF());
            entity.getEnderecos().add(endereco);
        }

    }
}

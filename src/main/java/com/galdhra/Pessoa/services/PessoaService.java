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
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);

    }


    private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
        entity.setNome(dto.getNome());
        entity.setDataDeNascimento(dto.getDataDeNascimento());

        for (EnderecoDTO endDto : dto.getEnderecos()) {
            Endereco endereco = new Endereco();
            endereco.setId(endDto.getId());
            endereco.setLogradouro(endDto.getLogradouro());
            endereco.setCep(endDto.getCep());
            endereco.setNumero(endDto.getNumero());
            if(endDto.getPrincipal() == true){
                entity.getEnderecos().stream().filter(x-> x.getPrincipal()).map(x->false).collect(Collectors.toList());
                endereco.setPrincipal(endDto.getPrincipal());
            }else {
            endereco.setPrincipal(endDto.getPrincipal());}
            endereco.setCidade(endDto.getCidade());
            endereco.setUF(endDto.getUF());
            entity.getEnderecos().add(endereco);
        }

    }
}

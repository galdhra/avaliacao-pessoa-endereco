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
        entity.setNome(dto.getNome());
        entity.setDataDeNascimento(dto.getDataDeNascimento());
        entity = repository.save(entity);
        return new PessoaDTO(entity);

    }

    @Transactional
    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);
    }


    private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {

        for (EnderecoDTO endDto : dto.getEnderecos()) {
            Endereco endereco = new Endereco();
            endereco.setId(endDto.getId());
            endereco.setLogradouro(endDto.getLogradouro());
            endereco.setCep(endDto.getCep());
            endereco.setNumeroCasa(endDto.getNumeroCasa());
            if(endDto.getEnderecoPrincipal() == true){
                entity.getEnderecos().stream().filter(x-> x.getEnderecoPrincipal()).map(x->false).collect(Collectors.toList());
                endereco.setEnderecoPrincipal(endDto.getEnderecoPrincipal());
            }else {
            endereco.setEnderecoPrincipal(endDto.getEnderecoPrincipal());}
            endereco.setCidade(endDto.getCidade());
            endereco.setUF(endDto.getUF());

            Pessoa pessoa = repository.getReferenceById(endDto.getMoradorId());
            endereco.setMorador(pessoa);
            entity.getEnderecos().add(endereco);
        }

    }
}

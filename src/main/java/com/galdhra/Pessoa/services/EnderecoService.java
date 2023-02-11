package com.galdhra.Pessoa.services;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.repositories.*;
import com.galdhra.Pessoa.services.exceptions.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    @Transactional(readOnly = true)
    public EnderecoDTO findById(Long id) {
        Endereco endereco = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new EnderecoDTO(endereco);
    }



    @Transactional
    public EnderecoDTO update(EnderecoDTO dto) {
        Boolean yes = repository.consultaCep(dto.getCep()).isEmpty();
        if(yes == true) {
            Endereco entity = new Endereco();
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EnderecoDTO(entity);

        }else{
            Endereco entity = repository.getReferenceById(dto.getId());
            return new EnderecoDTO(entity);
        }
    }



    private void copyDtoToEntity(EnderecoDTO dto, Endereco entity) {
        entity.setLogradouro(dto.getLogradouro());
        entity.setCep(dto.getCep());
        entity.setNumero(dto.getNumero());
        entity.setPrincipal(dto.getPrincipal());
        entity.setCidade(dto.getCidade());
        entity.setUF(dto.getUF());
    }
}




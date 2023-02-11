package com.galdhra.Pessoa.controllers;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.entities.*;
import com.galdhra.Pessoa.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import java.net.*;
import java.util.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;


    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> findAll(
            @RequestParam(name="name", defaultValue = "") String name,
            Pageable pageable){
        Page<PessoaDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}/ends")
    public ResponseEntity<List<EnderecoDTO>> findAllEnderecos(@PathVariable Long id){
        List<EnderecoDTO> list = service.findAllEnderecos(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}/address")
    public ResponseEntity<PessoaDTO> updateAddress(@PathVariable Long id, @RequestBody EnderecoDTO dto){
        PessoaDTO pesDto = service.updateAddress(id,dto);
        return ResponseEntity.ok(pesDto);
    }
}

package com.galdhra.Pessoa.controllers;

import com.galdhra.Pessoa.DTO.*;
import com.galdhra.Pessoa.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
}

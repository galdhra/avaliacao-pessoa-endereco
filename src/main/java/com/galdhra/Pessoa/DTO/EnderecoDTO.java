package com.galdhra.Pessoa.DTO;

import com.galdhra.Pessoa.entities.*;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private Boolean principal;
    private String cidade;
    private UnidadeFederativa UF;

    public EnderecoDTO(Long id, String logradouro, String cep, Integer numero, Boolean principal, String cidade, UnidadeFederativa UF) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.principal = principal;
        this.cidade = cidade;
        this.UF = UF;
    }

    public EnderecoDTO(Endereco entity) {
        id = entity.getId();
        logradouro = entity.getLogradouro();
        cep = entity.getCep();
        numero = entity.getNumero();
        principal = entity.getPrincipal();
        cidade = entity.getCidade();
        UF = entity.getUF();
    }
}

package com.galdhra.Pessoa.DTO;

import com.galdhra.Pessoa.entities.*;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numeroCasa;
    private Boolean enderecoPrincipal;
    private String cidade;
    private UnidadeFederativa UF;

    private Long moradorId;


    public EnderecoDTO(Long id, String logradouro, String cep, Integer numeroCasa, Boolean enderecoPrincipal, String cidade, UnidadeFederativa UF, Long moradorId) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.enderecoPrincipal = enderecoPrincipal;
        this.cidade = cidade;
        this.UF = UF;
        this.moradorId = moradorId;
    }

    public EnderecoDTO(Endereco entity) {
        id = entity.getId();
        logradouro = entity.getLogradouro();
        cep = entity.getCep();
        numeroCasa = entity.getNumeroCasa();
        enderecoPrincipal = entity.getEnderecoPrincipal();
        cidade = entity.getCidade();
        UF = entity.getUF();
        moradorId = entity.getMorador().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getUF() {
        return UF;
    }

    public void setUF(UnidadeFederativa UF) {
        this.UF = UF;
    }

    public Long getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(Long moradorId) {
        this.moradorId = moradorId;
    }
}

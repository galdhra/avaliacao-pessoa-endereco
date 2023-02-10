package com.galdhra.Pessoa.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private Boolean principal;
    private String cidade;
    private UnidadeFederativa UF;

    @ManyToOne
    @JoinColumn(name = "enderecos_id")
    private Pessoa morador;

    public Endereco (){

    }

    public Endereco(Long id, String logradouro, String cep, Integer numero, Boolean principal, String cidade, UnidadeFederativa UF) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.principal = principal;
        this.cidade = cidade;
        this.UF = UF;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
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

    public Pessoa getMorador() {
        return morador;
    }

    public void setMorador(Pessoa morador) {
        this.morador = morador;
    }
}

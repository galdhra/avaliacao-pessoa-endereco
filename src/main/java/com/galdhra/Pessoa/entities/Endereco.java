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
    private Integer numeroCasa;
    private Boolean enderecoPrincipal;
    private String cidade;
    private UnidadeFederativa UF;

    @ManyToOne
    @JoinColumn(name = "enderecos_id")
    private Pessoa morador;

    public Endereco (){

    }

    public Endereco(Long id, String logradouro, String cep, Integer numeroCasa, Boolean enderecoPrincipal, String cidade, UnidadeFederativa UF, Pessoa morador) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.enderecoPrincipal = enderecoPrincipal;
        this.cidade = cidade;
        this.UF = UF;
        this.morador = morador;

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

    public Pessoa getMorador() {
        return morador;
    }

    public void setMorador(Pessoa morador) {
        this.morador = morador;
    }
}

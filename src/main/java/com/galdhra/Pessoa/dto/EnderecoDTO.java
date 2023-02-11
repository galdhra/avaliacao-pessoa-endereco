package com.galdhra.Pessoa.dto;

import com.galdhra.Pessoa.entities.*;
import jakarta.validation.constraints.*;
public class EnderecoDTO {

    private Long id;
    @Size(min = 3, max = 80, message="O nome deve ter entre 3 e 80 caracteres")
    @NotBlank(message="Campo requerido")
    private String logradouro;
    @Size(min=8, max=8, message= "O CEP é composto por 8 números")
    @NotBlank(message="Campo requerido")
    private String cep;
    @Positive
    private Integer numeroCasa;
    @NotNull
    private Boolean enderecoPrincipal;
    @Size(min = 3, max = 80, message="O nome da cidade deve ter entre 3 e 80 caracteres")
    @NotBlank(message="Campo requerido")
    private String cidade;
    @NotNull
    private UnidadeFederativa UF;


    public EnderecoDTO(Long id, String logradouro, String cep, Integer numeroCasa, Boolean enderecoPrincipal, String cidade, UnidadeFederativa UF) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.enderecoPrincipal = enderecoPrincipal;
        this.cidade = cidade;
        this.UF = UF;
    }

    public EnderecoDTO(Endereco entity) {
        id = entity.getId();
        logradouro = entity.getLogradouro();
        cep = entity.getCep();
        numeroCasa = entity.getNumeroCasa();
        enderecoPrincipal = entity.getEnderecoPrincipal();
        cidade = entity.getCidade();
        UF = entity.getUF();
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
}

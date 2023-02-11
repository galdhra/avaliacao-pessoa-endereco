package com.galdhra.Pessoa.repositories;

import com.galdhra.Pessoa.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

    @Query(nativeQuery = true, value = "SELECT cep FROM tb_endereco" +
            " WHERE cep like :cep")
    List<String> consultaCep (String cep);

    @Query(nativeQuery = true, value= "SELECT * FROM TB_ENDERECO " +
            "WHERE UPPER(tb_endereco.logradouro) = UPPER(:nome)")
    Endereco searchByName(String nome);
}

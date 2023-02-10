package com.galdhra.Pessoa.repositories;

import com.galdhra.Pessoa.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    @Query("SELECT obj FROM Pessoa obj " +
            "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    Page<Pessoa> searchByName(String nome, Pageable pageable);

}

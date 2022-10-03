package br.com.lojasJogos.ApiLojaJogosServices.Repository;


import br.com.lojasJogos.ApiLojaJogosServices.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

        @Query(value = "select * from clientes where upper(nome) = upper(:nome)",nativeQuery = true)
        List<Cliente> findByNome(String nome);
}



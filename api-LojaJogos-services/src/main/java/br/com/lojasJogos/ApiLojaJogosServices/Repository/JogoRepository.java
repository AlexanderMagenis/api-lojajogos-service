package br.com.lojasJogos.ApiLojaJogosServices.Repository;

import br.com.lojasJogos.ApiLojaJogosServices.Model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query(value = "select * from jogos where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)", nativeQuery = true)
    List<Jogo> findByNomeDescricao(String nome, String descricao );
}

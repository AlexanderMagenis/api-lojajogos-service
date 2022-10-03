package br.com.lojasJogos.ApiLojaJogosServices.Service;

import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoRequestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Jogo;

import java.util.List;

public interface JogoService {

    List<Jogo> getTodosJogos();

    JogoResponseDto addJogo(JogoRequestDto jogoRequestDto);

    JogoResponseDto updateJogo(Long id, JogoRequestDto jogoRequestDto);

    JogoResponseDto getByIdJogo(Long id);

    void deleteJogo(Long id);

    List<Jogo> getJogoByFilter(String nome, String descricao);
}


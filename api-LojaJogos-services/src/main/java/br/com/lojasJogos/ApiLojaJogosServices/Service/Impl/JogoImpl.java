package br.com.lojasJogos.ApiLojaJogosServices.Service.Impl;

import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoRequestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Jogo;
import br.com.lojasJogos.ApiLojaJogosServices.Repository.JogoRepository;
import br.com.lojasJogos.ApiLojaJogosServices.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JogoImpl implements JogoService {

        @Autowired
        private JogoRepository jogoRepository;

        @Override
        public List<Jogo> getTodosJogos() {
            return jogoRepository.findAll();
        }

        @Override
        public JogoResponseDto addJogo(JogoRequestDto jogoRequestDto) {

           Jogo jogo = new Jogo();

            jogo.setNome(jogoRequestDto.getNome());
            jogo.setDescricao(jogoRequestDto.getDescricao());

            Jogo jogoSaved = jogoRepository.save(jogo);

            JogoResponseDto jogoResponseDto = new JogoResponseDto();
            jogoResponseDto.setId(jogoSaved.getId());
            jogoResponseDto.setNome(jogoSaved.getNome());
            jogoResponseDto.setDescricao(jogoSaved.getDescricao());

            return jogoResponseDto;
        }

        @Override
        public JogoResponseDto updateJogo(Long id, JogoRequestDto jogoRequestDto) {
            Jogo jogo = jogoRepository.findById(id).get();

            jogo.setNome(jogoRequestDto.getNome());
            jogo.setDescricao(jogoRequestDto.getDescricao());

            Jogo jogoSaved = jogoRepository.save(jogo);

            JogoResponseDto jogoResponseDto = new JogoResponseDto();
            jogoResponseDto.setId(jogoSaved.getId());
            jogo.setNome(jogoSaved.getNome());
            jogoResponseDto.setDescricao(jogoSaved.getDescricao());
            return jogoResponseDto;
        }

        @Override
        public JogoResponseDto getByIdJogo(Long id) {

            JogoResponseDto jogoResponseDto = new JogoResponseDto();
            Optional<Jogo> jogo = jogoRepository.findById(id);

            if (jogo.isPresent()) {

                jogoResponseDto.setId(jogo.get().getId());
                jogoResponseDto.setNome(jogo.get().getNome());
                jogoResponseDto.setDescricao(jogo.get().getDescricao());
            }
            return jogoResponseDto;
        }

        @Override
        public void deleteJogo(Long id) {

           jogoRepository.deleteById(id);

        }

        public List<Jogo> getJogoByFilter(String nome, String descricao) {
            return jogoRepository.findByNomeDescricao(nome, descricao);
        }
    }


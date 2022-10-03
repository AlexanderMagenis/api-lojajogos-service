package br.com.lojasJogos.ApiLojaJogosServices.Controller;

import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoRequestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.JogoResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Jogo;
import br.com.lojasJogos.ApiLojaJogosServices.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @RequestMapping(value = "/jogos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Jogo>> getJogo() {

        List<Jogo> jogo = jogoService.getTodosJogos();
        return ResponseEntity.ok(jogo);

    }

    @RequestMapping(value = "/jogos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JogoResponseDto> addJogo(@RequestBody JogoRequestDto jogoRequestDto) {

        JogoResponseDto jogoResponseDto = jogoService.addJogo(jogoRequestDto);
        return new ResponseEntity(jogoResponseDto, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/jogos/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JogoResponseDto> updateJogo(@PathVariable(value = "id") Long id, @RequestBody JogoRequestDto jogoRequestDto) {

        JogoResponseDto jogoResponseDto = jogoService.updateJogo(id, jogoRequestDto);
        return new ResponseEntity(jogoResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/jogos/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteJogo(@PathVariable(value = "id") Long id) {

        jogoService.deleteJogo(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/jogos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JogoResponseDto> getByIdJogo(@PathVariable(value = "id") Long id) {

        JogoResponseDto jogo = jogoService.getByIdJogo(id);
        return ResponseEntity.ok(jogo);

    }

    @RequestMapping(value = "/jogos/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Jogo>> getJogo(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "descricao", required = false) String descricao) {

        List<Jogo> jogo = jogoService.getJogoByFilter(nome, descricao);
        return ResponseEntity.ok(jogo);

    }
}
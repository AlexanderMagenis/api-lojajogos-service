package br.com.lojasJogos.ApiLojaJogosServices.Controller;



import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResquestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Cliente;
import br.com.lojasJogos.ApiLojaJogosServices.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getCliente() {

        List<Cliente> clientes = clienteService.getTodosClientes();
        return ResponseEntity.ok(clientes);

    }

    @RequestMapping(value = "/clientes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteResponseDto> addCliente(@RequestBody ClienteResquestDto clienteRequestDto) {

        ClienteResponseDto clienteResponseDto = clienteService.addCliente(clienteRequestDto);
        return new ResponseEntity(clienteResponseDto, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteResponseDto> updateJogo(@PathVariable(value = "id") Long id, @RequestBody ClienteResquestDto clienteRequestDto) {

        ClienteResponseDto clienteResponseDto = clienteService.updateCliente(id, clienteRequestDto);
        return new ResponseEntity(clienteResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteJoCliente(@PathVariable(value = "id") Long id) {

        clienteService.deleteCliente(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteResponseDto> getByIdCliente(@PathVariable(value = "id") Long id) {

        ClienteResponseDto cliente = clienteService.getByIdCliente(id);
        return ResponseEntity.ok(cliente);

    }

    @RequestMapping(value = "/clientes/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(value = "nome", required = false) String nome) {

        List<Cliente> cliente = clienteService.getClienteByFilter(nome);
        return ResponseEntity.ok(cliente);
    }
}
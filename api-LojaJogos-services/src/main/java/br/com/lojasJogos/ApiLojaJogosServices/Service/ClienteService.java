package br.com.lojasJogos.ApiLojaJogosServices.Service;


import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResquestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Cliente;


import java.util.List;

public interface ClienteService {

    List<Cliente> getTodosClientes();

    ClienteResponseDto addCliente(ClienteResquestDto clienteRequestDto);

    ClienteResponseDto updateCliente(Long id, ClienteResquestDto clienteRequestDto);

    ClienteResponseDto getByIdCliente(Long id);

    void deleteCliente(Long id);

    List<Cliente> getClienteByFilter(String nome);
}

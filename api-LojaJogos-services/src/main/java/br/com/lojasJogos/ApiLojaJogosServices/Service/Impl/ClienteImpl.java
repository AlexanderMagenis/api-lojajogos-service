package br.com.lojasJogos.ApiLojaJogosServices.Service.Impl;


import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResponseDto;
import br.com.lojasJogos.ApiLojaJogosServices.Dto.ClienteResquestDto;
import br.com.lojasJogos.ApiLojaJogosServices.Model.Cliente;
import br.com.lojasJogos.ApiLojaJogosServices.Repository.ClienteRepository;
import br.com.lojasJogos.ApiLojaJogosServices.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteResponseDto addCliente(ClienteResquestDto clienteRequestDto) {

        Cliente cliente = new Cliente();

        cliente.setNome(clienteRequestDto.getNome());


        Cliente clienteSaved = clienteRepository.save(cliente);

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
        clienteResponseDto.setId(clienteSaved.getId());
        clienteResponseDto.setNome(clienteSaved.getNome());


        return clienteResponseDto;
    }

    @Override
    public ClienteResponseDto updateCliente(Long id, ClienteResquestDto clienteRequestDto) {
        Cliente cliente = clienteRepository.findById(id).get();

        cliente.setNome(clienteRequestDto.getNome());

        Cliente clienteSaved = clienteRepository.save(cliente);

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
        clienteResponseDto.setId(clienteSaved.getId());
        clienteResponseDto.setNome(clienteSaved.getNome());
        return clienteResponseDto;
    }

    @Override
    public ClienteResponseDto getByIdCliente(Long id) {

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {

            clienteResponseDto.setId(cliente.get().getId());
            clienteResponseDto.setNome(cliente.get().getNome());

        }
        return clienteResponseDto;
    }

    @Override
    public void deleteCliente(Long id) {

        clienteRepository.deleteById(id);

    }

    public List<Cliente> getClienteByFilter(String nome) {
        return clienteRepository.findByNome(nome);
    }
}

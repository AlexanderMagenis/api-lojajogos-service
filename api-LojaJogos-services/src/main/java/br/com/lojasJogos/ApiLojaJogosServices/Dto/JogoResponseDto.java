package br.com.lojasJogos.ApiLojaJogosServices.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoResponseDto {

    private Long id;

    private String nome;

    private String descricao;
}

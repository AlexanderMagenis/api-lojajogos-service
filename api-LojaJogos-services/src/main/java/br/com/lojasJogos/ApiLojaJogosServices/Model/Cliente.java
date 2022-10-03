package br.com.lojasJogos.ApiLojaJogosServices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "nome", nullable = false)
        private String nome;
}

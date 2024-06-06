package br.unipar.programacaointernet.pdvweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    private double valor;

    /**
     * CATEGORIA
     * O tipo do produto.
     * EX:
     * - Loja de Roupas: Camisas, Blusas, Calças...
     * - Loja de Eletronicos: Perifericos, Placa de Vídeo...
     */

    private String categoria;

}

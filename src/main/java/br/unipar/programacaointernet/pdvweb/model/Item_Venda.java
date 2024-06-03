package br.unipar.programacaointernet.pdvweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item_Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int quantidade;

    private Double valor_unitario;

    private Double valor_total;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;
}

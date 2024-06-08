package br.unipar.programacaointernet.pdvweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;
}

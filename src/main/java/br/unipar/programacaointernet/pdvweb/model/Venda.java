package br.unipar.programacaointernet.pdvweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String observacoes;

    private Date data;

    private double total;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda",      // Diz que está baseado no atributo venda da classe Item_venda
            fetch = FetchType.EAGER,    // Traz todos os Item_venda quando carregar a venda
            orphanRemoval = true)       // Apaga os Item_venda quando a Venda for Excluida
    private List<Item_Venda> item_venda;
}

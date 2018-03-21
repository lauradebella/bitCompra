package com.bitCompra.bitCompra.entities;

import javax.persistence.*;

@Entity
public class ConsultaPreco {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String fonte;
    private String preco;
    private String horario;

    public int getId() {
        return id;
    }

    public String getFonte() {
        return fonte;
    }

    public String getPreco() {
        return preco;
    }

    public String getHorario() {
        return horario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

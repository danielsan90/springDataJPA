package com.example.springBootHibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "squadra")
public class Squadra {

    //https://medium.com/stackavenue/why-to-use-service-layer-in-spring-mvc-5f4fc52643c0

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "colore")
    private String colore;

    /*@OneToMany(mappedBy = "squadra", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Giocatore> listaGiocatori;*/

    //perche ho commentato il oneToMany? fondamentalmente perche jackson impazzisce ma leggi:
    //https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

}

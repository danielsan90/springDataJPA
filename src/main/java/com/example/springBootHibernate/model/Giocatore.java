package com.example.springBootHibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "giocatore")
public class Giocatore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    //@JsonBackReference   <-Ricorsione infinita con problema Jackson JSON e Hibernate JPA:https://www.it-swarm.it/it/java/ricorsione-infinita-con-problema-jackson-json-e-hibernate-jpa/969553763/
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //<- SE USI LAZY NON TI STAMPA LA SQUADRA E VA IN ERRORE
    @JoinColumn(name = "id_squadra")
    //@JsonBackReference <- decommentare su vuoi reverseLookup
    private Squadra squadra;


    //@ManyToOne annotation to declare that it has a many-to-one relationship with the squadra entity
//@JoinColumn annotation to declare the foreign key column.


}
package com.example.springBootHibernate.controller;


import com.example.springBootHibernate.model.Squadra;
import com.example.springBootHibernate.service.GiocatoreServiceImpl;
import com.example.springBootHibernate.service.SquadraServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/torneo")
public class TorneoController {

    @Autowired
    SquadraServiceImpl squadraService;

    @Autowired
    GiocatoreServiceImpl giocatoreService;


    @Transactional
    @GetMapping(value = "/startTorneo" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String startTorneo(){
        log.debug("******************* START TORNEO ***************");
        System.out.println("******************* START TORNEO ***************");
        List<Squadra> squadre =getSquadre();
        log.debug("* squadre partecipanti ", squadre);

        System.out.println("* squadre partecipanti "+ squadre);
        //Boolean checkGiocatori= checkGiocatoriSquadra();

        //startGiornataUno(listaSquadra);

        //startGiornataDue(List squadra rimanenti)

        //startTriangolare(List squadra rimanenti)

        //printVincitrice();

        return "ok";
    }

    private List<Squadra> getSquadre() {

        return squadraService.getSquadre();//<- se richiamassi il Client (ovvero il controllerSquadra, fai getBody e ottieni la lista dio squadre)
    }

    private Boolean checkGiocatoriSquadra() {
        return false;
    }

}

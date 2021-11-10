package com.example.springBootHibernate.controller;


import com.example.springBootHibernate.exception.ResourceNotFoundException;
import com.example.springBootHibernate.model.Giocatore;
import com.example.springBootHibernate.model.Squadra;
import com.example.springBootHibernate.service.GiocatoreServiceImpl;
import com.example.springBootHibernate.service.SquadraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/giocatore")
public class GiocatoreController {

    @Autowired
    GiocatoreServiceImpl giocatoreService;

    @Autowired
    SquadraServiceImpl squadraService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "ok";
    }

    @GetMapping("/getGiocatori")//http://localhost:9090/giocatore/getGiocatori
    public ResponseEntity<?> getGiocatori(){
        //List<Giocatore> giocatori= giocatoreService.getGiocatori();
        //trova maggiorenni
        /*List<Giocatore> maggiorenni= giocatori.stream()
                .filter(x-> Period.between(x.getDataNascita(), LocalDate.now()).getYears() >18)
                .collect(Collectors.toList());*/

        //restituisce le squadre a cui appartengono  i giocatori
       /* Set<Squadra> squadre=giocatori.stream()
                .map(g -> g.getSquadra())
                .collect(Collectors.toSet());
        squadre.stream().forEach(System.out::println);*/
        return new ResponseEntity<>(giocatoreService.getGiocatori(),HttpStatus.OK);


    }

    /*
    {
    "nome":"daniele",
    "cognome":"verdi"

    }
     */
    @PostMapping("/saveGiocatore/{idSquadra}")//http://localhost:9090/giocatore/saveGiocatore/2
    public ResponseEntity<Giocatore> saveGiocatore(@PathVariable (value = "idSquadra") Long idSquadra,
                                                   @RequestBody Giocatore giocatore){
        Squadra squadra=squadraService.getById(idSquadra);
        giocatore.setSquadra(squadra);
        return new ResponseEntity<Giocatore>(giocatoreService.saveGiocatore(giocatore), HttpStatus.CREATED);
    }

    //http://localhost:9090/giocatore/getGiocatore
    @GetMapping(value = "/getGiocatore/{idGiocatore}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Giocatore> getGiocatore(@PathVariable("idGiocatore") Long idGiocatore) {
        return new ResponseEntity<Giocatore>(giocatoreService.getById(idGiocatore), HttpStatus.OK);
    }


    @GetMapping(value = "/getGiocatorSquadra/{idSquadra}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Giocatore> getGiocatoriSquadra(@PathVariable("idSquadra") Long idSquadra) {
        return giocatoreService.getGiocatoriSquadra(idSquadra);
    }


}

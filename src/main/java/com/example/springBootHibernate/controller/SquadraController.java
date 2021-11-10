package com.example.springBootHibernate.controller;

import com.example.springBootHibernate.model.Squadra;
import com.example.springBootHibernate.service.SquadraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/squadra")
public class SquadraController {

    @Autowired
    SquadraServiceImpl squadraService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "ok";
    }

    @GetMapping("/getSquadre")//http://localhost:9090/squadra/getSquadre
    public ResponseEntity<?> getSquadre(){
        return new ResponseEntity<>(squadraService.getSquadre(),HttpStatus.OK);

    }

    /*
    {
    "nome":"broccoli",
    "colore":"verdi"
    }
     */
    @PostMapping("/saveSquadra")
    public ResponseEntity<Squadra> saveSquadra(
            @RequestBody Squadra squadra){
        return new ResponseEntity<Squadra>(squadraService.saveSquadra(squadra), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getSquadra/{idSquadra}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Squadra> saveSquadra(
            @PathVariable("idSquadra") Long idSquadra) {

        return new ResponseEntity<Squadra>(squadraService.getById(idSquadra), HttpStatus.OK);

    }
    @DeleteMapping("/deleteSquadra")
    public void deleteSquadra(
            @RequestParam("idSquadra") Long idSquadra){
        squadraService.deleteSquadra(idSquadra);

    }
    //http://localhost:9090/squadra/updateSquadra
    /*
    {
    "id":2,
    "nome":"verdura",
    "colore":"verdi"
    }
     */
    @PostMapping(value="/updateSquadra")
    public ResponseEntity<Squadra> updateSquadra(@RequestBody Squadra squadra){
        return new ResponseEntity<Squadra>(squadraService.updateSquadra(squadra), HttpStatus.OK);

    }




}

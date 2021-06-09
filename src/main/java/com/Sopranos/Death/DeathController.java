package com.Sopranos.Death;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeathController {

  @Autowired
  private DeathService deathService;

  @RequestMapping("/")
  public String hello(){
    return "yo";
  }

  @RequestMapping("/deaths")
  public List<Death> getAllDeaths(){
    return deathService.getAllDeaths();
  }
  
  // THIS IS WHERE YOU LEFT OFF. THE BENEATH COMMENTED METHOD IS THE 
  // THE OLD SYSTEM FOR A SIMPLE GET. NOW YOU'RE TRYING TO USE PARAMS
  // http://localhost:8080/death?season=2&episode=213 returns "test" as expected
  @RequestMapping(value = "/death", method = RequestMethod.GET)
  public List<Death> getDeaths(
    @RequestParam(required=false,name="season") String season){
      return deathService.getDeaths(season);
  }

  /*
  @RequestMapping("/deaths/{id}")
  // the path variable annotation tells spring to use the id argument
  public Death getDeath(@PathVariable int id){
    return deathService.getDeath(id);
  } */

  @RequestMapping(method=RequestMethod.POST, value= "/deaths")
  public void addDeath(@RequestBody Death death){
    deathService.addDeath(death);
  }

  @RequestMapping(method=RequestMethod.PUT, value= "/deaths/{id}")
  public void updateDeath(@RequestBody Death death, @PathVariable int id){
    deathService.updateDeath(id, death);
  }

  @RequestMapping(method=RequestMethod.DELETE, value="/deaths/{id}")
  // the path variable annotation tells spring to use the id argument
  public void deleteDeath(@PathVariable int id){
    deathService.deleteDeath(id);
  }
  
}

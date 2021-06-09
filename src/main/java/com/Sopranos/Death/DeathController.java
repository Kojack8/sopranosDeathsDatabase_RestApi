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
  
  @RequestMapping(value = "/death", method = RequestMethod.GET)
  public List<Death> getDeaths(
    @RequestParam(required=false,name="firstName") String firstName,
    @RequestParam(required=false,name="lastName") String lastName,
    @RequestParam(required=false,name="nickName") String nickName,
    @RequestParam(required=false,name="season") String season,
    @RequestParam(required=false,name="episode") String episode){
      // single gets are done. need to make all the multiple variable parameter functions
      if (episode == null && firstName == null && lastName == null && nickName == null){
        return deathService.getDeathsBySeason(season);
      } else if (season == null && firstName == null && lastName == null && nickName == null){
        return deathService.getDeathsByEpisode(episode);
      } else if (season == null && episode == null && lastName == null && nickName == null){
        return deathService.getDeathsByFirstName(firstName);
      } else if (season == null && episode == null && lastName == null && firstName == null){
        return deathService.getDeathsByNickName(nickName);
      } else if (season == null && episode == null && firstName == null && nickName == null){
        return deathService.getDeathsByLastName(lastName);
      }

      // this is just a placeholder for the required return statement
      return deathService.getDeathsBySeason(season);
      
  }

  
  @RequestMapping("/deaths/{id}")
  // the path variable annotation tells spring to use the id argument
  public Death getDeath(@PathVariable int id){
    return deathService.getDeath(id);
  } 

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

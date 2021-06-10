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
      // three params gets are done. just need 4
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
      } else if (nickName == null && season == null && episode == null){
        return deathService.getDeathsByFirstandLast(firstName, lastName);
      } else if (lastName == null && season == null && episode == null){
        return deathService.getDeathsByFirstandNick(firstName, nickName);
      } else if (lastName == null && nickName == null && episode == null){
        return deathService.getDeathsByFirstandSeason(firstName, season);
      } else if (lastName == null && nickName == null && season == null){
        return deathService.getDeathsByFirstandEpisode(firstName, episode);
      } else if (season == null && episode == null && firstName == null){
        return deathService.getDeathsByLastandNick(lastName, nickName);
      } else if (nickName == null && episode == null && firstName == null){
        return deathService.getDeathsByLastandSeason(lastName, season);
      } else if (nickName == null && season == null && firstName == null){
        return deathService.getDeathsByLastandEpisode(lastName, episode);
      } else if (firstName == null && lastName == null && episode == null){
        return deathService.getDeathsByNickandSeason(nickName, season);
      } else if (firstName == null && lastName == null && season == null){
        return deathService.getDeathsByNickandEpisode(nickName, episode);
      } else if (firstName == null && lastName == null && nickName == null){
        return deathService.getDeathsBySeasonandEpisode(season, episode);
      } else if (season == null && episode == null){
        return deathService.getDeathsByFirstLastNick(firstName, lastName, nickName);
      } else if (nickName == null && episode == null){
        return deathService.getDeathsByFirstLastSeason(firstName, lastName, season);
      } else if (nickName == null && season == null){
        return deathService.getDeathsByFirstLastEpisode(firstName, lastName, episode);
      } else if (firstName == null && episode == null){
        return deathService.getDeathsByLastNickSeason(lastName, nickName, season);
      } else if (firstName == null && episode == null){
        return deathService.getDeathsByLastNickEpisode(lastName, nickName, episode);
      } else if (firstName == null && lastName == null){
        return deathService.getDeathsByNickSeasonEpisode(nickName, season, episode);
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

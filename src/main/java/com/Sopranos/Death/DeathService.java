package com.Sopranos.Death;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeathService {
  
  @Autowired
  private DeathRepository deathRepository;

  public List<Death> getAllDeaths(){
    List<Death> deaths = new ArrayList<>();
    deathRepository.findAll()
    .forEach(deaths::add);
    return deaths;
  }
  
  public List<Death> getDeathsBySeason(String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathBySeason(season));
    return deaths; 
  } 

  public List<Death> getDeathsByEpisode(String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByEpisode(episode));
    return deaths; 
  }
  
  public List<Death> getDeathsByFirstName(String firstName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstName(firstName));
    return deaths; 
  } 

  public List<Death> getDeathsByLastName(String lastName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastName(lastName));
    return deaths; 
  } 

  public List<Death> getDeathsByNickName(String nickName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByNickName(nickName));
    return deaths; 
  } 

  public List<Death> getDeathsBySeasonAndEpisode(String season, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathBySeasonAndEpisode(season, episode));
    return deaths; 
  } 


  public Death getDeath(int id){
    return deathRepository.findById(id).get();
  }

  public void addDeath(Death death){  
    deathRepository.save(death);
  }

  public void updateDeath(int id, Death death){  
    deathRepository.save(death);
  }

  public void deleteDeath(int id){
    deathRepository.deleteById(id);
  }

}

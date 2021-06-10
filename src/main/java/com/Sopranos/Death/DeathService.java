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

  public List<Death> getDeathsByFirstandLast(String firstName, String lastName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstAndLast(firstName, lastName));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstandNick(String firstName, String nickName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstAndNick(firstName, nickName));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstandSeason(String firstName, String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstAndSeason(firstName, season));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstandEpisode(String firstName, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstAndEpisode(firstName, episode));
    return deaths; 
  } 

  public List<Death> getDeathsByLastandNick(String lastName, String nickName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastAndNick(lastName, nickName));
    return deaths; 
  } 

  public List<Death> getDeathsByLastandSeason(String lastName, String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastAndSeason(lastName, season));
    return deaths; 
  } 

  public List<Death> getDeathsByLastandEpisode(String lastName, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastAndEpisode(lastName, episode));
    return deaths; 
  } 

  public List<Death> getDeathsByNickandSeason(String lastName, String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByNickAndSeason(lastName, season));
    return deaths; 
  } 

  public List<Death> getDeathsByNickandEpisode(String lastName, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByNickAndEpisode(lastName, episode));
    return deaths; 
  } 

  public List<Death> getDeathsBySeasonandEpisode(String season, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathBySeasonAndEpisode(season, episode));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstLastNick(String firstName, String lastName, String nickName){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstLastNick(firstName, lastName, nickName));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstLastSeason(String firstName, String lastName, String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstLastSeason(firstName, lastName, season));
    return deaths; 
  } 

  public List<Death> getDeathsByFirstLastEpisode(String firstName, String lastName, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByFirstLastEpisode(firstName, lastName, episode));
    return deaths; 
  } 

  public List<Death> getDeathsByLastNickSeason(String lastName, String nickName, String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastNickSeason(lastName, nickName, season));
    return deaths; 
  } 

  public List<Death> getDeathsByLastNickEpisode(String lastName, String nickName, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByLastNickEpisode(lastName, nickName, episode));
    return deaths; 
  } 

  public List<Death> getDeathsByNickSeasonEpisode(String nickName, String season, String episode){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathByNickSeasonEpisode(nickName, season, episode));
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

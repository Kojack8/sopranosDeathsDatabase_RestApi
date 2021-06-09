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

  public List<Death> getDeaths(String season){
    List<Death> deaths = new ArrayList<>(deathRepository.findDeathBySeason(season));
    //rrayList<Foo> newList = srcCollection.stream().collect(toCollection(ArrayList::new));

    //deathRepository.findDeathBySeason(season)
    
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

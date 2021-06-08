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
}

package com.Sopranos.Death;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
  
}

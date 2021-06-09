package com.Sopranos.Death;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Death {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private String season;
  @Column(nullable = false)
  private String episode;

  public Death(){

  }

  public Death(int id, String firstName, String lastName, String description, String season, String episode){
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
    this.season = season;
    this.episode = episode;
  }

  public int getId(){
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName(){
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSeason(){
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public String getEpisode(){
    return episode;
  }

  public void setEpisode(String episode) {
    this.episode = episode;
  }
  
}

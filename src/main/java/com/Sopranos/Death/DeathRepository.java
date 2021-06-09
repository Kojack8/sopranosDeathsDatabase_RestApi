package com.Sopranos.Death;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeathRepository extends CrudRepository<Death, Integer> {
  @Query("SELECT u FROM Death u WHERE u.season = :season")
    Collection<Death> findDeathBySeason(@Param("season")  String season);
  
}

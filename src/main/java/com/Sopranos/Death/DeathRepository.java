package com.Sopranos.Death;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeathRepository extends CrudRepository<Death, Integer> {
  
  @Query("SELECT u FROM Death u WHERE u.season = :season")
    Collection<Death> findDeathBySeason(@Param("season") String season);

  @Query("SELECT u FROM Death u WHERE u.episode = :episode")
    Collection<Death> findDeathByEpisode(@Param("episode") String episode);

  @Query("SELECT u FROM Death u WHERE u.firstName = :firstName")
    Collection<Death> findDeathByFirstName(@Param("firstName") String firstName);

    @Query("SELECT u FROM Death u WHERE u.lastName = :lastName")
    Collection<Death> findDeathByLastName(@Param("lastName") String lastName);

  @Query("SELECT u FROM Death u WHERE u.nickName = :nickName")
    Collection<Death> findDeathByNickName(@Param("nickName") String nickName);

  @Query("SELECT u FROM Death u WHERE u.firstName = :firstName and u.lastName = :lastName")
    Collection<Death> findDeathByFirstAndLast(@Param("firstName") String firstName, 
    @Param("lastName") String lastName);

  @Query("SELECT u FROM Death u WHERE u.firstName = :firstName and u.nickName = :nickName")
    Collection<Death> findDeathByFirstAndNick(@Param("firstName") String firstName, 
    @Param("nickName") String nickName);

  @Query("SELECT u FROM Death u WHERE u.firstName = :firstName and u.season = :season")
    Collection<Death> findDeathByFirstAndSeason(@Param("firstName") String firstName, 
    @Param("season") String season);

  @Query("SELECT u FROM Death u WHERE u.firstName = :firstName and u.episode = :episode")
    Collection<Death> findDeathByFirstAndEpisode(@Param("firstName") String firstName, 
    @Param("episode") String episode);

  @Query("SELECT u FROM Death u WHERE u.lastName = :lastName and u.nickName = :nickName")
    Collection<Death> findDeathByLastAndNick(@Param("lastName") String lastName, 
    @Param("nickName") String nickName);

  @Query("SELECT u FROM Death u WHERE u.lastName = :lastName and u.season = :season")
    Collection<Death> findDeathByLastAndSeason(@Param("lastName") String lastName, 
    @Param("season") String season);

  @Query("SELECT u FROM Death u WHERE u.lastName = :lastName and u.episode = :episode")
    Collection<Death> findDeathByLastAndEpisode(@Param("lastName") String lastName, 
    @Param("episode") String episode);

  @Query("SELECT u FROM Death u WHERE u.nickName = :nickName and u.season = :season")
    Collection<Death> findDeathByNickAndSeason(@Param("nickName") String nickName, 
    @Param("season") String season);

  @Query("SELECT u FROM Death u WHERE u.nickName = :nickName and u.episode = :episode")
    Collection<Death> findDeathByNickAndEpisode(@Param("nickName") String nickName, 
    @Param("episode") String episode);

  @Query("SELECT u FROM Death u WHERE u.season = :season and u.episode = :episode")
    Collection<Death> findDeathBySeasonAndEpisode(@Param("season") String season, 
    @Param("episode") String episode);
  
}

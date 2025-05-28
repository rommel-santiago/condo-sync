package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.User;
import com.synctrack.condosync.model.WorkPermit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u " +
      "where u.email = :email " +
      "and  u.activeFlag = 'Y' " )
  public Optional<User> findByEmail(@Param("email") String email);

}

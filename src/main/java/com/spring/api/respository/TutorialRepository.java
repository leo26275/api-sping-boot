package com.spring.api.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.api.model.*;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}

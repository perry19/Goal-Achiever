package com.PerryTech.Perry.Repositories;

import com.PerryTech.Perry.Model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    //List<Goal> findByTitleContaining(String title);
}

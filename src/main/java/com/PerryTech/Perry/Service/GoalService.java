package com.PerryTech.Perry.Service;

import com.PerryTech.Perry.Model.Goal;
import com.PerryTech.Perry.Repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public Goal saveGoal(Goal goalRequest){
        Goal goal = new Goal();
        goal.setBeginDate(goalRequest.getBeginDate());
        goal.setEndDate(goalRequest.getEndDate());
        goal.setObjectives(goalRequest.getObjectives());
        goal.setReminder(goalRequest.getReminder());
        goal.setReminderInterval(goalRequest.getReminderInterval());
        goal.setValidated(goalRequest.getValidated());
        return goalRepository.save(goal);
    }
    public List<Goal> getAllGoal(){
        return goalRepository.findAll();
    }

    public Goal getGoalById(long goalId) {

        Optional <Goal> goalRepositoryById = this.goalRepository.findById(goalId);

        if (goalRepositoryById.isPresent()) {
            return goalRepositoryById.get();
        } else {
            throw new IllegalStateException("Goal with ID " + goalId + " Does not Exist");
        }
    }

    public void deleteById(Long id){
        boolean exists = goalRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Goal with ID " + id + " Does not Exist");
        }
        goalRepository.deleteById(id);
    }

public Goal updateGoal(Goal goal) {
    Optional<Goal> goalId = this.goalRepository.findById(goal.getId());

    if (goalId.isPresent()) {
        Goal goalupdate = goalId.get();
        goalupdate.setId(goal.getId());
        goalupdate.setObjectives(goal.getObjectives());
        goalupdate.setReminder(goal.getReminder());
        goalupdate.setReminderInterval(goal.getReminderInterval());
        goalupdate.setBeginDate(goal.getBeginDate());
        goalupdate.setEndDate(goal.getEndDate());
        goalupdate.setValidated(goal.getValidated());
        goalRepository.save(goalupdate);
        return  goalupdate;
    } else {
        throw new IllegalStateException("Goal with ID " + goalId + "Does not Exist");
    }
}
}

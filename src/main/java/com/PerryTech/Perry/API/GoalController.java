package com.PerryTech.Perry.API;

import com.PerryTech.Perry.Model.Goal;
import com.PerryTech.Perry.Service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/goals")
    public List<Goal> getAllGoals(){
        return goalService.getAllGoal();
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity <Goal> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(goalService.getGoalById(id));
    }

    @PostMapping (value = "/goals")
    public Goal saveGoal(@RequestBody Goal goal){
       return goalService.saveGoal(goal);
    }

    @DeleteMapping("/goals/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteById(id);
    }

    @PutMapping("/goals/{id}")
    public ResponseEntity < Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        goal.setId(id);
        return ResponseEntity.ok().body(this.goalService.updateGoal(goal));
    }
}

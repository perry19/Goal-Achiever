package com.PerryTech.Perry.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "goal")
@Data
public class Goal {
    @Id
    @SequenceGenerator(
            name = "goal_sequence",
            sequenceName = "goal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "goal_sequence"
    )
    private Long id;
    private String objectives;
    private Date beginDate;
    private Date endDate;
    private String reminder;
    private int reminderInterval;
    private Boolean validated;

    public Goal() {
    }
}




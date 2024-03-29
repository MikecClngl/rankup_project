package com.ing.rankup_b.task;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ing.rankup_b.adminManageTeam.AdminManageTeam;
import com.ing.rankup_b.taskCompleted.TaskCompleted;
import com.ing.rankup_b.taskForSpecificUser.TaskForSpecificUser;
import com.ing.rankup_b.team.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class Task {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_task")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Il nome non può essere vuoto")
    private String name;

    @Column(name = "points")
    @NotEmpty(message = "Il punteggio non può essere vuoto")
    private int points;

    @Column(name = "description")
    @NotEmpty(message = "La descrizione non può essere vuota")
    private String description;

    @Column(name = "end_date")
    @NotEmpty(message = "La data di fine non può essere vuota")
    private Date endDate;

    @Column(name = "start_date")
    @NotEmpty(message = "La data di inizio non può essere vuota")
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "id_team")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Team team;
    
    @ManyToOne
    @JoinColumn(name = "id_admin")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AdminManageTeam admin;

    @Column(name = "tasksCompleted")
    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<TaskCompleted> tasksCompleted;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private Set<TaskForSpecificUser> taskForSpecificUsers;
}

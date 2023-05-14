package com.ing.rankup_b.user;

import java.util.List;
import java.util.Set;

import com.ing.rankup_b.notification.Notification;
import com.ing.rankup_b.ruleCompleted.RuleCompleted;
import com.ing.rankup_b.task.Task;
import com.ing.rankup_b.taskCompleted.TaskCompleted;
import com.ing.rankup_b.userGetPrize.UserGetPrize;
import com.ing.rankup_b.userJoinsTeam.UserJoinsTeam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Il nome non può essere vuoto")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Il cognome non può essere vuoto")
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "La mail non può essere vuota")
    private String email;

    @Column(name = "username")
    @NotEmpty(message = "L'username non può essere vuoto")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "La password non può essere vuota")
    private String password;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "user")
    @Column(name = "taskCompleted")
    private Set<TaskCompleted> taskCompleted;

    @OneToMany(mappedBy = "user")
    @Column(name = "ruleCompleted")
    private Set<RuleCompleted> ruleCompleted;

    @OneToMany(mappedBy = "user")
    @Column(name = "notidfications")
    private Set<Notification> notifications;

    @ManyToMany(mappedBy = "specificUsers")
    @Column(name = "assigned_tasks")
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "user")
    private Set<UserJoinsTeam> userJoinsTeams;

    @OneToMany(mappedBy = "user")
    private Set<UserGetPrize> userGetPrizes;
}
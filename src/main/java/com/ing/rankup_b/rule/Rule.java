package com.ing.rankup_b.rule;

import java.util.List;

import com.ing.rankup_b.adminManageTeam.AdminManageTeam;
import com.ing.rankup_b.ruleCompleted.RuleCompleted;
import com.ing.rankup_b.team.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "rule")
public class Rule {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Il nome non può essere vuoto")
    private String name;

    @Column(name = "points")
    @NotNull(message = "Il punteggio non può essere vuoto")
    private int points;

    @Column(name = "description")
    @NotEmpty(message = "La descrizione non può essere vuota")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "team"),
            @JoinColumn(name = "admin")
        }
    )
    private AdminManageTeam admin;

    @Column(name = "rulesCompleted")
    @OneToMany(mappedBy = "rule")
    private List<RuleCompleted> rulesCompleted;
}
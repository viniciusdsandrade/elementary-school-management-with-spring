package com.restful.elementary.school.management.entity;

/*
Grupos: Representam um grupo de alunos. Um periodo. Um tempo
Um grupo tem uma lista de estudantes, mas um estudante pertence a um grupo
 */


import com.restful.elementary.school.management.entity.enums.Period;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

/*
Turma: 
Representa uma Lista de Alunos(Uma sala)
Uma lista de aulas
Um ano Letivo (periodo)
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Group")
@Table(name = "tb_group",
        schema = "db_elementary_school_management")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Period period;

    // uma turma possui um grupo de alunos
    @OneToMany(mappedBy = "group")
    @Setter(AccessLevel.NONE)
    private List<Student> students = new ArrayList<>();

    // Um grupo de uma lista de Aulas
    @OneToMany(mappedBy = "group")
    @Setter(AccessLevel.NONE)
    private Set<Class> classes = new HashSet<>();

    private LocalDate startDateTime; // Data de inicio de ano letivo para essa turma
    private LocalDate endDateTime; // Data de fim de ano letivo para essa turma

    private String observation;

    public Group(Group group) {
        this.id = group.id;
        this.period = group.period;
        this.students = new ArrayList<>(group.students);
        this.classes = new HashSet<>(group.classes);
        this.startDateTime = group.startDateTime;
        this.endDateTime = group.endDateTime;
        this.observation = group.observation;
    }

    @Override
    public Object clone() {

        Group group;

        try {
            group = (Group) super.clone();
        } catch (CloneNotSupportedException e) {
            group = new Group(this);
        }

        return group;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Group that = (Group) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.startDateTime, that.startDateTime) &&
                Objects.equals(this.endDateTime, that.endDateTime) &&
                Objects.equals(this.students, that.students);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.startDateTime == null) ? 0 : this.startDateTime.hashCode());
        hash *= prime + ((this.endDateTime == null) ? 0 : this.endDateTime.hashCode());

        for (Student student : this.students) hash *= prime + ((student == null) ? 0 : student.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"period\": \"" + this.period + "\",\n" +
                "  \"students\": " + this.students.toString() + ",\n" +
                "  \"classes\": " + this.classes.toString() + ",\n" +
                "  \"startDateTime\": \"" + this.startDateTime + "\",\n" +
                "  \"endDateTime\": \"" + this.endDateTime + "\",\n" +
                "  \"observation\": \"" + this.observation + "\"\n" +
                "}";
    }
}
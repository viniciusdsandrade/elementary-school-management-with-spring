package com.restful.elementary.school.management.entity;

import com.restful.elementary.school.management.dto.classes.DadosCadastroClass;
import com.restful.elementary.school.management.entity.enums.Discipline;
import com.restful.elementary.school.management.entity.enums.Room;
import com.restful.elementary.school.management.entity.enums.Time;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/*
Aulas:
Representam um grupo de alunos,
um professor, 
um local, 
um horário.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Classes")
@Table(name = "tb_classes",
        schema = "db_elementary_school_management")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Uma aula tem um professor, mas um professor pode ter várias aulas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // Uma aula tem uma Turma (Grupo de alunos), mas um grupo de alunos pode ter várias aulas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    //Turno (Manhã, Tarde, Noite)
    @Enumerated(EnumType.STRING)
    private Time time;

    //Sala Física (A, B, C)
    @Enumerated(EnumType.STRING)
    private Room room;

    // A disciplina ministrada deve ser uma das disciplinas ministrada pelo professor
    @Enumerated(EnumType.STRING)
    private Discipline discipline;

    private LocalDate startDateTime;     //Horário de início
    private LocalDate endDateTime;     //Horário de término

    public Classes(DadosCadastroClass dadosCadastroClass) {
        this.teacher = dadosCadastroClass.teacher();
        this.group = dadosCadastroClass.group();
        this.time = dadosCadastroClass.time();
        this.room = dadosCadastroClass.room();
        this.discipline = dadosCadastroClass.discipline();
        this.startDateTime = dadosCadastroClass.startDateTime();
        this.endDateTime = dadosCadastroClass.endDateTime();
    }

    //Construtor de cópia
    public Classes(Classes copy) {
        this.id = copy.id;
        this.teacher = copy.teacher;
        this.group = copy.group;
        this.time = copy.time;
        this.room = copy.room;
        this.discipline = copy.discipline;
        this.startDateTime = copy.startDateTime;
        this.endDateTime = copy.endDateTime;
    }

    @Override
    public Object clone() {

        Classes clone = null;

        try {
            clone = new Classes(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Classes that = (Classes) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.teacher, that.teacher) &&
                Objects.equals(this.group, that.group) &&
                Objects.equals(this.time, that.time) &&
                Objects.equals(this.room, that.room) &&
                Objects.equals(this.discipline, that.discipline) &&
                Objects.equals(this.startDateTime, that.startDateTime) &&
                Objects.equals(this.endDateTime, that.endDateTime);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.teacher == null) ? 0 : this.teacher.hashCode());
        hash *= prime + ((this.group == null) ? 0 : this.group.hashCode());
        hash *= prime + ((this.time == null) ? 0 : this.time.hashCode());
        hash *= prime + ((this.room == null) ? 0 : this.room.hashCode());
        hash *= prime + ((this.discipline == null) ? 0 : this.discipline.hashCode());
        hash *= prime + ((this.startDateTime == null) ? 0 : this.startDateTime.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"teacher\": " + this.teacher + ",\n" +
                "  \"group\": " + this.group + ",\n" +
                "  \"time\": \"" + this.time + "\",\n" +
                "  \"room\": \"" + this.room + "\",\n" +
                "  \"discipline\": \"" + this.discipline + "\",\n" +
                "  \"startDateTime\": \"" + this.startDateTime + "\",\n" +
                "  \"endDateTime\": \"" + this.endDateTime + "\"\n" +
                "}";
    }
}
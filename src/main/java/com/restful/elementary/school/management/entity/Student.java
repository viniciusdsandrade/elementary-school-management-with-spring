package com.restful.elementary.school.management.entity;

import com.restful.elementary.school.management.dto.student.DadosCadastroStudent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Student")
@Table(name = "tb_student",
        schema = "db_elementary_school_management",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_student_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_student_cpf", columnNames = "cpf")
        }
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String parentName;
    private String parentEmail;
    private String parentPhoneNumber;

    //Um aluno pertence a uma Turma
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Embedded
    private Address address;

    private String allergies;
    private String medicalConditions;

    public Student(DadosCadastroStudent dadosCadastroStudent) {
        this.name = dadosCadastroStudent.name();
        this.email = dadosCadastroStudent.email();
        this.cpf = dadosCadastroStudent.cpf();
        this.birthDate = dadosCadastroStudent.birthDate();
        this.parentName = dadosCadastroStudent.parentName();
        this.parentEmail = dadosCadastroStudent.parentEmail();
        this.parentPhoneNumber = dadosCadastroStudent.parentPhoneNumber();
        this.address = new Address(dadosCadastroStudent.address());
        this.allergies = dadosCadastroStudent.allergies();
        this.medicalConditions = dadosCadastroStudent.medicalConditions();
    }

    //Construtor de Cópia
    public Student(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.email = student.email;
        this.cpf = student.cpf;
        this.birthDate = student.birthDate;
        this.parentName = student.parentName;
        this.parentEmail = student.parentEmail;
        this.parentPhoneNumber = student.parentPhoneNumber;
        this.address = new Address(student.address);
        this.group = student.group;
        this.allergies = student.allergies;
        this.medicalConditions = student.medicalConditions;
    }

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Student(this);
        }
    }

    @Override
    public final boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Objects.equals(this.id, student.id) &&
                Objects.equals(this.cpf, student.cpf);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.cpf == null) ? 0 : this.cpf.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"email\": \"" + this.email + "\",\n" +
                "  \"cpf\": \"" + this.cpf + "\",\n" +
                "  \"birthDate\": \"" + this.birthDate + "\",\n" +
                "  \"parentName\": \"" + this.parentName + "\",\n" +
                "  \"parentEmail\": \"" + this.parentEmail + "\",\n" +
                "  \"parentPhoneNumber\": \"" + this.parentPhoneNumber + "\",\n" +
                "  \"address\": \"" + this.address + "\",\n" +
                "  \"allergies\": \"" + this.allergies + "\",\n" +
                "  \"medicalConditions\": \"" + this.medicalConditions + "\"\n" +
                " \"group\": \"" + this.group + "\"\n" +
                "}";
    }
}
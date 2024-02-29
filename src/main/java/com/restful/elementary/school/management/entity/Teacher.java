package com.restful.elementary.school.management.entity;

import com.restful.elementary.school.management.dto.teacher.DadosCadastroTeacher;
import com.restful.elementary.school.management.entity.enums.Discipline;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Teacher")
@Table(name = "tb_teacher",
        schema = "db_elementary_school_management",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_teacher_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_teacher_cpf", columnNames = "cpf")
        }
)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

    @Embedded
    private Address address;

    // Um professor tem várias aulas, mas uma aula tem um professor
    @OneToMany(mappedBy = "teacher")
    @Setter(AccessLevel.NONE)
    private List<Classes> classes;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Discipline.class)
    @Setter(AccessLevel.NONE)
    private List<Discipline> disciplines;

    /**
     * Construtor que cria um novo professor a partir dos dados de cadastro.
     *
     * @param dadosCadastroTeacher os dados de cadastro do professor
     */
    public Teacher(DadosCadastroTeacher dadosCadastroTeacher) {
        this.name = dadosCadastroTeacher.name();
        this.email = dadosCadastroTeacher.email();
        this.cpf = dadosCadastroTeacher.cpf();
        this.birthDate = dadosCadastroTeacher.birthDate();
        this.disciplines = dadosCadastroTeacher.disciplines();
        this.address = new Address(dadosCadastroTeacher.address());
    }

    /**
     * Construtor de cópia que cria um novo professor a partir de um professor existente.
     *
     * @param teacher o professor a ser copiado
     */
    public Teacher(Teacher teacher) {
        this.id = teacher.id;
        this.name = teacher.name;
        this.email = teacher.email;
        this.cpf = teacher.cpf;
        this.birthDate = teacher.birthDate;
        this.address = new Address(teacher.address);
        this.disciplines = new ArrayList<>(teacher.disciplines);
        this.classes = new ArrayList<>(teacher.classes);
    }

    /**
     * Cria uma cópia do professor atual.
     *
     * @return uma cópia do professor atual
     * @throws AssertionError se a clonagem não for suportada
     */
    @Override
    public Teacher clone() {
        try {
            Teacher cloned = (Teacher) super.clone();
            cloned.disciplines = new ArrayList<>(this.disciplines);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    /**
     * Verifica se o professor atual é igual a outro objeto.
     *
     * @param o o objeto a ser comparado com o professor atual
     * @return true se o objeto especificado é igual ao professor atual
     */
    @Override
    public final boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Teacher that = (Teacher) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.cpf, that.cpf);
    }

    /**
     * Retorna um valor de hash baseado nos atributos do professor.
     *
     * @return um valor de hash para o professor
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + (this.id == null ? 0 : this.id.hashCode());
        hash *= prime + (this.email == null ? 0 : this.email.hashCode());
        hash *= prime + (this.cpf == null ? 0 : this.cpf.hashCode());

        if (hash < 0) hash *= -1;

        return hash;
    }

    /**
     * Retorna uma representação em string do professor no formato JSON.
     *
     * @return uma representação em string do professor
     */
    @Override
    public final String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"email\": \"" + this.email + "\",\n" +
                "  \"cpf\": \"" + this.cpf + "\",\n" +
                "  \"birthDate\": \"" + this.birthDate + "\",\n" +
                "  \"disciplines\": " + this.disciplines + "\n" +
                "  \"address\": " + this.address + "\n" +
                "   \"classes\": " + this.classes + "\n" +
                "}";
    }
}

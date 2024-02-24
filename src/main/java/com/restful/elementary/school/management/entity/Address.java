package com.restful.elementary.school.management.entity;

import com.restful.elementary.school.management.dto.address.DadosCadastroEndereco;
import jakarta.persistence.*;

import lombok.*;


@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address",
        schema = "db_elementary_school_management")
public class Address {

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(DadosCadastroEndereco dadosCadastroEndereco) {
        this.street = dadosCadastroEndereco.street();
        this.number = dadosCadastroEndereco.number();
        this.complement = dadosCadastroEndereco.complement();
        this.neighborhood = dadosCadastroEndereco.neighborhood();
        this.city = dadosCadastroEndereco.city();
        this.state = dadosCadastroEndereco.state();
        this.country = dadosCadastroEndereco.country();
        this.zipCode = dadosCadastroEndereco.zipCode();
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t\"street\": \"" + street + "\",\n" +
                "\t\t\"number\": \"" + number + "\",\n" +
                "\t\t\"complement\": \"" + complement + "\",\n" +
                "\t\t\"neighborhood\": \"" + neighborhood + "\",\n" +
                "\t\t\"city\": \"" + city + "\",\n" +
                "\t\t\"state\": \"" + state + "\",\n" +
                "\t\t\"country\": \"" + country + "\",\n" +
                "\t\t\"zipCode\": \"" + zipCode + "\"\n" +
                "\t}";
    }
}

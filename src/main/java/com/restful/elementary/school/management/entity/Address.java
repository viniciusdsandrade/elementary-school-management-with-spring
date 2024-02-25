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

    public Address(Address address) {
        this.street = address.street;
        this.number = address.number;
        this.complement = address.complement;
        this.neighborhood = address.neighborhood;
        this.city = address.city;
        this.state = address.state;
        this.country = address.country;
        this.zipCode = address.zipCode;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((street == null) ? 0 : street.hashCode());
        hash *= prime + ((number == null) ? 0 : number.hashCode());
        hash *= prime + ((zipCode == null) ? 0 : zipCode.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return street.equals(address.street) &&
                number.equals(address.number) &&
                zipCode.equals(address.zipCode);
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

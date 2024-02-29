package com.restful.elementary.school.management.entity;

import com.restful.elementary.school.management.dto.address.DadosCadastroEndereco;
import jakarta.persistence.*;

import lombok.*;

import java.util.Objects;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public Address(Address copy) {
        this.street = copy.street;
        this.number = copy.number;
        this.complement = copy.complement;
        this.neighborhood = copy.neighborhood;
        this.city = copy.city;
        this.state = copy.state;
        this.country = copy.country;
        this.zipCode = copy.zipCode;
    }

    @Override
    public Address clone() {

        Address address;

        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            address = new Address(this);
        }

        return address;
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

        return Objects.equals(this.street, address.street) &&
                Objects.equals(this.number, address.number) &&
                Objects.equals(this.zipCode, address.zipCode);
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t\"street\": \"" + this.street + "\",\n" +
                "\t\t\"number\": \"" + this.number + "\",\n" +
                "\t\t\"complement\": \"" + this.complement + "\",\n" +
                "\t\t\"neighborhood\": \"" + this.neighborhood + "\",\n" +
                "\t\t\"city\": \"" + this.city + "\",\n" +
                "\t\t\"state\": \"" + this.state + "\",\n" +
                "\t\t\"country\": \"" + this.country + "\",\n" +
                "\t\t\"zipCode\": \"" + this.zipCode + "\"\n" +
                "\t}";
    }
}
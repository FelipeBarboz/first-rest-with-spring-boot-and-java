package br.com.FelipeBarboz.model;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof People people)) return false;
        return Objects.equals(getId(), people.getId()) && Objects.equals(getFirstName(), people.getFirstName()) && Objects.equals(getLastName(), people.getLastName()) && Objects.equals(getAddress(), people.getAddress()) && Objects.equals(getGender(), people.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public People() {


    }
}

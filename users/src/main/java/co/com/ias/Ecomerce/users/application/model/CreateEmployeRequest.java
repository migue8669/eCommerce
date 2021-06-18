package co.com.ias.Ecomerce.users.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationRequest;

import java.util.Objects;

public class CreateEmployeRequest implements ApplicationRequest {
    private String name;
    private String lastName;
    private String idNumber;

    public CreateEmployeRequest() {
    }

    public CreateEmployeRequest(String name, String lastName, String idNumber  ) {
        this.name = name;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateEmployeRequest that = (CreateEmployeRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(idNumber, that.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, idNumber);
    }

    @Override
    public String toString() {
        return "CreateEmployeRequest{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}

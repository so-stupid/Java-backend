package ru.rsatu.pojo;

import javax.persistence.*;
import java.util.List;

@Entity(name = "client")
public class Client {

    public Client() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Long phoneNumber;
    @Column
    private String address;
    @OneToMany
    @JoinColumn(name = "auto")
    private List<Auto> idAuto;

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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Auto> getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(List<Auto> idAuto) {
        this.idAuto = idAuto;
    }
}

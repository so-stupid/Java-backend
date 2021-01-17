package ru.rsatu.pojo;

import javax.persistence.*;

@Entity(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String firstNameW;
    @Column
    private String lastNameW;
    @Column
    private Long phoneNumber;
    @Column
    private String address;
    @ManyToOne
    @JoinColumn(name = "type_worker")
    private TypeWorker typeWorker;

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNameW() {
        return firstNameW;
    }

    public void setFirstNameW(String firstNameW) {
        this.firstNameW = firstNameW;
    }

    public String getLastNameW() {
        return lastNameW;
    }

    public void setLastNameW(String lastNameW) {
        this.lastNameW = lastNameW;
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

    public TypeWorker getTypeWorker() {
        return typeWorker;
    }

    public void setTypeWorker(TypeWorker typeWorker) {
        this.typeWorker = typeWorker;
    }
}

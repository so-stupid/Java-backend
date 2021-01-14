package ru.rsatu.pojo;

import javax.persistence.*;

@Entity(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

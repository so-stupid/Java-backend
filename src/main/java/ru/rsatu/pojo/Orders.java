package ru.rsatu.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
public class Orders {

    public Orders() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    @JoinColumn(name = "auto")
    private Auto auto;
    @OneToOne
    @JoinColumn(name = "client")
    private Client client;
    @OneToOne
    @JoinColumn(name = "worker")
    private Worker worker;
    @Column
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
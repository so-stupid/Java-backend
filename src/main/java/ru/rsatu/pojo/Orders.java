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
    @ManyToOne
    @JoinColumn(name = "auto")
    private Auto auto;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "worker")
    private Worker worker;
    @Column
    private Date date;


}
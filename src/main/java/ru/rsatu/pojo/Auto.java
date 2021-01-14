package ru.rsatu.pojo;

import javax.persistence.*;
import java.time.Year;

@Entity(name = "auto")
public class Auto {

    public Auto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String mark;
    @Column
    private String lastMark;
    @Column
    private String govLicense;
    @Column
    private String regBody;
    @Column
    private String color;
    @Column
    private Year yoc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getLastMark() {
        return lastMark;
    }

    public void setLastMark(String lastMark) {
        this.lastMark = lastMark;
    }

    public String getGovLicense() {
        return govLicense;
    }

    public void setGovLicense(String govLicense) {
        this.govLicense = govLicense;
    }

    public String getRegBody() {
        return regBody;
    }

    public void setRegBody(String regBody) {
        this.regBody = regBody;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Year getYoc() {
        return yoc;
    }

    public void setYoc(Year yoc) {
        this.yoc = yoc;
    }

}

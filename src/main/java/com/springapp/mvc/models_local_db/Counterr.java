package com.springapp.mvc.models_local_db;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "counterr")
public class Counterr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String counters;
    private String adress;
    private String dom;
    private String tel;
    private String ls;
    private Integer raion;
    private String users;
    private Integer comand;
    private int otmetka;
    private String sost;
    private String status;
    private String new_status;
    private Integer t_out;
    private String debetors;
    private String akt;
    private String penya;
    private String fio_podkl;
    private String note;
    private Integer kod_prich;
    private String note2;
    private String kto;
    private String filename;
    private String type_meter;
    private Integer type_mvalue;
    private Integer type_customer;
    private String fio_customer;
    @Column(name="timesend")
    private Timestamp timesend;

    public Timestamp getTimesend() {
        return timesend;
    }

    public void setTimesend(Timestamp timesend) {
        this.timesend = timesend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounters() {
        return counters;
    }

    public void setCounters(String counters) {
        this.counters = counters;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public Integer getRaion() {
        return raion;
    }

    public void setRaion(Integer raion) {
        this.raion = raion;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Integer getComand() {
        return comand;
    }

    public void setComand(Integer comand) {
        this.comand = comand;
    }

    public int getOtmetka() {
        return otmetka;
    }

    public void setOtmetka(int otmetka) {
        this.otmetka = otmetka;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNew_status() {
        return new_status;
    }

    public void setNew_status(String new_status) {
        this.new_status = new_status;
    }

    public Integer getT_out() {
        return t_out;
    }

    public void setT_out(Integer t_out) {
        this.t_out = t_out;
    }

    public String getDebetors() {
        return debetors;
    }

    public void setDebetors(String debetors) {
        this.debetors = debetors;
    }

    public String getAkt() {
        return akt;
    }

    public void setAkt(String akt) {
        this.akt = akt;
    }

    public String getPenya() {
        return penya;
    }

    public void setPenya(String penya) {
        this.penya = penya;
    }

    public String getFio_podkl() {
        return fio_podkl;
    }

    public void setFio_podkl(String fio_podkl) {
        this.fio_podkl = fio_podkl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getKod_prich() {
        return kod_prich;
    }

    public void setKod_prich(Integer kod_prich) {
        this.kod_prich = kod_prich;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getKto() {
        return kto;
    }

    public void setKto(String kto) {
        this.kto = kto;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType_meter() {
        return type_meter;
    }

    public void setType_meter(String type_meter) {
        this.type_meter = type_meter;
    }

    public Integer getType_mvalue() {
        return type_mvalue;
    }

    public void setType_mvalue(Integer type_mvalue) {
        this.type_mvalue = type_mvalue;
    }

    public Integer getType_customer() {
        return type_customer;
    }

    public void setType_customer(Integer type_customer) {
        this.type_customer = type_customer;
    }

    public String getFio_customer() {
        return fio_customer;
    }

    public void setFio_customer(String fio_customer) {
        this.fio_customer = fio_customer;
    }
}

package com.springapp.mvc.models_local_db;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "chinameters")
public class Chinameters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String meter_no;
    private String cust_code;
    private String cust_name;
    private String cust_adr1;
    private String cust_adr2;
    private String cust_phone;
    private String debt_energy;
    private String debt_akt;
    private String debt_penalty;
    private Integer region;
    private String meter_type;
    private String user_name;
    private Integer command;
    @Column(name="timesend")
    private Timestamp timesend;
    @Column(name="timesave")
    private Timestamp timesave;
    private Integer connected;
    private String status;
    private String new_status;
    private Integer t_out;
    private Integer done;
    @Column(name="date_connect")
    private Timestamp date_connect;
    private String who_connect;
    private String note;
    private String filename;
    private Integer type_mvalue;
    private Integer type_customer;
    private Integer sign;

    public Timestamp getTimesend() {
        return timesend;
    }

    public void setTimesend(Timestamp timesend) {
        this.timesend = timesend;
    }

    public Timestamp getTimesave() {
        return timesave;
    }

    public void setTimesave(Timestamp timesave) {
        this.timesave = timesave;
    }

    public void setConnected(Integer connected) {
        this.connected = connected;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Timestamp getDate_connect() {
        return date_connect;
    }

    public void setDate_connect(Timestamp date_connect) {
        this.date_connect = date_connect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeter_no() {
        return meter_no;
    }

    public void setMeter_no(String meter_no) {
        this.meter_no = meter_no;
    }

    public String getCust_code() {
        return cust_code;
    }

    public void setCust_code(String cust_code) {
        this.cust_code = cust_code;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_adr1() {
        return cust_adr1;
    }

    public void setCust_adr1(String cust_adr1) {
        this.cust_adr1 = cust_adr1;
    }

    public String getCust_adr2() {
        return cust_adr2;
    }

    public void setCust_adr2(String cust_adr2) {
        this.cust_adr2 = cust_adr2;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getDebt_energy() {
        return debt_energy;
    }

    public void setDebt_energy(String debt_energy) {
        this.debt_energy = debt_energy;
    }

    public String getDebt_akt() {
        return debt_akt;
    }

    public void setDebt_akt(String debt_akt) {
        this.debt_akt = debt_akt;
    }

    public String getDebt_penalty() {
        return debt_penalty;
    }

    public void setDebt_penalty(String debt_penalty) {
        this.debt_penalty = debt_penalty;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getMeter_type() {
        return meter_type;
    }

    public void setMeter_type(String meter_type) {
        this.meter_type = meter_type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public int getConnected() {
        return connected;
    }

    public void setConnected(int connected) {
        this.connected = connected;
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

    public String getWho_connect() {
        return who_connect;
    }

    public void setWho_connect(String who_connect) {
        this.who_connect = who_connect;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }
}

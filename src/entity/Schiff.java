package entity;

import java.sql.Date;

/**
 * Created by Momken on 17.12.2015.
 */
public class Schiff {

    private Integer id = null;
    private String reeder = null;
    private Date baujahr = null;
    private Double maxGeschwindigkeit = null;
    private Integer kapzitaet = null;
    private String kapitaen = null;
    private String name = null;
    private Boolean tanker = null;
    private Integer laenge = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReeder() {
        return reeder;
    }

    public void setReeder(String reeder) {
        this.reeder = reeder;
    }

    public Date getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(Date baujahr) {
        this.baujahr = baujahr;
    }

    public Double getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public void setMaxGeschwindigkeit(Double maxGeschwindigkeit) {
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public Integer getKapzitaet() {
        return kapzitaet;
    }

    public void setKapzitaet(Integer kapzitaet) {
        this.kapzitaet = kapzitaet;
    }

    public String getKapitaen() {
        return kapitaen;
    }

    public void setKapitaen(String kapitaen) {
        this.kapitaen = kapitaen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTanker() {
        return tanker;
    }

    public void setTanker(boolean tanker) {
        this.tanker = tanker;
    }

    public Integer getLaenge() {
        return laenge;
    }

    public void setLaenge(Integer laenge) {
        this.laenge = laenge;
    }
}

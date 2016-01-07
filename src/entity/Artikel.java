package entity;

import java.sql.Date;

public class Artikel {

    private Integer id = null;
    private String name = null;
    private Double gewicht = null;
    private Double preis = null;
    private Date ablaufdatum = null;
    private String bild = null;

    public Artikel() {
        
    }


    public Artikel(Integer id, String name, Double gewicht, Double preis, Date ablaufdatum, String bild) {
        this.id = id;
        this.name = name;
        this.gewicht = gewicht;
        this.preis = preis;
        this.ablaufdatum = ablaufdatum;
        this.bild = bild;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Date getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(Date ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }
}

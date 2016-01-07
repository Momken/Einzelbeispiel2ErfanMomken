package entity;

import java.sql.Date;

/**
 * Created by Momken on 17.12.2015.
 */
public class Hafen {


    private Integer id = null;
    private String land = null;
    private String name = null;
    private Date wartungsdatum = null;
    private Double maxGroesse = null;
    private Integer kapzitaet = null;
    private Boolean oelhafen = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getWartungsdatum() {
        return wartungsdatum;
    }

    public void setWartungsdatum(Date wartungsdatum) {
        this.wartungsdatum = wartungsdatum;
    }

    public Double getMaxGroesse() {
        return maxGroesse;
    }

    public void setMaxGroesse(Double maxGroesse) {
        this.maxGroesse = maxGroesse;
    }

    public Integer getKapzitaet() {
        return kapzitaet;
    }

    public void setKapzitaet(Integer kapzitaet) {
        this.kapzitaet = kapzitaet;
    }

    public Boolean getOelhafen() {
        return oelhafen;
    }

    public void setOelhafen(Boolean oelhafen) {
        this.oelhafen = oelhafen;
    }
}

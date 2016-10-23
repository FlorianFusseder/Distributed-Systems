/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.hello.db.fusseder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Florian Fußeder
 */
@Entity
public class Auftrag
{

    //Attribute/Felder
    @Id
    @GeneratedValue
    private long auftragsId;
    private String bezeichnung;
    private double gesamtSumme;
    
    //Konstructor(en)

    public Auftrag()
    {
    }

    public Auftrag(long auftragsId, String bezeichnung, double gesamtSumme)
    {
        this.auftragsId = auftragsId;
        this.bezeichnung = bezeichnung;
        this.gesamtSumme = gesamtSumme;
    }
    
    //Accesssoren(getter setter)

    public long getAuftragsId()
    {
        return auftragsId;
    }

    public void setAuftragsId(long auftragsId)
    {
        this.auftragsId = auftragsId;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    public double getGesamtSumme()
    {
        return gesamtSumme;
    }

    public void setGesamtSumme(double gesamtSumme)
    {
        this.gesamtSumme = gesamtSumme;
    }
    
    
}

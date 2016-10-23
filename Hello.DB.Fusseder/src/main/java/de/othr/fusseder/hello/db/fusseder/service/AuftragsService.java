/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.hello.db.fusseder.service;

import de.othr.fusseder.hello.db.fusseder.entity.Auftrag;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Florian Fußeder
 */
public class AuftragsService
{

    @PersistenceContext(unitName = "FussederPU")
    private EntityManager entityManager;

    @Transactional
    public Auftrag auftragAnlegen(String bez, double wert)
    {
        //Auftrag (Entity anlegen(im heap)
        Auftrag neuerAuftrag = new Auftrag();
        neuerAuftrag.setBezeichnung(bez);
        neuerAuftrag.setGesamtSumme(wert);

        entityManager.persist(neuerAuftrag);
        return neuerAuftrag;
    }
}

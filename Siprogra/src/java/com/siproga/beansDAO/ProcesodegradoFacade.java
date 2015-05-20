/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siproga.beansDAO;

import com.siprogra.entities.Procesodegrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elkin
 */
@Stateless
public class ProcesodegradoFacade extends AbstractFacade<Procesodegrado> {
    @PersistenceContext(unitName = "SiprogaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesodegradoFacade() {
        super(Procesodegrado.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siproga.beansDAO;

import com.siprogra.entities.Rol;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author elkin
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> {
    @PersistenceContext(unitName = "SiprogaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    public BigDecimal maximoRol() 
    {
        Query query = getEntityManager().createNamedQuery("Rol.maximoId");
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result;
    }
}

package com.siprogra.controllers;

import com.siprogra.entities.Fase;
import com.siprogra.entities.Rol;
import com.siproga.beansDAO.FaseFacade;
import com.siproga.beansDAO.RolFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jalber
 */
@ManagedBean
@Named(value = "eliminacionController")
@ViewScoped
public class EliminacionController implements Serializable
{
    @EJB
    private RolFacade rolFX;
    @EJB
    private FaseFacade faseFX;
    
    private List<Rol> listaRolesX;
    private List<Fase> listaFasesX;
    
    public EliminacionController() 
    {
    }
    @PostConstruct
    private void init() 
    {
        listaRolesX=rolFX.findAll();
        listaFasesX=faseFX.findAll();
    }
    public void eliminarRol(Rol rol) throws Exception
    {
       rolFX.remove(rol);     
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Se ha eliminado el rol correctamente.",""));
    }
    public void eliminarFase(Fase fase) throws Exception
    {
       faseFX.remove(fase);     
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Se ha eliminado la fase correctamente.",""));
    }
}

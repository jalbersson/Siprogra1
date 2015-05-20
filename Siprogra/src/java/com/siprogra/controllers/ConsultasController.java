package com.siprogra.controllers;

import com.siprogra.entities.Fase;
import com.siprogra.entities.Productodetrabajo;
import com.siprogra.entities.Restriccion;
import com.siprogra.entities.Rol;
import com.siproga.beansDAO.FaseFacade;
import com.siproga.beansDAO.ProductodetrabajoFacade;
import com.siproga.beansDAO.RestriccionFacade;
import com.siproga.beansDAO.RolFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jalber
 */
@ManagedBean
@Named(value = "consultasController")
@ViewScoped
public class ConsultasController implements Serializable
{
    @EJB
    private RolFacade rolF;
    @EJB
    private FaseFacade faseF;
    @EJB
    private RestriccionFacade restriccionF;
    @EJB
    private ProductodetrabajoFacade documentoF;
    private List<Rol> listaRoles;
    private List<Fase> listaFases;
    private List<Restriccion> listaRestricciones;
    private boolean seMuestra;
    private boolean ocultarBoton;
    private List<String> listaFasesNombres;

    public List<String> getListaFasesNombres() {
        return listaFasesNombres;
    }

    public void setListaFasesNombres(List<String> listaFasesNombres) {
        this.listaFasesNombres = listaFasesNombres;
    }

    public boolean isOcultarBoton() {
        return ocultarBoton;
    }

    public void setOcultarBoton(boolean ocultarBoton) {
        this.ocultarBoton = ocultarBoton;
    }

    public boolean isSeMuestra() {
        return seMuestra;
    }

    public void setSeMuestra(boolean seMuestra) {
        this.seMuestra = seMuestra;
    }
    
    public ConsultasController() 
    {
    }
    @PostConstruct
    private void init() 
    {
        listaRoles=rolF.findAll();
        listaFases=faseF.findAll();
        listaRestricciones=restriccionF.findAll();
        seMuestra=false;
        ocultarBoton=true;
    }
    public List<Rol> listarRoles() 
    {
        return rolF.findAll();
    }
    public List<Fase> listarFases() 
    {
        return faseF.findAll();
    }
    public List<Restriccion> listarRestricciones() 
    {
        return restriccionF.findAll();
    }
    public List<Productodetrabajo> listarDocumentos() 
    {
        return documentoF.findAll();
    }

    public List<Rol> getListaRoles() 
    {
        return listaRoles;
    }
    public void setListaRoles(List<Rol> listaRoles) 
    {
        this.listaRoles = listaRoles;
    }
    public List<Fase> getListaFases() 
    {
        return listaFases;
    }
    public void setListaFases(List<Fase> listaFases) 
    {
        this.listaFases = listaFases;
    }
    public List<Restriccion> getListaRestricciones() 
    {
        return listaRestricciones;
    }
    public void setListaRestricciones(List<Restriccion> listaRestricciones) 
    {
        this.listaRestricciones = listaRestricciones;
    }
    public void mostrarTexto()
    {
        if(this.getListaFases().get(0)!=null)
        {
            seMuestra=true;
            ocultarBoton=false;
        }
    }
    public String listarFasesNombres(int id)
    {
        
        return faseF.nombreFaseID(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siprogra.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elkin
 */
@Entity
@Table(name = "FLUJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flujo.findAll", query = "SELECT f FROM Flujo f"),
    @NamedQuery(name = "Flujo.findByFluid", query = "SELECT f FROM Flujo f WHERE f.fluid = :fluid")})
public class Flujo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLUID")
    private BigDecimal fluid;
    @ManyToMany(mappedBy = "flujoList", fetch = FetchType.EAGER)
    private List<Fase> faseList;
    @JoinTable(name = "GESTIONA", joinColumns = {
        @JoinColumn(name = "FLUID", referencedColumnName = "FLUID")}, inverseJoinColumns = {
        @JoinColumn(name = "ADMID", referencedColumnName = "ADMID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Administrador> administradorList;

    public Flujo() {
    }

    public Flujo(BigDecimal fluid) {
        this.fluid = fluid;
    }

    public BigDecimal getFluid() {
        return fluid;
    }

    public void setFluid(BigDecimal fluid) {
        this.fluid = fluid;
    }

    @XmlTransient
    public List<Fase> getFaseList() {
        return faseList;
    }

    public void setFaseList(List<Fase> faseList) {
        this.faseList = faseList;
    }

    @XmlTransient
    public List<Administrador> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(List<Administrador> administradorList) {
        this.administradorList = administradorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fluid != null ? fluid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flujo)) {
            return false;
        }
        Flujo other = (Flujo) object;
        if ((this.fluid == null && other.fluid != null) || (this.fluid != null && !this.fluid.equals(other.fluid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siprogra.entities.Flujo[ fluid=" + fluid + " ]";
    }
    
}

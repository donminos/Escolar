/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "grados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grados.findAll", query = "SELECT g FROM Grados g"),
    @NamedQuery(name = "Grados.findByIdgrado", query = "SELECT g FROM Grados g WHERE g.idgrado = :idgrado"),
    @NamedQuery(name = "Grados.findByClave", query = "SELECT g FROM Grados g WHERE g.clave = :clave")})
public class Grados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrado")
    private Integer idgrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrado")
    private List<Materias> materiasList;

    public Grados() {
    }

    public Grados(Integer idgrado) {
        this.idgrado = idgrado;
    }

    public Grados(Integer idgrado, String clave) {
        this.idgrado = idgrado;
        this.clave = clave;
    }

    public Integer getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Integer idgrado) {
        this.idgrado = idgrado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public List<Materias> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materias> materiasList) {
        this.materiasList = materiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrado != null ? idgrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grados)) {
            return false;
        }
        Grados other = (Grados) object;
        if ((this.idgrado == null && other.idgrado != null) || (this.idgrado != null && !this.idgrado.equals(other.idgrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escolar.entity.Grados[ idgrado=" + idgrado + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author SouvikPRAT
 */
@Entity
@Table(name = "banks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banks.findAll", query = "SELECT b FROM Banks b")
    , @NamedQuery(name = "Banks.findByName", query = "SELECT b FROM Banks b WHERE b.name = :name")
    , @NamedQuery(name = "Banks.findById", query = "SELECT b FROM Banks b WHERE b.id = :id")})
public class Banks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 49)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "bankId")
    private Collection<Branches> branchesCollection;

    public Banks() {
    }

    public Banks(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Branches> getBranchesCollection() {
        return branchesCollection;
    }

    public void setBranchesCollection(Collection<Branches> branchesCollection) {
        this.branchesCollection = branchesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banks)) {
            return false;
        }
        Banks other = (Banks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Banks[ id=" + id + " ]";
    }
    
}

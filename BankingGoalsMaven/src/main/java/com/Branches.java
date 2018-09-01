/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SouvikPRAT
 */
@Entity
@Table(name = "branches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branches.findAll", query = "SELECT b FROM Branches b")
    , @NamedQuery(name = "Branches.findByIfsc", query = "SELECT b FROM Branches b WHERE b.ifsc = :ifsc")
    , @NamedQuery(name = "Branches.findByBranch", query = "SELECT b FROM Branches b WHERE b.branch = :branch")
    , @NamedQuery(name = "Branches.findByAddress", query = "SELECT b FROM Branches b WHERE b.address = :address")
    , @NamedQuery(name = "Branches.findByCity", query = "SELECT b FROM Branches b WHERE b.city = :city")
    , @NamedQuery(name = "Branches.findByDistrict", query = "SELECT b FROM Branches b WHERE b.district = :district")
    , @NamedQuery(name = "Branches.findByState", query = "SELECT b FROM Branches b WHERE b.state = :state")})
public class Branches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ifsc")
    private String ifsc;
    @Size(max = 74)
    @Column(name = "branch")
    private String branch;
    @Size(max = 195)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "district")
    private String district;
    @Size(max = 26)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne
    private Banks bankId;

    public Branches() {
    }

    public Branches(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Banks getBankId() {
        return bankId;
    }

    public void setBankId(Banks bankId) {
        this.bankId = bankId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ifsc != null ? ifsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branches)) {
            return false;
        }
        Branches other = (Branches) object;
        if ((this.ifsc == null && other.ifsc != null) || (this.ifsc != null && !this.ifsc.equals(other.ifsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Branches[ ifsc=" + ifsc + " ]";
    }
    
}

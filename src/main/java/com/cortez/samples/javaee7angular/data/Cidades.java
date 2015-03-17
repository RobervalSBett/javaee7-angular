
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Cidades 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCID")
    @SequenceGenerator(name = "IDCID", sequenceName = "CIDADES")
    @Column(name = "IDCID")
    private Long id;
    
    @Column(name = "DESCRICID", length = 60)
    private String nomeCid;
    
    @Column(name = "UFCID", length = 2)
    private String siglaUf;
    
    @Column(name = "STATUSCID", length = 60)
    private String statusCid ;     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCid() {
        return nomeCid;
    }

    public void setNomeCid(String nomeCid) {
        this.nomeCid = nomeCid;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getStatusCid() {
        return statusCid;
    }

    public void setStatusCid(String statusCid) {
        this.statusCid = statusCid;
    }
    
}

package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Colaboradores 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCOLA")
    @SequenceGenerator(name = "IDCOLA", sequenceName = "COLABORADORES")
    @Column(name = "IDCOLA")
    private Long id;
    
    @Column(name = "NOMECOLA", length =60 )
    private String nomeCola;  
    
    @Column(name = "FONE1COLA", length =12 )
    private String fone1Cola;     
    
    @Column(name = "FONE2COLA", length =12 )
    private String fone2Cola;      
    
    @Column(name = "EMAILCOLA", length =100 )
    private String emailCola;   
    
    @Column(name = "OBSCOLA", length =100 )
    private String obsCola;   
        
    @Column(name = "STATUSCOLA", length =1 )
    private String statusCola;      

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomeCola() {
        return nomeCola;
    }

    public void setNomeCola(final String nomeCola) {
        this.nomeCola = nomeCola;
    }

    public String getFone1Cola() {
        return fone1Cola;
    }

    public void setFone1Cola(final String fone1Cola) {
        this.fone1Cola = fone1Cola;
    }

    public String getFone2Cola() {
        return fone2Cola;
    }

    public void setFone2Cola(final String fone2Cola) {
        this.fone2Cola = fone2Cola;
    }

    public String getEmailCola() {
        return emailCola;
    }

    public void setEmailCola(final String emailCola) {
        this.emailCola = emailCola;
    }

    public String getObsCola() {
        return obsCola;
    }

    public void setObsCola(final String obsCola) {
        this.obsCola = obsCola;
    }

    public String getStatusCola() {
        return statusCola;
    }

    public void setStatusCola(final String statusCola) {
        this.statusCola = statusCola;
    }
    

}

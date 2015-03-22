
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Certificadoras 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCERT")
    @SequenceGenerator(name = "IDCERT", sequenceName = "CERTIFICADORAS")
    @Column(name = "IDCERT")
    private Long id;
    
    @Column(name = "CEP", length =8 )
    private String cep;    
    
    @Column(name = "RAZAOCERT", length =60 )
    private String razaoCert;      
    
    @Column(name = "FANTACERT", length =60 )
    private String fantaCert;    
    
    @Column(name = "COMPLEENDCERT", length =60 )
    private String compleEndCert;  
    
    @Column(name = "FONE1CERT", length =12 )
    private String fone1Cert;    
    
    @Column(name = "FONE2CERT", length =12 )
    private String fone2Cert;      
    
    @Column(name = "EMAILCERT", length =100 )
    private String emailCert;    
    
    @Column(name = "SITECERT", length =100 )
    private String siteCert;      
    
    @Column(name = "CONTATOCERT", length =60 )
    private String contatoCert;    
    
    @Column(name = "CNPJCERT", length =14 )
    private String cnpjCert;      
    
    @Column(name = "INSCRICERT", length =14 )
    private String inscriCert;    
    
    @Column(name = "OBSCERT", length =100 )
    private String obsCert;       
    
    @Column(name = "STATUSCERT", length =1 )
    private String StatusCert; 

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }

    public String getRazaoCert() {
        return razaoCert;
    }

    public void setRazaoCert(final String razaoCert) {
        this.razaoCert = razaoCert;
    }

    public String getFantaCert() {
        return fantaCert;
    }

    public void setFantaCert(final String fantaCert) {
        this.fantaCert = fantaCert;
    }

    public String getCompleEndCert() {
        return compleEndCert;
    }

    public void setCompleEndCert(final String compleEndCert) {
        this.compleEndCert = compleEndCert;
    }

    public String getFone1Cert() {
        return fone1Cert;
    }

    public void setFone1Cert(final String fone1Cert) {
        this.fone1Cert = fone1Cert;
    }

    public String getFone2Cert() {
        return fone2Cert;
    }

    public void setFone2Cert(final String fone2Cert) {
        this.fone2Cert = fone2Cert;
    }

    public String getEmailCert() {
        return emailCert;
    }

    public void setEmailCert(final String emailCert) {
        this.emailCert = emailCert;
    }

    public String getSiteCert() {
        return siteCert;
    }

    public void setSiteCert(final String siteCert) {
        this.siteCert = siteCert;
    }

    public String getContatoCert() {
        return contatoCert;
    }

    public void setContatoCert(final String contatoCert) {
        this.contatoCert = contatoCert;
    }

    public String getCnpjCert() {
        return cnpjCert;
    }

    public void setCnpjCert(final String cnpjCert) {
        this.cnpjCert = cnpjCert;
    }

    public String getInscriCert() {
        return inscriCert;
    }

    public void setInscriCert(final String inscriCert) {
        this.inscriCert = inscriCert;
    }

    public String getObsCert() {
        return obsCert;
    }

    public void setObsCert(final String obsCert) {
        this.obsCert = obsCert;
    }

    public String getStatusCert() {
        return StatusCert;
    }

    public void setStatusCert(final String StatusCert) {
        this.StatusCert = StatusCert;
    }
   
}

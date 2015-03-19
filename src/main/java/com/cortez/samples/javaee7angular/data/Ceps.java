
package com.cortez.samples.javaee7angular.data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ceps 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CEP")
    @SequenceGenerator(name = "CEP", sequenceName = "CEPS")
    @Column(name = "CEP")
    private String cep; 
       
    @Column(name = "IDCID")
    private int idCid;
  
    @Column(name = "IDBAI")
    private int idBai;
   
    @Column(name = "LOGRACEP", length = 60)
    private String lograCep;
    
    @Column(name = "OBSCEP", length = 100)
    private String obsCep;
       
    @Column(name = "STATUSCEP", length = 1)
    private String statusCep;  

    public String getCep() {
        return cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }

    public int getIdCid() {
        return idCid;
    }

    public void setIdCid(final int idCid) {
        this.idCid = idCid;
    }

    public int getIdBai() {
        return idBai;
    }

    public void setIdBai(final int idBai) {
        this.idBai = idBai;
    }

    public String getLograCep() {
        return lograCep;
    }

    public void setLograCep(final String lograCep) {
        this.lograCep = lograCep;
    }

    public String getObsCep() {
        return obsCep;
    }

    public void setObsCep(final String obsCep) {
        this.obsCep = obsCep;
    }

    public String getStatusCep() {
        return statusCep;
    }

    public void setStatusCep(final String statusCep) {
        this.statusCep = statusCep;
    }   
}

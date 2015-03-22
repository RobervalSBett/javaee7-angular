
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ocorrencias 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDOCORRE")
    @SequenceGenerator(name = "IDOCORRE", sequenceName = "OCORRENCIAS")
    @Column(name = "IDOCORRE")
    private Long id;
    
    @Column(name = "IDPONTOCTRL" )
    private int idPontoCtrl ; 

    @Column(name = "IDCOLA" )
    private int idCola ;     
    
    @Column(name = "DTHROCORRE", length =19 )
    private String dtHrOcorre; 
    
    @Column(name = "DTATUALIZA", length =19 )
    private String dtAtualiza;     
    
    @Column(name = "DESCRIOCORRE", length =254 )
    private String descriOcorre;     
    
    @Column(name = "SUGESOCORRE", length =254 )
    private String sugesOcorre;     
    
    @Column(name = "OBSOCORRE", length =100 )
    private String obsOcorre; 
    
    @Column(name = "STATUSOCORRE", length =1 )
    private String statusOcorre;     

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getIdPontoCtrl() {
        return idPontoCtrl;
    }

    public void setIdPontoCtrl(final int idPontoCtrl) {
        this.idPontoCtrl = idPontoCtrl;
    }

    public int getIdCola() {
        return idCola;
    }

    public void setIdCola(final int idCola) {
        this.idCola = idCola;
    }

    public String getDtHrOcorre() {
        return dtHrOcorre;
    }

    public void setDtHrOcorre(final String dtHrOcorre) {
        this.dtHrOcorre = dtHrOcorre;
    }

    public String getDtAtualiza() {
        return dtAtualiza;
    }

    public void setDtAtualiza(final String dtAtualiza) {
        this.dtAtualiza = dtAtualiza;
    }

    public String getDescriOcorre() {
        return descriOcorre;
    }

    public void setDescriOcorre(final String descriOcorre) {
        this.descriOcorre = descriOcorre;
    }

    public String getSugesOcorre() {
        return sugesOcorre;
    }

    public void setSugesOcorre(final String sugesOcorre) {
        this.sugesOcorre = sugesOcorre;
    }

    public String getObsOcorre() {
        return obsOcorre;
    }

    public void setObsOcorre(final String obsOcorre) {
        this.obsOcorre = obsOcorre;
    }

    public String getStatusOcorre() {
        return statusOcorre;
    }

    public void setStatusOcorre(final String statusOcorre) {
        this.statusOcorre = statusOcorre;
    }

}

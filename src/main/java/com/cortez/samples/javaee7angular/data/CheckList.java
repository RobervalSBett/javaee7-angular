
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CheckList 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDPONTOCTRL")
    @SequenceGenerator(name = "IDPONTOCTRL", sequenceName = "CHECKLIST")
    @Column(name = "IDPONTOCTRL")
    private Long id;
    
    @Column(name = "IDCOLA" )
    private int idCola ;     
    
    @Column(name = "IDAUDIT" )
    private int idAudit ;    
    
    @Column(name = "IDEQUIPE" )
    private int idEquipe ;    
    
    @Column(name = "DOCPROCESSO", length =12 )
    private String docProcesso;        
    
    @Column(name = "DESCRICHKLIST", length =254 )
    private String descriChklist;        
    
    @Column(name = "DTHRREALICHKLIST", length =19 )
    private String dtHrRealiChklist;        
    
    @Column(name = "DTATUALIZA", length =19 )
    private String dtAtualiza;     
    
    @Column(name = "OBSCHKLIST", length =254 )
    private String obsChklist;        
    
    @Column(name = "STATUSCHKLIST", length =1 )
    private String statusChklist;        

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getIdCola() {
        return idCola;
    }

    public void setIdCola(final int idCola) {
        this.idCola = idCola;
    }

    public int getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(final int idAudit) {
        this.idAudit = idAudit;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(final int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getDocProcesso() {
        return docProcesso;
    }

    public void setDocProcesso(final String docProcesso) {
        this.docProcesso = docProcesso;
    }

    public String getDescriChklist() {
        return descriChklist;
    }

    public void setDescriChklist(final String descriChklist) {
        this.descriChklist = descriChklist;
    }

    public String getDtHrRealiChklist() {
        return dtHrRealiChklist;
    }

    public void setDtHrRealiChklist(final String dtHrRealiChklist) {
        this.dtHrRealiChklist = dtHrRealiChklist;
    }

    public String getDtAtualiza() {
        return dtAtualiza;
    }

    public void setDtAtualiza(final String dtAtualiza) {
        this.dtAtualiza = dtAtualiza;
    }

    public String getObsChklist() {
        return obsChklist;
    }

    public void setObsChklist(final String obsChklist) {
        this.obsChklist = obsChklist;
    }

    public String getStatusChklist() {
        return statusChklist;
    }

    public void setStatusChklist(final String statusChklist) {
        this.statusChklist = statusChklist;
    }
  
    
}

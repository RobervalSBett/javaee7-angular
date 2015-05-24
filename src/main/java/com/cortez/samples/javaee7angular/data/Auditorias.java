
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


public class Auditorias 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDAUDIT")
    @SequenceGenerator(name = "IDAUDIT", sequenceName = "AUDITORIAS")
    @Column(name = "idaudit")
    private Long id;   
    
    @Column(name = "IDCERT" )
    private Certificadoras certificadora ;    
    
    @Column(name = "IDCLI" )
    private Clientes cliente ;  
    
    @Column(name = "DESCRIAUDIT", length =254 )
    private String descriAudit;  
        
    @Column(name = "DESCRIOBJAUDIT", length =254 )
    private String descriObjAudit;  
     
    @Column(name = "DTHRCADAUDIT", length =19 )
    private String dtHrCadAudit ;  
    
    @Column(name = "DTHRINIAUDIT", length =19 )
    private String dtHrIniAudit;  
    
    @Column(name = "DTHRREALIAUDIT", length =19 )
    private String dtHrRealiaudit;  
    
    @Column(name = "DTATUALIZA", length =19 )
    private String dtAtualiza;  

    @Column(name = "OBSAUDIT", length =100 )
    private String obsaudit;  
    
    @Column(name = "STATUSNC", length =1 )
    private String statusNc;   

    public Long getId() 
    {
        return id;
    }

    public void setId(final Long id) 
    {
        this.id = id;
    }

    public Certificadoras getCertificadora() {
        return certificadora;
    }

    public void setCertificadora(Certificadoras certificadora) {
        this.certificadora = certificadora;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getDescriAudit() 
    {
        return descriAudit;
    }

    public void setDescriAudit(final String descriAudit) 
    {
        this.descriAudit = descriAudit;
    }

    public String getDescriObjAudit() 
    {
        return descriObjAudit;
    }

    public void setDescriObjAudit(final String descriObjAudit) 
    {
        this.descriObjAudit = descriObjAudit;
    }

    public String getDtHrCadAudit() 
    {
        return dtHrCadAudit;
    }

    public void setDtHrCadAudit(final String dtHrCadAudit) 
    {
        this.dtHrCadAudit = dtHrCadAudit;
    }

    public String getDtHrIniAudit() 
    {
        return dtHrIniAudit;
    }

    public void setDtHrIniAudit(final String dtHrIniAudit) 
    {
        this.dtHrIniAudit = dtHrIniAudit;
    }

    public String getDtHrRealiaudit() 
    {
        return dtHrRealiaudit;
    }

    public void setDtHrRealiaudit(final String dtHrRealiaudit) 
    {
        this.dtHrRealiaudit = dtHrRealiaudit;
    }

    public String getDtAtualiza() 
    {
        return dtAtualiza;
    }

    public void setDtAtualiza(final String dtAtualiza) 
    {
        this.dtAtualiza = dtAtualiza;
    }

    public String getObsaudit() 
    {
        return obsaudit;
    }

    public void setObsaudit(final String obsaudit) 
    {
        this.obsaudit = obsaudit;
    }

    public String getStatusNc() 
    {
        return statusNc;
    }

    public void setStatusNc(final String statusNc) 
    {
        this.statusNc = statusNc;
    }
    
    
    
    
    
    
        
}

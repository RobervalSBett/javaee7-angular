
package com.cortez.samples.javaee7angular.data;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Clientes 
{    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCLI")
    @SequenceGenerator(name = "IDCLI", sequenceName = "seq_clientes", allocationSize = 1)
    @Column(name = "idcli")
    private Long id;
    
    @Column(name = "CEP", length =8 )
    private String cep;  

    @Column(name = "RAZAOCLI", length =60 )
    private String razaoCli ;  
        
    @Column(name = "FANTACLI", length = 60)
    private String fantaCli;  
    
    @Column(name = "COMPLEENDCLI", length =60 )
    private String compleEndCli;  
    
    @Column(name = "FONE1CLI", length = 12)
    private String fone1Cli;  

    @Column(name = "FONE2CLI", length = 12)
    private String fone2Cli;  
    
    @Column(name = "EMAILCLI", length = 100)
    private String emailCli;  
        
    @Column(name = "SITECLI", length = 100)
    private String siteCli;  

    @Column(name = "CONTATOCLI", length = 60)
    private String contatoCli;  

    @Column(name = "EMAILCONTATO", length = 100)
    private String emailContato;         

    @Column(name = "CNPJCLI", length = 14)
    private String cnpjCli;  
    

    @Column(name = "INSCRICLI", length = 14)
    private String inscriCli;  
    
    @Column(name = "OBSCLI", length = 100)
    private String obsCli;  

    @Column(name = "STATUSCLI", length = 1)
    private String statusCli;      

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

    public String getRazaoCli() {
        return razaoCli;
    }

    public void setRazaoCli(final String razaoCli) {
        this.razaoCli = razaoCli;
    }

    public String getFantaCli() {
        return fantaCli;
    }

    public void setFantaCli(final String fantaCli) {
        this.fantaCli = fantaCli;
    }

    public String getCompleEndCli() {
        return compleEndCli;
    }

    public void setCompleEndCli(final String compleEndCli) {
        this.compleEndCli = compleEndCli;
    }

    public String getFone1Cli() {
        return fone1Cli;
    }

    public void setFone1Cli(final String fone1Cli) {
        this.fone1Cli = fone1Cli;
    }

    public String getFone2Cli() {
        return fone2Cli;
    }

    public void setFone2Cli(final String fone2Cli) {
        this.fone2Cli = fone2Cli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(final String emailCli) {
        this.emailCli = emailCli;
    }

    public String getSiteCli() {
        return siteCli;
    }

    public void setSiteCli(final String siteCli) {
        this.siteCli = siteCli;
    }

    public String getContatoCli() {
        return contatoCli;
    }

    public void setContatoCli(final String contatoCli) {
        this.contatoCli = contatoCli;
    }

    public String getCnpjCli() {
        return cnpjCli;
    }

    public void setCnpjCli(final String cnpjCli) {
        this.cnpjCli = cnpjCli;
    }

    public String getInscriCli() {
        return inscriCli;
    }

    public void setInscriCli(final String inscriCli) {
        this.inscriCli = inscriCli;
    }

    public String getObsCli() {
        return obsCli;
    }

    public void setObsCli(final String obsCli) {
        this.obsCli = obsCli;
    }

    public String getStatusCli() {
        return statusCli;
    }

    public void setStatusCli(final String statusCli) {
        this.statusCli = statusCli;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(final String emailContato) {
        this.emailContato = emailContato;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

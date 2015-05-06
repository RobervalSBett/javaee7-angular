package com.cortez.samples.javaee7angular.rest;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;


@Stateless
@ApplicationPath("/api")
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource extends Application
{
    
//    @Inject
//    private CidadeResource cidadeResource;
    
    @GET
    public String get() {
        return "Teste";
    }
    
    @Path("cidades")
    public CidadeResource cidadeResource()
    {
       return new CidadeResource(); 
    }
        
    @Path("bairros")
    public BairroResource bairroResource()
    {
       return new BairroResource(); 
    } 
       
    @Path("ceps")
    public CepResource cepResource()
    {
       return new CepResource(); 
    } 
    
    @Path("colaboradores")
    public ColaboradorResource colaboradorResource()
    {
       return new ColaboradorResource(); 
    } 
    
    @Path("auditores")
    public AuditorResource auditorResource()
    {
       return new AuditorResource(); 
    } 

    @Path("clientes")
    public ClienteResource clienteResource()
    {
       return new ClienteResource(); 
    }    
    
    @Path("certificadoras")
    public CertificadoraResource certificadoraResource()
    {
       return new CertificadoraResource(); 
    }  
    
    @Path("auditorias")
    public AuditoriaResource auditoriaResource()
    {
       return new AuditoriaResource(); 
    } 
    
    @Path("equipeauditores")
    public EquipeAuditorResource equipeAuditorResource()
    {
       return new EquipeAuditorResource(); 
    }     

    @Path("checklist")
    public CheckListResource checkListResource()
    {
       return new CheckListResource(); 
    } 
    
    @Path("ocorrencias")
    public OcorrenciaResource ocorrenciaResource()
    {
       return new OcorrenciaResource(); 
    }     
    
    @Path("naoconformidades")
    public NaoConformidadeResource naoConformidadeResource()
    {
       return new NaoConformidadeResource(); 
    }    
    
    
}

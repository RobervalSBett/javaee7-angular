package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Auditores;
import com.cortez.samples.javaee7angular.data.Clientes;
import com.cortez.samples.javaee7angular.pagination.PaginatedListWrapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource 
{
  private EntityManager entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();

    private Integer countClientes() {
        Query query = entityManager.createQuery("SELECT COUNT(cli.id) FROM Clientes cli");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Clientes> findClientes(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT cli.ID FROM CLIENTES CLI ORDER BY CLI." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findClientes(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countClientes());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findClientes(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listClientes(@DefaultValue("1")
                                            @QueryParam("page")
                                            Integer page,
                                            @DefaultValue("id")
                                            @QueryParam("sortFields")
                                            String sortFields,
                                            @DefaultValue("asc")
                                            @QueryParam("sortDirections")
                                            String sortDirections) {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findClientes(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Clientes getClientes(@PathParam("id") Long id) {
        return entityManager.find(Clientes.class, id);
    }

    @POST
    public Clientes saveClientes(Clientes cliente) {
        if (cliente.getId() == null) {
            Clientes clienteToSave = new Clientes();            
            clienteToSave.setCep(cliente.getCep());
            clienteToSave.setRazaoCli(cliente.getRazaoCli());
            clienteToSave.setFantaCli(cliente.getFantaCli());
            clienteToSave.setCompleEndCli(cliente.getCompleEndCli());
            clienteToSave.setFone1Cli(cliente.getFone1Cli());
            clienteToSave.setFone2Cli(cliente.getFone2Cli());
            clienteToSave.setEmailCli(cliente.getEmailCli());
            clienteToSave.setSiteCli(cliente.getSiteCli());
            clienteToSave.setContatoCli(cliente.getContatoCli());
            clienteToSave.setEmailContato(cliente.getEmailContato());
            clienteToSave.setCnpjCli(cliente.getCnpjCli());
            clienteToSave.setInscriCli(cliente.getInscriCli());
            clienteToSave.setObsCli(cliente.getObsCli());
            clienteToSave.setStatusCli(cliente.getStatusCli());
            entityManager.persist(cliente);
        } else {
            Clientes clienteToUpdate = getClientes(cliente.getId());
            clienteToUpdate.setCep(cliente.getCep());
            clienteToUpdate.setRazaoCli(cliente.getRazaoCli());
            clienteToUpdate.setFantaCli(cliente.getFantaCli());
            clienteToUpdate.setCompleEndCli(cliente.getCompleEndCli());
            clienteToUpdate.setFone1Cli(cliente.getFone1Cli());
            clienteToUpdate.setFone2Cli(cliente.getFone2Cli());
            clienteToUpdate.setEmailCli(cliente.getEmailCli());
            clienteToUpdate.setSiteCli(cliente.getSiteCli());
            clienteToUpdate.setContatoCli(cliente.getContatoCli());
            clienteToUpdate.setEmailContato(cliente.getEmailContato());
            clienteToUpdate.setCnpjCli(cliente.getCnpjCli());
            clienteToUpdate.setInscriCli(cliente.getInscriCli());
            clienteToUpdate.setObsCli(cliente.getObsCli());
            clienteToUpdate.setStatusCli(cliente.getStatusCli());
            cliente = entityManager.merge(clienteToUpdate);
        }
        return cliente;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        entityManager.remove(getClientes(id));
    }   
      
}


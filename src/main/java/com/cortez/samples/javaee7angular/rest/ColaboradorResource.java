
package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Bairros;
import com.cortez.samples.javaee7angular.data.Colaboradores;
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
public class ColaboradorResource 
{
    private EntityManager entityManager ;

    public ColaboradorResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    
    
    private Integer countColaboradores() {
        Query query = entityManager.createQuery("SELECT COUNT(o.id) FROM Colaboradores o");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Colaboradores> findColaboradores(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT o FROM COLABORADORES o ORDER BY o." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findColaboradores(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countColaboradores());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findColaboradores(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listColaboradores(@DefaultValue("1")
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
        return findColaboradores(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Colaboradores getColaboradores(@PathParam("id") Long id) {
        return entityManager.find(Colaboradores.class, id);
    }

    @POST
    public Colaboradores saveColaborador(Colaboradores colaborador) {
        if (colaborador.getId() == null) {
            Colaboradores colaboradorToSave = new Colaboradores();
            colaboradorToSave.setNomeCola(colaborador.getNomeCola());
            colaboradorToSave.setFone1Cola(colaborador.getFone1Cola());
            colaboradorToSave.setFone2Cola(colaborador.getFone2Cola());
            colaboradorToSave.setEmailCola(colaborador.getEmailCola());
            colaboradorToSave.setObsCola(colaborador.getObsCola());
            colaboradorToSave.setStatusCola(colaborador.getStatusCola());
            entityManager.persist(colaborador);
        } else {
            Colaboradores colaboradorToUpdate = getColaboradores(colaborador.getId());
            colaboradorToUpdate.setNomeCola(colaborador.getNomeCola());
            colaboradorToUpdate.setFone1Cola(colaborador.getFone1Cola());
            colaboradorToUpdate.setFone2Cola(colaborador.getFone2Cola());
            colaboradorToUpdate.setEmailCola(colaborador.getEmailCola());
            colaboradorToUpdate.setObsCola(colaborador.getObsCola());
            colaboradorToUpdate.setStatusCola(colaborador.getStatusCola());
            colaborador = entityManager.merge(colaboradorToUpdate);
        }

        return colaborador;
    }

    @DELETE
    @Path("{id}")
    public void deleteColaborador(@PathParam("id") Long id) {
        entityManager.remove(getColaboradores(id));
    }  
    
    
}

package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Bairros;
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
public class BairroResource {

    private EntityManager entityManager;

    public BairroResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    private Integer countBairros() {
        Query query = entityManager.createQuery("SELECT COUNT(b.id) FROM Bairros b");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Bairros> findBairros(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query
                = entityManager.createQuery("SELECT b FROM BAIRROS b ORDER BY b." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findBairros(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countBairros());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findBairros(start,
                wrapper.getPageSize(),
                wrapper.getSortFields(),
                wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listBairros(@DefaultValue("1")
            @QueryParam("page") Integer page,
            @DefaultValue("id")
            @QueryParam("sortFields") String sortFields,
            @DefaultValue("asc")
            @QueryParam("sortDirections") String sortDirections) {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findBairros(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Bairros getBairros(@PathParam("id") Long id) {
        return entityManager.find(Bairros.class, id);
    }

    @POST
    public Bairros saveBairro(Bairros bairro) {
        entityManager.getTransaction().begin();
        if (bairro.getId() == null) {
            Bairros bairroToSave = new Bairros();
            bairroToSave.setDescricao(bairro.getDescricao());
            bairroToSave.setStatusBai(bairro.getStatusBai());
            entityManager.persist(bairro);
        } else {
            Bairros bairroToUpdate = getBairros(bairro.getId());
            bairroToUpdate.setDescricao(bairro.getDescricao());
            bairroToUpdate.setStatusBai(bairro.getStatusBai());
            bairro = entityManager.merge(bairroToUpdate);
        }
        entityManager.getTransaction().commit();
        return bairro;
    }

    @DELETE
    @Path("{id}")
    public void deleteBairro(@PathParam("id") Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getBairros(id));
        entityManager.getTransaction().commit();
    }

}

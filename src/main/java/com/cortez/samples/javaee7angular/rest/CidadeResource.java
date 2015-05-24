package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Cidades;
import com.cortez.samples.javaee7angular.pagination.PaginatedListWrapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.persistence.Persistence;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    private EntityManager entityManager;

    public CidadeResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    private Integer countCidades() {
        Query query = entityManager.createQuery("SELECT COUNT(c.id) FROM Cidades c");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Cidades> findCidades(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query
                = entityManager.createQuery("SELECT c FROM Cidades c ORDER BY c." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findCidades(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countCidades());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findCidades(start,
                wrapper.getPageSize(),
                wrapper.getSortFields(),
                wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listCidades(@DefaultValue("1")
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
        return findCidades(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Cidades getCidade(@PathParam("id") Long id) {
        return entityManager.find(Cidades.class, id);
    }

    @POST
    public Cidades saveCidade(Cidades cidade) {
        if (cidade.getId() == null) {
            Cidades cidadeToSave = new Cidades();
            cidadeToSave.setNomeCid(cidade.getNomeCid());
            cidadeToSave.setSiglaUf(cidade.getSiglaUf());
            cidadeToSave.setStatusCid(cidade.getStatusCid());
            entityManager.persist(cidade);
        } else {
            Cidades cidadeToUpdate = getCidade(cidade.getId());
            cidadeToUpdate.setNomeCid(cidade.getNomeCid());
            cidadeToUpdate.setSiglaUf(cidade.getSiglaUf());
            cidadeToUpdate.setStatusCid(cidade.getStatusCid());
            cidade = entityManager.merge(cidadeToUpdate);
        }

        return cidade;
    }

    @DELETE
    @Path("{id}")
    public void deleteCidade(@PathParam("id") Long id) {
        entityManager.remove(getCidade(id));
    }
}

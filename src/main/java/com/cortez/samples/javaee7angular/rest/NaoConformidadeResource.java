package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.NaoConformidades;
import com.cortez.samples.javaee7angular.pagination.PaginatedListWrapper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class NaoConformidadeResource 
{
 
    private EntityManager entityManager ;

    public NaoConformidadeResource() {
        entityManager = Persistence.createEntityManagerFactory("PathPersist").createEntityManager();
    }
     

    private Integer countNaoConformidadesResource() {
        Query query = entityManager.createQuery("SELECT COUNT(NC.id) FROM NaoConformidades NC");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<NaoConformidades> findNaoConformidades(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT NC FROM NAOCONFORMIDADES NC ORDER BY NC." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findNaoConformidades(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countNaoConformidades());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findNaoConformidades(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listNaoConformidades(@DefaultValue("1")
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
        return findNaoConformidades(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public NaoConformidades getNaoConformidades(@PathParam("id") Long id) {
        return entityManager.find(NaoConformidades.class,id);
    }

    @POST
    public NaoConformidades saveNaoConformidades(NaoConformidades naoConformidades) {
        if (naoConformidades.getId() == null) {
            NaoConformidades naoConformidadesToSave = new NaoConformidades();            
            naoConformidadesToSave.setIdCola(naoConformidades.getIdCola());
            naoConformidadesToSave.setIdPontoCtrl(naoConformidades.getIdPontoCtrl());
            naoConformidadesToSave.setDtHrCadNc(naoConformidades.getDtHrCadNc());
            naoConformidadesToSave.setDtPrevResolNc(naoConformidades.getDtPrevResolNc());
            naoConformidadesToSave.setDtAtualiza(naoConformidades.getDtAtualiza());
            naoConformidadesToSave.setDescriNc(naoConformidades.getDescriNc());
            naoConformidadesToSave.setSugestaoNc(naoConformidades.getSugestaoNc());
            naoConformidadesToSave.setObsNc(naoConformidades.getObsNc());
            naoConformidadesToSave.setStatusNc(naoConformidades.getStatusNc());
            entityManager.persist(naoConformidades);
        } else {
            NaoConformidades naoConformidadesToUpdate = getNaoConformidades(naoConformidades.getId());
            naoConformidadesToUpdate.setIdCola(naoConformidades.getIdCola());
            naoConformidadesToUpdate.setIdPontoCtrl(naoConformidades.getIdPontoCtrl());
            naoConformidadesToUpdate.setDtHrCadNc(naoConformidades.getDtHrCadNc());
            naoConformidadesToUpdate.setDtPrevResolNc(naoConformidades.getDtPrevResolNc());
            naoConformidadesToUpdate.setDtAtualiza(naoConformidades.getDtAtualiza());
            naoConformidadesToUpdate.setDescriNc(naoConformidades.getDescriNc());
            naoConformidadesToUpdate.setSugestaoNc(naoConformidades.getSugestaoNc());
            naoConformidadesToUpdate.setObsNc(naoConformidades.getObsNc());
            naoConformidadesToUpdate.setStatusNc(naoConformidades.getStatusNc());
            naoConformidades = entityManager.merge(naoConformidadesToUpdate);
        }
        return naoConformidades;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        entityManager.remove(getNaoConformidades(id));
    }

    private Integer countNaoConformidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}

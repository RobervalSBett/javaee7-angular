package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Auditores;
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
public class AuditorResource {

    private EntityManager entityManager;

    public AuditorResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    private Integer countAuditores() {
        Query query = entityManager.createQuery("SELECT COUNT(au.id) FROM Auditores au");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Auditores> findAuditores(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query
                = entityManager.createQuery("SELECT au FROM Auditores au ORDER BY au." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findAuditores(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countAuditores());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findAuditores(start,
                wrapper.getPageSize(),
                wrapper.getSortFields(),
                wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listAuditores(@DefaultValue("1")
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
        return findAuditores(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Auditores getAuditores(@PathParam("id") Long id) {
        return entityManager.find(Auditores.class, id);
    }

    @POST
    public Auditores saveAuditor(Auditores auditor) {
        if (auditor.getId() == null) {
            Auditores auditorToSave = new Auditores();
            auditorToSave.setCepAudit(auditor.getCepAudit());
            auditorToSave.setNomeAudit(auditor.getNomeAudit());
            auditorToSave.setCpfAudit(auditor.getCpfAudit());
            auditorToSave.setFone1Audit(auditor.getFone1Audit());
            auditorToSave.setFone2Audit(auditor.getFone2Audit());
            auditorToSave.setEmailAudit(auditor.getEmailAudit());
            auditorToSave.setCompleEndAudit(auditor.getCompleEndAudit());
            auditorToSave.setTipoAudit(auditor.getTipoAudit());
            auditorToSave.setObsAudit(auditor.getObsAudit());
            auditorToSave.setUsuAudit(auditor.getUsuAudit());
            auditorToSave.setSenhAudit(auditor.getSenhAudit());
            auditorToSave.setStatusAuditores(auditor.getStatusAuditores());
            entityManager.persist(auditor);
        } else {
            Auditores auditorToUpdate = getAuditores(auditor.getId());
            auditorToUpdate.setCepAudit(auditor.getCepAudit());
            auditorToUpdate.setNomeAudit(auditor.getNomeAudit());
            auditorToUpdate.setCpfAudit(auditor.getCpfAudit());
            auditorToUpdate.setFone1Audit(auditor.getFone1Audit());
            auditorToUpdate.setFone2Audit(auditor.getFone2Audit());
            auditorToUpdate.setEmailAudit(auditor.getEmailAudit());
            auditorToUpdate.setCompleEndAudit(auditor.getCompleEndAudit());
            auditorToUpdate.setTipoAudit(auditor.getTipoAudit());
            auditorToUpdate.setObsAudit(auditor.getObsAudit());
            auditorToUpdate.setUsuAudit(auditor.getUsuAudit());
            auditorToUpdate.setSenhAudit(auditor.getSenhAudit());
            auditorToUpdate.setStatusAuditores(auditor.getStatusAuditores());
            auditor = entityManager.merge(auditorToUpdate);
        }
        return auditor;
    }

    @DELETE
    @Path("{id}")
    public void deleteAuditor(@PathParam("id") Long id) {
        entityManager.remove(getAuditores(id));
    }

}

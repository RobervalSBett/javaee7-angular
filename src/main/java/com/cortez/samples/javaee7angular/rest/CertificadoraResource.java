package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Certificadoras;
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

public class CertificadoraResource 
{
      private EntityManager entityManager ;

    public CertificadoraResource() {
        entityManager = Persistence.createEntityManagerFactory("PathPersist").createEntityManager();
    }
    

    private Integer countCertificadoras() {
        Query query = entityManager.createQuery("SELECT COUNT(cert.id) FROM Certificadoras cert");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Certificadoras> findCertificadoras(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT cert.ID FROM Certificadoras CERT ORDER BY CERT." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findCertificadoras(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countCertificadoras());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findCertificadoras(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listCertificadoras(@DefaultValue("1")
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
        return findCertificadoras(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Certificadoras getCertificadoras(@PathParam("id") Long id) {
        return entityManager.find(Certificadoras.class, id);
    }

    @POST
    public Certificadoras saveCertificadoras(Certificadoras certificadora) {
        if (certificadora.getId() == null) {
            Certificadoras certificadoraToSave = new Certificadoras();            
            certificadoraToSave.setId(certificadora.getId());
            certificadoraToSave.setCep(certificadora.getCep());
            certificadoraToSave.setFantaCert(certificadora.getFantaCert());
            certificadoraToSave.setCompleEndCert(certificadora.getCompleEndCert());
            certificadoraToSave.setFone1Cert(certificadora.getFone1Cert());
            certificadoraToSave.setFone2Cert(certificadora.getFone2Cert());
            certificadoraToSave.setEmailCert(certificadora.getEmailCert());
            certificadoraToSave.setSiteCert(certificadora.getSiteCert());
            certificadoraToSave.setContatoCert(certificadora.getContatoCert());
            certificadoraToSave.setRazaoCert(certificadora.getRazaoCert());
            certificadoraToSave.setCnpjCert(certificadora.getCnpjCert());
            certificadoraToSave.setInscriCert(certificadora.getInscriCert());
            certificadoraToSave.setObsCert(certificadora.getObsCert());
            certificadoraToSave.setStatusCert(certificadora.getStatusCert());
            entityManager.persist(certificadora);
        } else {
            Certificadoras certificadoraToUpdate = getCertificadoras(certificadora.getId());
            certificadoraToUpdate.setCep(certificadora.getCep());
            certificadoraToUpdate.setFantaCert(certificadora.getFantaCert());
            certificadoraToUpdate.setCompleEndCert(certificadora.getCompleEndCert());
            certificadoraToUpdate.setFone1Cert(certificadora.getFone1Cert());
            certificadoraToUpdate.setFone2Cert(certificadora.getFone2Cert());
            certificadoraToUpdate.setEmailCert(certificadora.getEmailCert());
            certificadoraToUpdate.setSiteCert(certificadora.getSiteCert());
            certificadoraToUpdate.setContatoCert(certificadora.getContatoCert());
            certificadoraToUpdate.setRazaoCert(certificadora.getRazaoCert());
            certificadoraToUpdate.setCnpjCert(certificadora.getCnpjCert());
            certificadoraToUpdate.setInscriCert(certificadora.getInscriCert());
            certificadoraToUpdate.setObsCert(certificadora.getObsCert());
            certificadoraToUpdate.setStatusCert(certificadora.getStatusCert());
            certificadora = entityManager.merge(certificadoraToUpdate);
        }
        return certificadora;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        entityManager.remove(getCertificadoras(id));
    } 
}

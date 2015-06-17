package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.CheckList;
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

public class CheckListResource 
{
  private EntityManager entityManager ;

    public CheckListResource() {
        entityManager = Persistence.createEntityManagerFactory("PathPersist").createEntityManager();
    }
  

    private Integer  countCheckList()
    {
        Query query = entityManager.createQuery("SELECT COUNT(chkl.id) FROM CheckList chkl");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<CheckList> findCheckList(int startPosition, int maxResults, String sortFields, String sortDirections)
    {
        Query query =
                entityManager.createQuery("SELECT chkl FROM CheckList au ORDER BY chkl." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findCheckList(PaginatedListWrapper wrapper)
    {
        wrapper.setTotalResults(countCheckList());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findCheckList(start,
                                       wrapper.getPageSize(),
                                       wrapper.getSortFields(),
                                       wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listCheckList(@DefaultValue("1")
                                               @QueryParam("page")
                                               Integer page,
                                               @DefaultValue("id")
                                               @QueryParam("sortFields")
                                               String sortFields,
                                               @DefaultValue("asc")
                                               @QueryParam("sortDirections")
                                               String sortDirections)
    {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findCheckList(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public CheckList getCheckList(@PathParam("id") Long id)
    {
        return entityManager.find(CheckList.class, id);
    }

    @POST
    public CheckList saveCheckList(CheckList checklist)
    {
        if (checklist.getId() == null)
          {
              CheckList checklistToSave = new CheckList();            
              checklistToSave.setId(checklist.getId());                       
              checklistToSave.setDocProcesso(checklist.getDocProcesso());                         
              checklistToSave.setDescriChklist(checklist.getDescriChklist());            
              checklistToSave.setObsChklist(checklist.getObsChklist());            
              checklistToSave.setDtHrRealiChklist(checklist.getDtHrRealiChklist());                      
              checklistToSave.setDtAtualiza(checklist.getDtAtualiza());                                  
              checklistToSave.setStatusChklist(checklist.getStatusChklist());
              entityManager.persist(checklist);
          } 
        else
          {
              CheckList checklistToUpdate = getCheckList(checklist.getId());
              checklistToUpdate.setId(checklist.getId());                       
              checklistToUpdate.setDocProcesso(checklist.getDocProcesso());                         
              checklistToUpdate.setDescriChklist(checklist.getDescriChklist());            
              checklistToUpdate.setObsChklist(checklist.getObsChklist());            
              checklistToUpdate.setDtHrRealiChklist(checklist.getDtHrRealiChklist());                      
              checklistToUpdate.setDtAtualiza(checklist.getDtAtualiza());            
              checklistToUpdate.setStatusChklist(checklist.getStatusChklist());                        
              checklist = entityManager.merge(checklistToUpdate);
          }
        return checklist;
    }

    @DELETE
    @Path("{id}")
    public void deleteCheckList(@PathParam("id") Long id)
    {
        entityManager.remove(getCheckList(id));
    }   
        
}

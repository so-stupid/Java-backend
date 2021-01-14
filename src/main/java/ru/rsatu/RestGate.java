package ru.rsatu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rsatu.pojo.request.SaveWorkerRequest;
import ru.rsatu.pojo.response.GetTypeWorkerList;
import ru.rsatu.pojo.response.GetWorkersList;
import ru.rsatu.pojo.response.SaveWorkerResponse;
import ru.rsatu.services.WorkerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class RestGate {
    private static final Logger logger = LoggerFactory.getLogger(RestGate.class.getName());

    @Inject
    WorkerService workerService;

    /*
    *Тестовый прогон
    */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    /*
     * Метод сохранения работника
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveWorker")
    public Response saveWorker(SaveWorkerRequest saveWorkerRequest) {
        SaveWorkerResponse result = null;
        try {
            result = this.workerService.saveWorker(saveWorkerRequest);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok().build();
    }

    /*
     * Вывод всех работников
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getWorkersList")
    public Response getWorkersList() {
        GetWorkersList result = null;
        try {
            result = this.workerService.getWorkersList() ;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok(result).build();
    }

    /*
     * Вывод всех типов работников
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTypeWorkerList")
    public Response getTypeWorkerList() {
        GetTypeWorkerList result = null;
        try {
            result = this.workerService.getTypeWorkerList() ;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok(result).build();
    }


}
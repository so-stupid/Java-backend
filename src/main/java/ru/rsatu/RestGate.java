package ru.rsatu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rsatu.pojo.request.SavePriceRequest;
import ru.rsatu.pojo.request.SaveWorkerRequest;
import ru.rsatu.pojo.response.price.GetPriceList;
import ru.rsatu.pojo.response.price.SavePriceResponse;
import ru.rsatu.pojo.response.workers.GetTypeWorkerList;
import ru.rsatu.pojo.response.workers.GetWorkersList;
import ru.rsatu.pojo.response.workers.SaveWorkerResponse;
import ru.rsatu.services.WorkerService;
import ru.rsatu.services.PriceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class RestGate {
    private static final Logger logger = LoggerFactory.getLogger(RestGate.class.getName());

    @Inject
    WorkerService workerService;

    @Inject
    PriceService priceService;


//   ============= Методы для управления рабочими ===========

    /**
     * Метод для сохранения работника
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

    /**
     * Метод для вывода всех работников
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getWorkersList")
    public Response getWorkersList() {
        GetWorkersList result = null;
        try {
            result = this.workerService.getWorkersList();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok(result).build();
    }

    /**
     * Метод для вывода всех профессий
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

    //   ============= Методы для управления прайс листом ===========

    /**
     * Метод для вывода всех цен
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPriceList")
    public Response getPriceList() {
        GetPriceList result = null;
        try {
            result = this.priceService.getPriceList();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok(result).build();
    }

    /**
     * Метод для сохранения услуги
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/savePrice")
    public Response savePrice(SavePriceRequest savePriceRequest) {
        SavePriceResponse result = null;
        try {
            result = this.priceService.savePrice(savePriceRequest);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return Response.ok().build();
    }


}
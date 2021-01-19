package ru.rsatu.services;

import ru.rsatu.pojo.*;
import ru.rsatu.pojo.request.SaveOrderRequest;
import ru.rsatu.pojo.response.orders.GetOrdersList;
import ru.rsatu.pojo.response.orders.SaveOrderResponse;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OrdersService {

    public String getAllOrderQ = "select  client.firstname, client.lastname,\n" +
            "        auto.mark, auto.lastmark, auto.govlicense,\n" +
            "        orders.date,\n" +
            "       workers.firstnamew, workers.lastnamew\n" +
            "from orders\n" +
            "    join auto on orders.auto = auto.id\n" +
            "    join client on orders.client = client.id\n" +
            "    join workers  on orders.worker = workers.id";

    public String getMaxAutoId = "select f from auto f order by f.id DESC";
    public String getMaxClientId = "select f from client f order by f.id DESC";
    public String getTempWorker = "select f from workers f where f.id = 1";

    @Inject
    EntityManager entityManager;

    /**
     * Получить список всех заказов
     */
    public GetOrdersList getOrdersList() {
        GetOrdersList result = new GetOrdersList();
//        Query query = entityManager.createQuery("select sg from orders sg");          //WHQL
        Query query = entityManager.createNativeQuery(getAllOrderQ);   //Native
        List ordersList = query.getResultList();

        result.setOrders(ordersList);
        return result;
    }
//

    /**
     * Метод для сохранения заказа
     */
    @Transactional
    public SaveOrderResponse saveOrder(SaveOrderRequest request) throws Exception {
        SaveOrderResponse result = new SaveOrderResponse();
        Orders order = request.getOrder();

        Auto tempAuto = order.getAuto();
        Query queryCurrentAuto = entityManager.createQuery(getMaxAutoId);
        List<Auto> currentAutoList = queryCurrentAuto.getResultList();
        Auto currentAutoObj = currentAutoList.get(0);
        Long currentAutoId = currentAutoObj.getId();
        tempAuto.setId(currentAutoId);
        order.setAuto(tempAuto);

        Client tempClient = order.getClient();
        Query queryCurrentClient = entityManager.createQuery(getMaxClientId);
        List<Client> currentClient = queryCurrentClient.getResultList();
        Client currentClientObj = currentClient.get(0);
        Long currentClientId = currentClientObj.getId();
        tempClient.setId(currentClientId);
        order.setClient(tempClient);

        Worker tempWorker = new Worker();
        tempWorker.setId(1L);
        order.setWorker(tempWorker);

        order.setDate(new Date());

        if (order.getId() == null) {
            this.entityManager.persist(order);
        } else {
            this.entityManager.merge(order);
        }
        this.entityManager.flush();
        result.setOrder(order);
        return result;
    }
}


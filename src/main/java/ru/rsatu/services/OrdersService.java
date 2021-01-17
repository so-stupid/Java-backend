package ru.rsatu.services;
import ru.rsatu.pojo.Orders;
import ru.rsatu.pojo.Price;
import ru.rsatu.pojo.TypeWorker;
import ru.rsatu.pojo.Worker;
import ru.rsatu.pojo.request.SaveOrderRequest;
import ru.rsatu.pojo.request.SavePriceRequest;
import ru.rsatu.pojo.request.SaveWorkerRequest;
import ru.rsatu.pojo.response.orders.GetOrdersList;
import ru.rsatu.pojo.response.orders.SaveOrderResponse;
import ru.rsatu.pojo.response.price.SavePriceResponse;
import ru.rsatu.pojo.response.workers.SaveWorkerResponse;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
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

    public String getAllOrderByClient = "";

    public String getAllOrderByWorker = "select  client.firstname, client.lastname,\n" +
            "        auto.mark, auto.lastmark, auto.govlicense,\n" +
            "        orders.date,\n" +
            "       workers.firstnamew, workers.lastnamew\n" +
            "from orders\n" +
            "    join auto on orders.auto = auto.id\n" +
            "    join client on orders.client = client.id\n" +
            "    join workers  on orders.worker = workers.id\n" +
            "where workers.id = 1\n";

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

    // TODO Выпилить
    /**
     * Получить список всех заказов для работника
     */
    public GetOrdersList getOrdersListForWorker() {
        GetOrdersList result = new GetOrdersList();
        Query query = entityManager.createNativeQuery(getAllOrderByWorker);   //Native
        List ordersList = query.getResultList();

        result.setOrders(ordersList);
        return result;
    }

    /**
     * Метод для сохранения заказа
     */
//    @Transactional
//    public SaveOrderResponse saveOrder(SaveOrderRequest request) throws Exception {
//        SaveOrderResponse result = new SaveOrderResponse();
//        Orders order = request.getOrder();
//
//        // Проверяем корректность группы
//        TypeWorker typeWorker = this.entityManager.find(TypeWorker.class, worker.getTypeWorker().getId());
//        if (typeWorker == null) {
//            throw new Exception("Prof is null");
//        }
//        worker.setTypeWorker(typeWorker);
//        if (worker.getId() == null) {
//            this.entityManager.persist(worker);
//        } else {
//            this.entityManager.merge(worker);
//        }
//        this.entityManager.flush();
//        return result;
//    }
}


package ru.rsatu.services;
import ru.rsatu.pojo.response.orders.GetOrdersList;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class OrdersService {
    public String getAllOrderQ = "select  client.firstname, client.lastname,\n" +
            "        auto.mark, auto.lastmark, auto.govlicense,\n" +
            "       orders.date,\n" +
            "       workers.fullname\n" +
            "from orders\n" +
            "    join auto on orders.auto = auto.id\n" +
            "    join client on orders.client = client.id\n" +
            "    join workers  on orders.worker = workers.id\n";

    public String getGetAllOrderByClient = "";

    public String getGetGetAllOrderByWorker = "";

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

}

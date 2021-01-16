package ru.rsatu.pojo.response.orders;
import ru.rsatu.pojo.Orders;

import java.util.List;

public class GetOrdersList {

    private List<Orders> orders;

    public GetOrdersList() {
    }


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}

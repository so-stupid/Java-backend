package ru.rsatu.pojo.response.orders;

import ru.rsatu.pojo.Orders;

public class GetOrder {

    private Orders order;

    public GetOrder() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}

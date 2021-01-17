package ru.rsatu.pojo.request;

import ru.rsatu.pojo.Orders;

public class SaveOrderRequest {

    public Orders order;

    public SaveOrderRequest() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}

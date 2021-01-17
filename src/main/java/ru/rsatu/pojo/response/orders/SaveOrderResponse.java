package ru.rsatu.pojo.response.orders;

import ru.rsatu.pojo.Orders;

public class SaveOrderResponse {

    private Orders order;

    public SaveOrderResponse() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}

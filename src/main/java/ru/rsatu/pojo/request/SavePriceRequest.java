package ru.rsatu.pojo.request;

import ru.rsatu.pojo.Price;

public class SavePriceRequest {

    private Price price;

    public SavePriceRequest() {
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}

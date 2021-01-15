package ru.rsatu.pojo.response.price;

import ru.rsatu.pojo.Price;

public class SavePriceResponse {

    private Price price;

    public SavePriceResponse() {
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}

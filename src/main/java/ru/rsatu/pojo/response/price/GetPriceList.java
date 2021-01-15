package ru.rsatu.pojo.response.price;

import ru.rsatu.pojo.Price;

import java.util.List;

public class GetPriceList {

    private List<Price> priceList;

    public GetPriceList() {
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }
}

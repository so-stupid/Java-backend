package ru.rsatu.services;

import ru.rsatu.pojo.Price;
import ru.rsatu.pojo.response.price.GetPriceList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class PriceService {

    @Inject
    EntityManager entityManager;

    /**
     * Получить список расценок
     */
    public GetPriceList getPriceList() {
        GetPriceList result = new GetPriceList();
        Query query = entityManager.createNativeQuery("select *" + "from price");   //Native
        List<Price> priceList = query.getResultList();

        result.setPriceList(priceList);
        return result;
    }
}

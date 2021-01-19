package ru.rsatu.services;
import ru.rsatu.pojo.Price;
import ru.rsatu.pojo.request.SavePriceRequest;
import ru.rsatu.pojo.response.price.GetPriceList;
import ru.rsatu.pojo.response.price.SavePriceResponse;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
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
        Query query = entityManager.createQuery("select sg from price sg");
        List<Price> priceList = query.getResultList();

        result.setPriceList(priceList);
        return result;
    }

    /**
     * Метод для сохранения услуги
     */
    @Transactional
    public SavePriceResponse savePrice(SavePriceRequest request) throws Exception {
        SavePriceResponse result = new SavePriceResponse();
        Price price = request.getPrice();
        if (price.getId() == null) {
            this.entityManager.persist(price);
        } else {
            this.entityManager.merge(price);
        }
        this.entityManager.flush();
        return result;
    }
}

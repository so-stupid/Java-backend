package ru.rsatu.services;

import ru.rsatu.pojo.Auto;
import ru.rsatu.pojo.request.SaveAutoRequest;
import ru.rsatu.pojo.response.auto.SaveAutoResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class AutoService {

    @Inject
    EntityManager entityManager;

    /**
     * Метод для сохранения автомобиля
     */
    @Transactional
    public SaveAutoResponse saveAuto(SaveAutoRequest request) throws Exception {
        SaveAutoResponse result = new SaveAutoResponse();
        Auto auto = request.getAuto();
        if (auto.getId() == null) {
            this.entityManager.persist(auto);
        } else {
            this.entityManager.merge(auto);
        }
        this.entityManager.flush();
        return result;
    }
}

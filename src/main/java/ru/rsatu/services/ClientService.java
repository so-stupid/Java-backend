package ru.rsatu.services;

import ru.rsatu.pojo.Client;
import ru.rsatu.pojo.request.SaveClientRequest;
import ru.rsatu.pojo.response.client.SaveClientResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClientService {

    @Inject
    EntityManager entityManager;

    /**
     * Метод для сохранения клиента
     */
    @Transactional
    public SaveClientResponse saveClient(SaveClientRequest request) throws Exception {
        SaveClientResponse result = new SaveClientResponse();
        Client client = request.getClient();
        if (client.getId() == null) {
            this.entityManager.persist(client);
        } else {
            this.entityManager.merge(client);
        }
        this.entityManager.flush();
        return result;
    }

}

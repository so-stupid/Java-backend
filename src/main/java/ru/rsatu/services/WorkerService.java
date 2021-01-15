package ru.rsatu.services;

import ru.rsatu.pojo.TypeWorker;
import ru.rsatu.pojo.Worker;
import ru.rsatu.pojo.request.SaveWorkerRequest;
import ru.rsatu.pojo.response.workers.GetTypeWorkerList;
import ru.rsatu.pojo.response.workers.GetWorkersList;
import ru.rsatu.pojo.response.workers.SaveWorkerResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
public class WorkerService {

    @Inject
    EntityManager entityManager;

    /**
     * Метод для сохранения работника
     */
    @Transactional
    public SaveWorkerResponse saveWorker(SaveWorkerRequest request) throws Exception {
        SaveWorkerResponse result = new SaveWorkerResponse();
        Worker worker = request.getWorker();

        // Проверяем корректность группы
        TypeWorker typeWorker = this.entityManager.find(TypeWorker.class, worker.getTypeWorker().getId());
        if (typeWorker == null) {
            throw new Exception("Prof is null");
        }
        worker.setTypeWorker(typeWorker);
        if (worker.getId() == null) {
            this.entityManager.persist(worker);
        } else {
            this.entityManager.merge(worker);
        }
        this.entityManager.flush();
        return result;
    }

    /**
     * Получить список профессий
     */
    public GetTypeWorkerList getTypeWorkerList() {
        GetTypeWorkerList result = new GetTypeWorkerList();
//        Query query = entityManager.createQuery("select sg from type_worker sg");          //WHQL
        Query query = entityManager.createNativeQuery("select *" + "from type_worker");   //Native
        List<TypeWorker> typeWorkerList = query.getResultList();

        result.setTypeWorkerList(typeWorkerList);
        return result;
    }

    /**
     * Получить список работников
     */
    public GetWorkersList getWorkersList() {
        GetWorkersList result = new GetWorkersList();
       Query query = entityManager.createQuery("select sg from workers sg");          //WHQL
//        Query query = entityManager.createNativeQuery("select *" + "from workers");   //Native
        List<Worker> workersList = query.getResultList();

        result.setWorkersList(workersList);
        return result;
    }
}


package ru.rsatu.pojo.response;

import ru.rsatu.pojo.TypeWorker;
import ru.rsatu.pojo.Worker;

import java.util.List;

public class GetWorkersList {

    private List<Worker> workersList;

    public GetWorkersList() {
    }

    public List<Worker> getWorkersList() {
        return workersList;
    }

    public void setWorkersList(List<Worker> workersList) {
        this.workersList = workersList;
    }
}

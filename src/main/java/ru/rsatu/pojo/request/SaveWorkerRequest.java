package ru.rsatu.pojo.request;

import ru.rsatu.pojo.Worker;

public class SaveWorkerRequest {

    private Worker worker;

    public SaveWorkerRequest() {
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}

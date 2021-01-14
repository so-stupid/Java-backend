package ru.rsatu.pojo.response;

import ru.rsatu.pojo.TypeWorker;

import java.util.List;

public class GetTypeWorkerList {

    private List<TypeWorker> typeWorkerList;

    public GetTypeWorkerList() {
    }

    public List<TypeWorker> getTypeWorkerList() {
        return typeWorkerList;
    }

    public void setTypeWorkerList(List<TypeWorker> typeWorkerList) {
        this.typeWorkerList = typeWorkerList;
    }
}

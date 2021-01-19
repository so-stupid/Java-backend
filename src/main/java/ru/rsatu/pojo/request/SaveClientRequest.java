package ru.rsatu.pojo.request;

import ru.rsatu.pojo.Client;

public class SaveClientRequest {

    private Client client;

    public SaveClientRequest() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

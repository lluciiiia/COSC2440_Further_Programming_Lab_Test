package com.example.seokyungkim_s3939114.Facade;

import com.example.seokyungkim_s3939114.Model.Deliveryman;
import com.example.seokyungkim_s3939114.Request.InsertDeliverymanRequest;
import com.example.seokyungkim_s3939114.Request.UpdateDeliverymanRequest;

import java.util.List;

public interface DeliverymanFacade {
    void deleteDeliveryman(int id);

    Deliveryman getDeliverymanById(int id);

    void addDeliveryman(InsertDeliverymanRequest request);

    void updateDeliveryman(UpdateDeliverymanRequest request);

    List<Deliveryman> searchDeliverymansByName(String name);
}

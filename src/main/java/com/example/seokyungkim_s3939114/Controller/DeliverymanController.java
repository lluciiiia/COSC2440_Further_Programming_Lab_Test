package com.example.seokyungkim_s3939114.Controller;

import com.example.seokyungkim_s3939114.Facade.DeliverymanFacade;
import com.example.seokyungkim_s3939114.FacadeImpl.DeliverymanFacadeImpl;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Model.Deliveryman;
import com.example.seokyungkim_s3939114.Request.InsertDeliverymanRequest;
import com.example.seokyungkim_s3939114.Request.UpdateDeliverymanRequest;

import java.util.List;

public class DeliverymanController {

    private DeliverymanFacade deliverymanFacade;

    public DeliverymanController() {
        this.deliverymanFacade = new DeliverymanFacadeImpl();
    }

    public void addDeliveryman(InsertDeliverymanRequest request) {
        deliverymanFacade.addDeliveryman(request);
    }

    public void updateDeliveryman(UpdateDeliverymanRequest request) {
        deliverymanFacade.updateDeliveryman(request);
    }

    public void deleteDeliveryman(int id) {
        deliverymanFacade.deleteDeliveryman(id);
    }

    public Deliveryman getDeliverymanById(int id) {
        return deliverymanFacade.getDeliverymanById(id);
    }

    public List<Deliveryman> searchDeliverymansByName(String name) {
        return deliverymanFacade.searchDeliverymansByName(name);
    }
}

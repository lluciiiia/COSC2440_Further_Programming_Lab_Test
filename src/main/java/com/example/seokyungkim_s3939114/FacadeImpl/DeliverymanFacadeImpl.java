package com.example.seokyungkim_s3939114.FacadeImpl;

import com.example.seokyungkim_s3939114.Facade.DeliverymanFacade;
import com.example.seokyungkim_s3939114.Model.Deliveryman;
import com.example.seokyungkim_s3939114.Repository.DeliverymanRepository;
import com.example.seokyungkim_s3939114.Request.InsertDeliverymanRequest;
import com.example.seokyungkim_s3939114.Request.UpdateDeliverymanRequest;

import java.util.List;

public class DeliverymanFacadeImpl implements DeliverymanFacade {

    private DeliverymanRepository deliverymanRepository;

    public DeliverymanFacadeImpl() {
        this.deliverymanRepository = new DeliverymanRepository();
    }

    @Override
    public void addDeliveryman(InsertDeliverymanRequest request) {
        deliverymanRepository.addDeliveryman(request);
    }

    @Override
    public void updateDeliveryman(UpdateDeliverymanRequest request) {
        deliverymanRepository.updateDeliveryman(request);
    }

    @Override
    public List<Deliveryman> searchDeliverymansByName(String name) {
        return deliverymanRepository.searchDeliverymansByName(name);
    }

    @Override
    public void deleteDeliveryman(int id) {
        deliverymanRepository.deleteDeliverymanById(id);
    }

    @Override
    public Deliveryman getDeliverymanById(int id) {
        return deliverymanRepository.getDeliverymanById(id);
    }
}

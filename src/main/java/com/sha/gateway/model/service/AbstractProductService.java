package com.sha.gateway.model.service;

import com.google.gson.JsonElement;
import com.sha.gateway.channel.service.ProductServicesCallable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements EntityService<JsonElement, Integer>{

    @Autowired
    protected ProductServicesCallable productServicesCallable;

}

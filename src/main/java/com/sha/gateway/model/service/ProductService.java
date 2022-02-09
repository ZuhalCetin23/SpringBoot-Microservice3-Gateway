package com.sha.gateway.model.service;

import com.google.gson.JsonElement;
import com.sha.gateway.channel.utility.RetrofitUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ProductService extends AbstractProductService{
    @Override
    public List<JsonElement> findAll()
    {
        return RetrofitUtil.callGenericBlock(productServicesCallable.getAll());
    }

    @Override
    public JsonElement save(JsonElement entity)
    {
       return RetrofitUtil.callGenericBlock(productServicesCallable.save(entity));
    }

    @Override
    public void deleteByID(Integer id)
    {
       RetrofitUtil.callGenericBlock(productServicesCallable.deleteByID(id));
    }
}

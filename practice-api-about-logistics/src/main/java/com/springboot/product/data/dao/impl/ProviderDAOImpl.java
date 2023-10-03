package com.springboot.product.data.dao.impl;

import com.springboot.product.data.dao.ProviderDAO;
import com.springboot.product.data.entity.Provider;
import com.springboot.product.data.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProviderDAOImpl implements ProviderDAO {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderDAOImpl(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;

    }

    @Override
    public Provider insertProvider(Provider provider){
        Provider saveProvider = providerRepository.save(provider);

        return saveProvider;
    }

    @Override
    public Provider selectProvider(Long id){
        Provider selectProvider = providerRepository.getById(id);

        return selectProvider;
    }


    @Override
    public void deleteProvider(Long id) throws Exception{
        Optional<Provider> selectedProvider = providerRepository.findById(id);

        if (selectedProvider.isPresent()){
            Provider provider = selectedProvider.get();

            providerRepository.delete(provider);
        } else {
            throw new Exception();
        }
    }
}

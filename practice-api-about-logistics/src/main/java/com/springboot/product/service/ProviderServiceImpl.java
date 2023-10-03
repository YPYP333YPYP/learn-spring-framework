package com.springboot.product.service;


import com.springboot.product.data.dao.ProviderDAO;
import com.springboot.product.data.dto.ProviderDto;
import com.springboot.product.data.dto.ProviderResponseDto;
import com.springboot.product.data.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProviderServiceImpl implements ProviderService{

    private final ProviderDAO providerDAO;

    @Autowired
    public ProviderServiceImpl(ProviderDAO providerDAO){
        this.providerDAO = providerDAO;
    }

    @Override
    public ProviderResponseDto getProvider(Long id){
        Provider provider = providerDAO.selectProvider(id);

        ProviderResponseDto providerResponseDto = new ProviderResponseDto();

        providerResponseDto.setId(provider.getId());
        providerResponseDto.setName(provider.getName());

        return providerResponseDto;
    }

    @Override
    public ProviderResponseDto saveProvider(ProviderDto providerDto){
        Provider provider = new Provider();

        provider.setName(providerDto.getName());
        provider.setCreatedAt(LocalDateTime.now());
        provider.setUpdatedAt(LocalDateTime.now());

        Provider saveProvider = providerDAO.insertProvider(provider);

        ProviderResponseDto providerResponseDto = new ProviderResponseDto();

        providerResponseDto.setId(saveProvider.getId());
        providerResponseDto.setName(saveProvider.getName());

        return providerResponseDto;
    }

    @Override
    public void deleteProvider(Long id) throws Exception{
        providerDAO.deleteProvider(id);
    }
}

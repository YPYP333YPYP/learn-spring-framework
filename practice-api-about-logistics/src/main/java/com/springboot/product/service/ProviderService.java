package com.springboot.product.service;

import com.springboot.product.data.dto.ProviderDto;
import com.springboot.product.data.dto.ProviderResponseDto;

public interface ProviderService {

    ProviderResponseDto getProvider(Long id);

    ProviderResponseDto saveProvider(ProviderDto providerDto);

    void deleteProvider(Long id) throws Exception;
}

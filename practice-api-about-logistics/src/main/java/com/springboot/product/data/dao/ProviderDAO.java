package com.springboot.product.data.dao;

import com.springboot.product.data.entity.Provider;

public interface ProviderDAO {

    Provider insertProvider(Provider provider);

    Provider selectProvider(Long id);

    void deleteProvider(Long id) throws Exception;
}

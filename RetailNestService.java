package com.devmart.retailnestservice;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RetailNestService {

    private final RetailNestRepository vault;

    public RetailNestService(RetailNestRepository vault) {
        this.vault = vault;
    }

    public RetailShopEntity addShop(RetailShopEntity shop) {
        return vault.save(shop);
    }

    public List<RetailShopEntity> getAllShops() {
        return vault.findAll();
    }

    public RetailShopEntity updateShopStatus(Long shopId, boolean active) {
    	RetailShopEntity shop = vault.findById(shopId).orElseThrow();
        shop.setActive(active);
        return vault.save(shop);
    }
}

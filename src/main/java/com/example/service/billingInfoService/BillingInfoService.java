package com.example.service.billingInfoService;

import com.example.model.BillingInfo;
import com.example.model.User;

import javax.transaction.Transactional;
import java.util.List;


public interface BillingInfoService {
    List<BillingInfo> findAllFromRepository();

    String postBillingInfoFromRepository();

    BillingInfo findBillingInfoByCreditCard(String creditcard);

    BillingInfo findBillingInfoById(Long id);

    void updateBillingInfoById(Long id);

    User findUserByBillingInfoId(Long id);
}

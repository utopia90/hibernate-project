package com.example.dao.BillingInfoDAO;

import com.example.model.BillingInfo;
import com.example.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BillingInfoDAO {
    List<BillingInfo> findAllFromRepository();

    String postBillingInfoFromRepository();

    BillingInfo findBillingInfoByCreditCard(@PathVariable String creditcard);

    BillingInfo findBillingInfoById(@PathVariable Long id);

    void updateBillingInfoById(@PathVariable Long id);

    User findUserByBillingInfoId(@PathVariable Long id);
}

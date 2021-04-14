package com.example.service.billingInfoService;

import com.example.dao.BillingInfoDAO.BillingInfoDAO;
import com.example.dao.BillingInfoDAO.BillingInfoDAOImpl;
import com.example.dao.userDAO.UserDAO;
import com.example.model.BillingInfo;
import com.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BillingInfoServiceImpl implements BillingInfoService {
    private final BillingInfoDAO billingInfoDAO;


    public BillingInfoServiceImpl(BillingInfoDAO billingInfoDAO) {
        this.billingInfoDAO = billingInfoDAO;
    }
    @Override
    public List<BillingInfo> findAllFromRepository() {
        List<BillingInfo> billingInfos = this.billingInfoDAO.findAllFromRepository();
        return billingInfos;
    }

    @Override
    public String postBillingInfoFromRepository() {
        return this.billingInfoDAO.postBillingInfoFromRepository();
    }

    @Override
    public BillingInfo findBillingInfoByCreditCard(@PathVariable String creditcard) {
        BillingInfo billingInfo = this.billingInfoDAO.findBillingInfoByCreditCard(creditcard);

        return billingInfo;
    }

    @Override
    public BillingInfo findBillingInfoById(@PathVariable Long id) {
        BillingInfo billingInfo = this.billingInfoDAO.findBillingInfoById(id);
        return billingInfo;
    }

    @Override
    public void updateBillingInfoById(@PathVariable Long id) {
       this.billingInfoDAO.updateBillingInfoById(id);
    }

    @Override
    public User findUserByBillingInfoId(@PathVariable Long id) {
        User user = this.billingInfoDAO.findUserByBillingInfoId(id);
        return user;
    }
}



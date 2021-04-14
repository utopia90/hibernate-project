package com.example.dao.BillingInfoDAO;

import com.example.model.BillingInfo;
import com.example.model.User;
import com.example.repository.BillingInfoRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BillingInfoDAOImpl implements BillingInfoDAO{
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private BillingInfoRepository billingInfoRepository;

    @Autowired
    private UserRepository repository;


    @Override
    public List<BillingInfo> findAllFromRepository() {
        return billingInfoRepository.findAllEager();
    }

    @Override
    public String postBillingInfoFromRepository() {

        BillingInfo billingInfo1 = new BillingInfo("8292910C","INGDirect","transfer");
        BillingInfo billingInfo2 = new BillingInfo("92929229D","Santander","creditCard");
        BillingInfo billingInfo3 = new BillingInfo("192932932A","Bankia","Paypal");
        BillingInfo billingInfo4 = new BillingInfo("2939430234J","BBVA","cash");
        BillingInfo billingInfo5 = new BillingInfo("29322949G","Bankinter","transfer");

        User user1 = new User("Alejandro", "Cañizares", "8392394385D", false, "10/02/1989");
        User user2 = new User("Carla", "Rodriguez", "299234019F", true, "10/01/1978");
        User user3 = new User("Amapola", "Mena", "0202301494T", false, "06/07/1992");
        User user4 = new User("Paco", "Alcazar", "038483845S", true, "03/10/1982");
        User user5 = new User("Marta", "Casado", "39329349Y", true, "04/05/1996");


        if(billingInfoRepository.findBillingInfoByCreditCard(billingInfo1.getCreditCard()) == null){
            billingInfo1.setUser(user1);
            manager.persist(billingInfo1);
            manager.persist(user1);
        }else{
            return "billing info already exists";
        }
        if(billingInfoRepository.findBillingInfoByCreditCard(billingInfo2.getCreditCard()) == null){
            billingInfo2.setUser(user2);
            manager.persist(billingInfo2);
            manager.persist(user2);

        }else{
            return "billing info already exists";
        }
        if(billingInfoRepository.findBillingInfoByCreditCard(billingInfo3.getCreditCard()) == null){
            billingInfo3.setUser(user3);
            manager.persist(billingInfo3);
            manager.persist(user3);

        }else{
            return "billing info already exists";
        }
        if(billingInfoRepository.findBillingInfoByCreditCard(billingInfo4.getCreditCard()) == null){
            billingInfo4.setUser(user4);
            manager.persist(billingInfo4);
            manager.persist(user4);

        }else{
            return "billing info already exists";
        }
        if(billingInfoRepository.findBillingInfoByCreditCard(billingInfo5.getCreditCard()) == null){
            billingInfo5.setUser(user5);
            manager.persist(billingInfo5);
            manager.persist(user5);

        }else{
            return "billing info already exists";
        }

        return "billing info inserted succesfuly";
    }

    @Override
    public BillingInfo findBillingInfoByCreditCard(@PathVariable String creditcard) {
        return billingInfoRepository.findBillingInfoByCreditCard(creditcard);
    }

    @Override
    public BillingInfo findBillingInfoById(@PathVariable Long id) {
        return billingInfoRepository.findBillingInfoById(id);
    }

    @Override
    public void updateBillingInfoById(@PathVariable Long id) {
         billingInfoRepository.updateBillingInfoById(id);
    }

    @Override
    public User findUserByBillingInfoId(@PathVariable Long id) {
        return billingInfoRepository.findUserByBillingInfoId(id);
    }
}

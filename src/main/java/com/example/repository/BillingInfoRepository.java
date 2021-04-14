package com.example.repository;

import com.example.model.BillingInfo;
import com.example.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingInfoRepository extends JpaRepository<BillingInfo, Long> {
    @EntityGraph(attributePaths = "user")
    @Query("SELECT e FROM BillingInfo e")
    List<BillingInfo> findAllEager();

    @EntityGraph(attributePaths = {"creditCard"})
    @Query("SELECT e FROM BillingInfo e where e.creditCard = :creditCard")
    BillingInfo findBillingInfoByCreditCard(@Param("creditCard") String creditcard);

    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e FROM BillingInfo e where e.id = :id")
    BillingInfo findBillingInfoById(@Param("id")Long id);

    @EntityGraph(attributePaths = {"id"})
    @Modifying
    @Query("UPDATE BillingInfo set bankName='bankNameUpdated', creditCard='creditCardUpdated', paymentMethod='paymentMethodUpdated' where id = :id")
    void updateBillingInfoById(@Param("id")Long id);

    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e FROM User e INNER JOIN BillingInfo u ON e.id=u.id WHERE u.id =:id")
    User findUserByBillingInfoId(@Param("id")Long id);
}

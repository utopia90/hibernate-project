package com.example.controller;


import com.example.model.BillingInfo;
import com.example.model.User;
import com.example.service.billingInfoService.BillingInfoService;
import com.example.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingInfoController {
    private final BillingInfoService billingInfoService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);
    public BillingInfoController(BillingInfoService billingInfoService){
        this.billingInfoService = billingInfoService;
    }
    @GetMapping("/billinginfo")
    public List<BillingInfo> findAll() {
        return billingInfoService.findAllFromRepository();
    }
    @GetMapping("/billinginfo/creditcard/{creditcard}")
        public ResponseEntity<BillingInfo> findBillingInfoByCreditCard(@PathVariable String creditcard) {

            BillingInfo billingInfoOpt = billingInfoService.findBillingInfoByCreditCard(creditcard);
            if( billingInfoOpt != null){
                return ResponseEntity.ok().body(billingInfoOpt);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    @GetMapping("/billinginfo/id/{id}")
    public ResponseEntity<BillingInfo> findBillingInfoById(@PathVariable Long id) {

        BillingInfo billingInfoOpt = billingInfoService.findBillingInfoById(id);
        if( billingInfoOpt != null){
            return ResponseEntity.ok().body(billingInfoOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/billinginfo-user/id/{id}")
    public ResponseEntity<User> findUserByBillingInfoId(@PathVariable Long id) {

        User userOpt = billingInfoService.findUserByBillingInfoId(id);
        if(userOpt != null){
            return ResponseEntity.ok().body(userOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/billinginfo/post")
    public String  postBillingInfo(){
        return  billingInfoService.postBillingInfoFromRepository();
    }

    @PutMapping("/billinginfo/update/{id}")
    public  ResponseEntity<BillingInfo> updateBillingInfoById(@PathVariable("id") Long id) { log.debug("REST request to update a id{}", id);

        if(billingInfoService.findBillingInfoById(id) == null){
            log.warn("updating billing info without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            billingInfoService.updateBillingInfoById(id);
            return ResponseEntity.ok().body(billingInfoService.findBillingInfoById(id));
        }
    }
}

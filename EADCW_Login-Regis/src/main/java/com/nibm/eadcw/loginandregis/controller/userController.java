package com.nibm.eadcw.loginandregis.controller;

import com.nibm.eadcw.loginandregis.model.passConfirmation;
import com.nibm.eadcw.loginandregis.model.userAccount;
import com.nibm.eadcw.loginandregis.model.userAccountDetails;
import com.nibm.eadcw.loginandregis.repository.userAccountDetailsRepo;
import com.nibm.eadcw.loginandregis.repository.userAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/user")
public class userController {

    @Autowired
    private userAccountRepo accountRepo;

    @Autowired
    private userAccountDetailsRepo accountDetailsRepo;

    //test
    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping(path = "userLogind/")
    public ResponseEntity<passConfirmation> getUserByEmail(@RequestBody userAccount account){
//        userAccount user =this.accountRepo.findById(email);
//        System.out.println("Email:"+account.getEmail());
//        System.out.println("user:"+account.getUsername());
//        System.out.println("pass:"+account.getPassword());
        String passwordByEmail = accountRepo.getPasswordByEmail(account.getEmail().toString());
//        System.out.println("****************************************");
//        System.out.println("pass:"+account.getPassword());
//        System.out.println("passfromdb:"+ passwordByEmail);
            if (account.getPassword().toString().equals(passwordByEmail)){
                passConfirmation confirmationOK = new passConfirmation("Confirmed");
                return ResponseEntity.ok().body(confirmationOK);
            }else{
                passConfirmation confirmationDenied = new passConfirmation("Denied");
                return ResponseEntity.ok().body(confirmationDenied);
            }
    }

    //get all users
    @GetMapping("/userLogins")
    public List<userAccount> getAllAccountDetails() {
        return this.accountRepo.findAll();
    }

    //set Account details
    @PostMapping("/addAccDetails")
    public userAccountDetails setUserAccountDetails(@RequestBody userAccountDetails accountDetails) {
//        System.out.println("Email:"+accountDetails.getEmail());
//        System.out.println("name:"+accountDetails.getUsername());
//        System.out.println("add1:"+accountDetails.getAddresLine1());
//        System.out.println("add2:"+accountDetails.getAddresLine2());
//        System.out.println("pcode:"+accountDetails.getPostalCode());
//        System.out.println("aType:"+accountDetails.getUserAccountType());
//        System.out.println("age:"+accountDetails.getUserAge());
//        System.out.println("city:"+accountDetails.getUserCity());


        return this.accountDetailsRepo.save(accountDetails);
    }

    //set account username and pass
    @PostMapping("/addAcc")
    public userAccount setUserAccount(@RequestBody userAccount account) {
//        System.out.println("Email:"+account.getEmail());
//        System.out.println("username:"+account.getUsername());
//        System.out.println("pass:"+account.getPassword());
        return this.accountRepo.save(account);
    }

    @PutMapping("/updatePass/{username}")
    public RequestEntity<userAccount> setUserPass() {
        return null;
    }

    // get user by id
    @GetMapping("/users/{name}")
    public RequestEntity<userAccountDetails> getUserByName() {
        return null;
    }
}

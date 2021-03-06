package com.nibm.eadcw.loginandregis.controller;

import com.nibm.eadcw.loginandregis.model.*;
import com.nibm.eadcw.loginandregis.repository.userAccountDetailsRepo;
import com.nibm.eadcw.loginandregis.repository.userAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
        String passwordByUser = accountRepo.getPasswordByUsername(account.getUsername());
//        System.out.println("****************************************");
//        System.out.println("pass:"+account.getPassword());
//        System.out.println("passfromdb:"+ passwordByEmail);
            if (account.getPassword().toString().equals(passwordByUser)){
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

    //get tele no by user
    @PostMapping(path = "userTele/")
    public ResponseEntity<passModificationComfirmation> getTeleByuser(@RequestBody userAccount account){
        String userTele = accountDetailsRepo.getTelefromUsername(account.getUsername());
        if (!userTele.isEmpty()){
            passModificationComfirmation comfirmationOK = new passModificationComfirmation(userTele);
            return ResponseEntity.ok().body(comfirmationOK);
        }else {
            passModificationComfirmation confirmationDenied = new passModificationComfirmation("Denied");
            return ResponseEntity.ok().body(confirmationDenied);
        }
    }

    //set Account details
    @PostMapping("/addAccDetails")
    public userAccountDetails setUserAccountDetails(@RequestBody userAccountDetails accountDetails) {
//        System.out.println("Email:"+accountDetails.getEmail());
//        System.out.println("name:"+accountDetails.getUsername());
//        System.out.println("city:"+accountDetails.getUserCity());
//        System.out.println("tel:"+accountDetails.getTel_no());

        return this.accountDetailsRepo.save(accountDetails);
//        return null;
    }

    //set account username and pass
    @PostMapping("/addAcc")
    public userAccount setUserAccount(@RequestBody userAccount account) {
//        System.out.println("Email:"+account.getEmail());
//        System.out.println("username:"+account.getUsername());
//        System.out.println("pass:"+account.getPassword());
        return this.accountRepo.save(account);
//        return null;
    }

    @PutMapping("/updatePass/{username}")
    public ResponseEntity<passModified> setUserPass(@RequestParam("username") String user, @RequestBody userAccount account) {
//        System.out.println("Username"+ user);
//        System.out.println("pass"+ account.getPassword());
        accountRepo.updatePassword(user,account.getPassword());
        passModified modified = new passModified("Changed");
        return ResponseEntity.ok().body(modified);
    }

}

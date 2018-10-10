package com.eg.speedybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.speedybank.entity.SpeedyAccountType;
import com.eg.speedybank.repository.SpeedyAccountTypeRepository;
import com.eg.speedybank.request.dto.AccountTypeRequestDTO;
import com.eg.speedybank.response.dto.AccountTypeResponseDTO;

@RestController
@RequestMapping("/accounttype")
public class AccountTypeController {
    @Autowired
    SpeedyAccountTypeRepository accTypeRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<SpeedyAccountType> getAccountType() {
        return accTypeRepo.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AccountTypeResponseDTO createAccountType(@RequestBody AccountTypeRequestDTO reqDto) {
        AccountTypeResponseDTO resp = new AccountTypeResponseDTO();
        SpeedyAccountType accType = new SpeedyAccountType();

        String accountName = reqDto.getTypename().toUpperCase();
        resp.setAccounttype(accountName);
        if (accTypeRepo.findByTypeName(accountName) == null) {
            accType.setTypeName(accountName);
            accType.setInterestRate(reqDto.getInterestrate());
            accType.setMinimumDuration(reqDto.getMinimumduration());
            accType.setWithdrawalLimit(reqDto.getWithdrawallimit());
            accType.setMinimumBalance(reqDto.getMinimumbalance());
            accTypeRepo.save(accType);
            resp.setStatus("Success");
            resp.setMessage("Account Type Created");
        } else {
            resp.setStatus("Failed");
            resp.setMessage("Account Type Already Exists");
        }
        return resp;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public AccountTypeResponseDTO updateAccountType(@RequestBody AccountTypeRequestDTO reqDto) {
        AccountTypeResponseDTO resp = new AccountTypeResponseDTO();
        System.out.println(reqDto.getTypename());
        System.out.println(reqDto.getInterestrate());
        System.out.println(reqDto.getMinimumbalance());
        System.out.println(reqDto.getMinimumduration());
        System.out.println(reqDto.getWithdrawallimit());
        System.out.println(reqDto.getId());

        String accountName = reqDto.getTypename().toUpperCase();
        resp.setAccounttype(accountName);

        if (accTypeRepo.findById(reqDto.getId()) != null) {
            SpeedyAccountType accType = accTypeRepo.findById(reqDto.getId()).get();
            accType.setTypeName(accountName);
            accType.setInterestRate(reqDto.getInterestrate());
            accType.setMinimumDuration(reqDto.getMinimumduration());
            accType.setWithdrawalLimit(reqDto.getWithdrawallimit());
            accType.setMinimumBalance(reqDto.getMinimumbalance());
            accTypeRepo.save(accType);
            resp.setStatus("Success");
            resp.setMessage("Account Type Updated");
        } else {
            resp.setStatus("Failed");
            resp.setMessage("Account Type doesn't Exists");
        }
        return resp;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public AccountTypeResponseDTO deleteAccountType(@PathVariable("id") Long id) {
        AccountTypeResponseDTO resp = new AccountTypeResponseDTO();
        if (accTypeRepo.findById(id) != null) {
            SpeedyAccountType accountType = accTypeRepo.findById(id).get();
            resp.setAccounttype(accountType.getTypeName());
            accTypeRepo.delete(accountType);
            resp.setStatus("Success");
            resp.setMessage("Account Type Deleted");
        } else {
            resp.setAccounttype("");
            resp.setStatus("Failed");
            resp.setMessage("Account Type doesn't exist");
        }
        return resp;
    }
}

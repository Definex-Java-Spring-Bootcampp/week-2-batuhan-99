package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/credit-cards")
    public ResponseEntity<List<BankCreditCardDto>> getBanksCreditCards() {
        List<Bank> banks = bankService.getAllBanks();
        List<BankCreditCardDto> bankCreditCardDtos = BankCreditCardDto.fromBanks(banks);
        return new ResponseEntity<>(bankCreditCardDtos, HttpStatus.OK);
    }

    static class BankCreditCardDto {
        private String bankName;
        private List<CreditCard> creditCards;

        // Constructor, Getter, Setter

        public static List<BankCreditCardDto> fromBanks(List<Bank> banks) {
            // Convert banks to BankCreditCardDto list
        }
    }
}
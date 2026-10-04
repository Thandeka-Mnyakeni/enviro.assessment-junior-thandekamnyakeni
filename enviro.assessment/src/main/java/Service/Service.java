package com.enviro.assessment.junior.thandekamnyakeni.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@service
@RequiredArgsConstructor

public class service{
    private final InvestorRepository investorRepo;
    private final ProductRepository productRepo;
    private final WithdrawRepository withdrawRepo;

    public InvestorDTO getPortfolio(Long investorId){
        Investor investor = investorRepo.findById(investorId).orElseThrow (() -> BusinessException("Investor not found"));
        List <Product> products = productRepo.findByInvestorId(investorId);
        double total = products.stream().mapToDouble(Product::getBalance).sum();
        return new InvestorDTO(investor.getId(), investor,getName(), investor.getAge(), investor.getEmail, products, total);
    }

    public WithdrawNotice createWithdraw(WithdrawRequestDTO dto){
        Investor investor = investorRepo.findById(investorId).orElseThrow (() -> BusinessException("Investor not found"));
        List <Product> products = productRepo.findByInvestorId(dto.investorId());
        Product product = products.stream().filter(p -> p.getType().equalsIgnoreCase(dto.productType())).findFirst().orElseThrow (() -> BusinessException("Product type not found for investor"));
        
        if(dto.productType().equalsIgnoreCase("Retirement") && inv.getAge()<= 65){throw new BusinessException("Retirement withdrawals only allowed for age 65 and above. Your age: " + investor.getAge());
            }

            if(dto.amount() > product.getBalance()){throw new BusinessException("Withdrawal exceeds balance. Balance: R" + product.getBalance());
                }

            double maxAllowed = product.getBalance() * 0.9;
            if(dto.amount() > product.getBalance()){throw new BusinessException("Cannot withraw more than 90% of balance. Max allowed: R" + maxAllowed);
                }

            product.setBalance(product.getBalance() - dto.amount());
            productRepo.save(product);

            WithdrawNotice notice = new WithdrawNotice();

            notice.setInvestorId(dto.investorId());

            notice.setProductType(dto.productType().toUpperCase());
            notice.setAmount(dto.amount());

            notice.setDate(LocalDate.now());
            notice.getStatus("Approved");
        return withdrawRepo.save(notice);
    }

    public List<WithdrawNotice>getHistory(Long investorId){
         withdrawRepo.findByInvestorId(investorId);
    }

}


package com.enviro.assessment.junior.thandekamnyakeni.api;

import com.enviro.assessment.junior.thandekamnyakeni.entities.ShoppingListItem;
import com.enviro.assessment.junior.thandekamnyakeni.service.service;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/service")

public class rest {

    private final service service;

    @GetMapping("investors/{id}/portfolio")
    @Operation(description = "find by id")
    public InvestorDTO getPortfolio(@PathVariable Long id){
        return service.getPortfolio(id);
    }

    @GetMapping("/withrawals/{investorId}")
    @operation(description = "find by investorId")
    public List<WithdrawNotice> History(@PathVariable Long investorId){
        return service.getHistory(investorId);
    }

    @PostMapping("/withdrawals")
    @Operation(description = "find by dto")
    public ResponseEntity<WithdrawNotice> create (@Valid @RequstBody WithdrawRequestDTO dto){
        return ResponseEntity.ok(service.createWithdraw(dto));
    }

    @GetMapping("/withdrawals/export")
    public exportCSV(@RequestParam Long investorId, @RequestParam(required=false) String from, @RequestParam(required=false) String to, HTTPServletResponse response) throws IOException {
        response.setcontentType("text/csv");
        response.setheader("Content-Disposition", "attachment; filename=statement.csv");

        List<WithdrawNotice> list = service.getHistory(investorId);

        PrintWriter writer = response.getWriter();

        writer.println("Id, IvestorId, ProductType, Amount, Date, Status");
        for (WithdrawNotice w : list){
            writer.println(w.getId() + "," + w.getInvestorId() + "," + w.getPorductType()
        + "," + w.getAmount()+ "," + w.getDate()+ "," + w.getStatus());
        }
        writer.flush();
    }
}

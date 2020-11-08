package pl.fintech.metissociallending.metissociallendingservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.fintech.metissociallending.metissociallendingservice.api.dto.AuctionDTO;
import pl.fintech.metissociallending.metissociallendingservice.domain.borrower.Auction;
import pl.fintech.metissociallending.metissociallendingservice.domain.borrower.Borrower;
import pl.fintech.metissociallending.metissociallendingservice.domain.borrower.BorrowerService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@RequiredArgsConstructor
public class BorrowerController {

   private final BorrowerService borrowerService;

    @PostMapping("/new-user")
    public Borrower createBorrower(@RequestParam String name){
        return borrowerService.createBorrower(() -> name);
    }

    @PostMapping("/new-auction")
    public Auction createNewAuctionSinceNow(@RequestBody AuctionDTO auctionDTO){
        return borrowerService.createNewAuctionSinceNow(new BorrowerService.Command.CreateNewAuctionSinceNow() {
            @Override
            public BigDecimal getLoanAmount() {
                return BigDecimal.valueOf(auctionDTO.getLoanAmount());
            }

            @Override
            public Date getEndDate() {
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(auctionDTO.getEndDate());
                }catch (ParseException e){
                    System.out.println(e);
                }
                return date;
            }

            @Override
            public Date getBeginLoanDate() {
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(auctionDTO.getBeginLoanDate());
                }catch (ParseException e){
                    System.out.println(e);
                }
                return date;
            }

            @Override
            public Date getEndLoanDate() {
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(auctionDTO.getEndLoanDate());
                }catch (ParseException e){
                    System.out.println(e);
                }
                return date;
            }

            @Override
            public Double getInstallmentsFrequencyInYear() {
                return auctionDTO.getInstallmentsFrequencyInYears();
            }

            @Override
            public Long getBorrowerId() {
                return auctionDTO.getBorrowerId();
            }
        });
    }

    @GetMapping("/all-auctions")
    public List<Auction> getAllAuctions(@RequestParam Long borrower_id){ // change to return Auction DTO
        return borrowerService.getAllAuctions(()->borrower_id);
    }
}

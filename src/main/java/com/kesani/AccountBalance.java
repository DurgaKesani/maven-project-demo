package com.kesani;

import lombok.*;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AccountBalance {

    private Account account = new Account();
    private Amount ledgerBalance = new Amount();
    private Amount clearBalance = new Amount();
    private Amount availableBalance = new Amount();
    private Amount holdBalance = new Amount();
    private Amount earMarkBalance = new Amount();
    private Amount overDraftBalance = new Amount();
    private Amount effectiveAvailableBalance = new Amount();
    private Amount poolingNotionalBalance = new Amount();
    private AccountSummary accountSummary;

}

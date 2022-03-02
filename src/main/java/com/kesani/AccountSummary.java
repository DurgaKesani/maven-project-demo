package com.kesani;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountSummary implements Serializable {

    private static final long serialVersionUID = -3600749162957064143L;
    private String custId;
    private String acctName;
    private String bankCode;
    private String acctCrncy;
    private String acctStatus;
    private String balType;
    private String acctCtry;

}

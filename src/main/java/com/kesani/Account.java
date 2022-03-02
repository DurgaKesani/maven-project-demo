package com.kesani;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account implements Serializable{

    private static final long serialVersionUID = -64602541935635144L;
    String acctId;
    String acctCtry;

}

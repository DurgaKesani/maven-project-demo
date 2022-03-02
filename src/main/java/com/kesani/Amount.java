package com.kesani;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
public class Amount implements Serializable {

  private static final long serialVersionUID = -9087036419664402353L;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  BigDecimal asset;

  String denomination;

  public DenominationEnum.Denomination sign() {
    if (asset.compareTo(BigDecimal.ZERO) > 0) return DenominationEnum.Denomination.POSITIVE;
    else if (asset.compareTo(BigDecimal.ZERO) < 0) return DenominationEnum.Denomination.NEGATIVE;
    else return DenominationEnum.Denomination.ZERO;
  }

  public Amount substract(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();
    BigDecimal difference = this.getAsset().subtract(inputAmount.getAsset());
    return new Amount(difference, inputAmount.getDenomination());
  }

  public Amount add(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();
    BigDecimal added = this.getAsset().add(inputAmount.getAsset());
    return new Amount(added, inputAmount.getDenomination());
  }

  public void negate() {
    this.setAsset(this.getAsset().negate());
  }

  public Amount negateAndOutput() {
    return new Amount(this.getAsset().negate(), this.getDenomination());
  }

  protected Amount clone() {
    return new Amount(this.asset, this.denomination);
  }

  public void increase(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();

    this.setAsset(this.getAsset().add(inputAmount.getAsset()));
  }

  public void decrease(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();

    this.setAsset(this.getAsset().subtract(inputAmount.getAsset()));
  }

  public boolean isGreater(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();

    return this.getAsset().compareTo(inputAmount.getAsset()) > 0;
  }

  public boolean isLesser(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();

    return this.getAsset().compareTo(inputAmount.getAsset()) < 0;
  }

  public boolean isEqual(Amount inputAmount) {
    if (!this.getDenomination().equals(inputAmount.getDenomination())) throw new AssertionError();

    return this.getAsset().compareTo(inputAmount.getAsset()) == 0;
  }
}

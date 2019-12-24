package com.company.model.entity.royalty;

import com.company.model.entity.tax.Tax;

public class TaxRoyalty implements Tax {

  private final Royalty royalty;

  public TaxRoyalty(Royalty royalty) {
    this.royalty = royalty;
  }

  @Override
  public long calculate() {
    return this.royalty.cost() * ROYALTY_RATE;
  }

  @Override
  public String purposeOfPayment() {
    return String.format("Royalty cost = %d $ with description: %s.",
                         this.royalty.cost() / 100,
                         this.royalty.description()
    );
  }
}
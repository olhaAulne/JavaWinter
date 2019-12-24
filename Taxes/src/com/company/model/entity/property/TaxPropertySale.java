package com.company.model.entity.property;

import com.company.model.entity.tax.Tax;

import java.io.IOException;

public class TaxPropertySale implements Tax {

  private final Property property;

  public TaxPropertySale(Property property) {
    this.property = property;
  }


  @Override
  public long calculate() throws IOException {
    return this.property.cost() * PROPERTY_SALE_RATE;
  }

  @Override
  public String purposeOfPayment() throws IOException {
    return String.format("Property: '%s' with cost = %d $.",
                         this.property.name(),
                         this.property.cost() / 100
    );
  }
}
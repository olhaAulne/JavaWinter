package com.company.model.entity.tax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for collection of taxes
 */

public class IndividualTaxes implements Taxes {

  private final Collection<Tax> taxes = new HashSet<>();

  public IndividualTaxes with(Tax tax) {
    this.taxes.add(tax);
    return this;
  }

  @Override
  public long calculateAll() throws IOException {
    long sum = 0;
    for (Tax tax : this.taxes) {
      sum += tax.calculate();
    }
    return sum/100;

  }

  @Override
  public int count() {
    return this.taxes.size();
  }

  @Override
  public Collection<String> purposeOfPayments() throws IOException {
    Collection<String> purposes = new ArrayList<>();
    for (Tax tax : this.taxes) {
      purposes.add(tax.purposeOfPayment());
    }
    return purposes;
  }

  @Override
  public Collection<String> purposeOfPayments(Comparator<Tax> comparator) throws IOException {

    ArrayList<String> purposes = new ArrayList<>();

    List<Tax> list = this.taxes.stream().sorted(comparator)
        .collect(Collectors.toCollection(ArrayList::new));
    for (Tax tax : list) {
      purposes.add(tax.purposeOfPayment());
    }
    return purposes;

  }

}

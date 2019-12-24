package com.company.model.entity.job;

import com.company.model.entity.tax.Tax;

/**
 * Class for job tax
 */

public class TaxJob implements Tax {

  private final Job job;

  public TaxJob(Job job) {
    this.job = job;
  }

  @Override
  public long calculate() {
    return this.job.salary() * TAX_RATE/100;
  }

  @Override
  public String purposeOfPayment() {
    return String.format("For work in position '%s' by salary = %d $.",
                         this.job.position(),
                         this.job.salary() / 100);
  }
}
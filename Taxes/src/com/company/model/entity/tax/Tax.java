package com.company.model.entity.tax;

import java.io.IOException;

/**
 * Interface for tax
 */

public interface Tax {
  //variable for tax rate
  long TAX_RATE = 17;
  long ROYALTY_RATE = 5;
  long PROPERTY_SALE_RATE = 2;

  /**
   * Method for calculating tax
   * @return tax amount
   * @throws IOException
   */
  long calculate() throws IOException;

  String purposeOfPayment() throws IOException;
}

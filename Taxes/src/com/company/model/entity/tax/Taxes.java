package com.company.model.entity.tax;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;

/**
 * Interface for collection of taxes
 */

public interface Taxes {

  long calculateAll() throws IOException;

  int count() throws IOException;

  Collection<String> purposeOfPayments() throws IOException;

  Collection<String> purposeOfPayments(Comparator<Tax> comparator) throws IOException;

  final class ByCost implements Comparator<Tax> {

    @Override
    public int compare(Tax o1, Tax o2) {
      try {
        final long diff = o1.calculate() - o2.calculate();
        return diff < 0 ? -1 : diff > 0 ? 1 : 0;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return 0;
    }
  }

  final class ByPurpose implements Comparator<Tax> {

    @Override
    public int compare(Tax o1, Tax o2) {
      try {
        return o1.purposeOfPayment().compareTo(o2.purposeOfPayment());
      } catch (IOException e) {
        e.printStackTrace();
      }
      return 0;
    }
  }

}

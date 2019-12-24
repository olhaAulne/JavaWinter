package com.company.model.entity.job;

/**
 * Class for standard job
 */

public class StandardJob implements Job {

  private final long salary;
  private final String position;

  public StandardJob(long salary, String position) {
    this.salary = salary;
    this.position = position;
  }

  @Override
  public long salary() {
    return this.salary;
  }

  @Override
  public String position() {
    return this.position;
  }
}
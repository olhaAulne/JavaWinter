package com.company.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class for working with text encoding
 */

public class ConsoleText implements Text {

  private final InputStream inputStream;
  private final Encoding encoding;


  public ConsoleText() {
    this(System.in, Encoding.UTF8);
  }

  public ConsoleText(Encoding encoding) {
    this(System.in, encoding);
  }

  public ConsoleText(InputStream inputStream) {
    this(inputStream, Encoding.UTF8);
  }

  public ConsoleText(InputStream inputStream, Encoding encoding) {
    this.inputStream = inputStream;
    this.encoding = encoding;
  }

  @Override
  public String context() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
    return bufferedReader.readLine();
  }
}


package in.rcard.hexagonal.portfolio.domain;

import lombok.Value;

@Value
public class Stock {
  String name;
  long owned;
  
  public Stock add(String name, Long owned) {
    return new Stock(name, this.owned + owned);
  }
}

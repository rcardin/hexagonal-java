package in.rcard.hexagonal.portfolio.domain;

import lombok.Value;

@Value
public class Stock {
  String name;
  long owned;
  
  public Stock add(Long owned) {
    return new Stock(name, this.owned + owned);
  }
}

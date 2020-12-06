package in.rcard.hexagonal.stock.price.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StockPrice {
  private final String name;
  private final double price;
}

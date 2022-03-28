package in.rcard.hexagonal.portfolio.domain;

import java.util.HashMap;
import java.util.Map;
import lombok.Value;

@Value
public class Portfolio {
  String name;
  Map<String, Stock> stocks;
  
  public Portfolio buy(String name, Long quantity) {
    final Stock boughtStock = stocks.getOrDefault(name, new Stock(name, quantity));
    final Map<String, Stock> newStocks = new HashMap<>(stocks);
    newStocks.put(name, boughtStock);
    return new Portfolio(name, newStocks);
  }
}

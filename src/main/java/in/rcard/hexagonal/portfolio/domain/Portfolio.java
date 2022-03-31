package in.rcard.hexagonal.portfolio.domain;

import java.util.HashMap;
import java.util.Map;
import lombok.Value;

@Value
public class Portfolio {
  String name;
  Map<String, Stock> stocks;

  /**
   * Creates an empty portfolio with a given {@code name}.
   */
  public static Portfolio emptyPortfolio(String name) {
    return new Portfolio(name, Map.of());
  }
  
  public Portfolio buy(String name, Long quantity) {
    final Stock boughtStock = getUpdatedStock(name, quantity);
    final Map<String, Stock> newStocks = new HashMap<>(stocks);
    newStocks.put(name, boughtStock);
    return new Portfolio(this.name, newStocks);
  }
  
  private Stock getUpdatedStock(String name, Long quantity) {
    if (stocks.containsKey(name)) {
      final Stock stock = stocks.get(name);
      return stock.add(quantity);
    } else {
      return new Stock(name, quantity);
    }
  }
}

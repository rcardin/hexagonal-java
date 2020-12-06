package in.rcard.hexagonal.stock.price.application.port.in;

import in.rcard.hexagonal.stock.price.domain.StockPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Input port to update the price of a stock.
 */
public interface StockPriceUpdateUseCase {
  boolean updatePrice(StockPriceUpdateCommand command);
  
  /**
   * Updates the price of a given stock and returns {@code true} if the operation succeed. If no
   * stock with the given name exists, it inserts the required information. Returns {@code false}
   * if the process goes wrong.
   */
  @AllArgsConstructor
  @Getter
  class StockPriceUpdateCommand {
    private final String stock;
    private final double price;
    
    public StockPrice toPrice() {
      return new StockPrice(stock, price);
    }
  }
}

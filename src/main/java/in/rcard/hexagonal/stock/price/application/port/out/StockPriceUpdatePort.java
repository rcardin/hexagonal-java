package in.rcard.hexagonal.stock.price.application.port.out;

import in.rcard.hexagonal.stock.price.domain.StockPrice;

public interface StockPriceUpdatePort {
  boolean updatePrice(StockPrice stockPrice);
}

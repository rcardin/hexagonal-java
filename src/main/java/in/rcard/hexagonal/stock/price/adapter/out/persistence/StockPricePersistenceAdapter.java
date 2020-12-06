package in.rcard.hexagonal.stock.price.adapter.out.persistence;

import in.rcard.hexagonal.stock.price.application.port.out.StockPriceUpdatePort;
import in.rcard.hexagonal.stock.price.domain.StockPrice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class StockPricePersistenceAdapter implements StockPriceUpdatePort {
  private final StockPriceRepository repository;
  
  @Override
  public boolean updatePrice(StockPrice stockPrice) {
    try {
      repository.save(MongoStockPrice.valueOf(stockPrice));
    } catch (Exception ex) {
      log.error("Error during the persistence of the stock price {}", stockPrice);
      return false;
    }
    return true;
  }
}

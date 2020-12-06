package in.rcard.hexagonal.stock.price.application;

import in.rcard.hexagonal.stock.price.application.port.in.StockPriceUpdateUseCase;
import in.rcard.hexagonal.stock.price.application.port.out.StockPriceUpdatePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockPriceUpdateService implements StockPriceUpdateUseCase {
  private final StockPriceUpdatePort port;
  
  @Override
  public boolean updatePrice(StockPriceUpdateCommand command) {
    return port.updatePrice(command.toPrice());
  }
}

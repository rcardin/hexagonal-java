package in.rcard.hexagonal.stock.price;

import in.rcard.hexagonal.stock.price.application.StockPriceUpdateService;
import in.rcard.hexagonal.stock.price.application.port.in.StockPriceUpdateUseCase;
import in.rcard.hexagonal.stock.price.application.port.out.StockPriceUpdatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class StockPriceUpdateConfiguration {
  @Bean
  public StockPriceUpdateUseCase stockPriceUpdateUseCase(StockPriceUpdatePort port) {
    return new StockPriceUpdateService(port);
  }
}

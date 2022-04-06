package in.rcard.hexagonal.portfolio.adapter.out.persistence;

import in.rcard.hexagonal.portfolio.domain.Portfolio;
import java.util.HashMap;
import java.util.Map;
import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
class MongoPortfolio {

  @Id @With String name;
  Map<String, Long> stocks;

  static MongoPortfolio makeFrom(Portfolio portfolio) {
    final Map<String, Long> stocksMap = new HashMap<>();
    portfolio
        .getStocks()
        .values()
        .forEach(stock -> stocksMap.put(stock.getName(), stock.getOwned()));
    return new MongoPortfolio(portfolio.getName(), stocksMap);
  }
}

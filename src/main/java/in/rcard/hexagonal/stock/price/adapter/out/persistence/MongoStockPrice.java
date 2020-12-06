package in.rcard.hexagonal.stock.price.adapter.out.persistence;

import in.rcard.hexagonal.stock.price.domain.StockPrice;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persisted BSON is something like the following:
 * <pre>
 *     {
 *       "_id:" "AAPL",
 *       "price": 1234.56
 *     }
 * </pre>
 */
@AllArgsConstructor
@Document(collection = "stock-price")
public class MongoStockPrice {
  @Id
  private final String name;
  private final double price;
  
  public static MongoStockPrice valueOf(StockPrice stockPrice) {
    return new MongoStockPrice(stockPrice.getName(), stockPrice.getPrice());
  }
}

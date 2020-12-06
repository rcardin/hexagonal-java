package in.rcard.hexagonal.stock.price.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface StockPriceRepository extends CrudRepository<MongoStockPrice, String> {
}

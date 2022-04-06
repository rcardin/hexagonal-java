package in.rcard.hexagonal.portfolio.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PortfolioRepository extends CrudRepository<MongoPortfolio, Long> {

}

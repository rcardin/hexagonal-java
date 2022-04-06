package in.rcard.hexagonal.portfolio.adapter.out.persistence;

import in.rcard.hexagonal.portfolio.application.port.out.PortfolioCreationPort;
import in.rcard.hexagonal.portfolio.application.port.out.PortfolioFindByNamePort;
import in.rcard.hexagonal.portfolio.domain.Portfolio;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class PortfolioPersistenceAdapter implements PortfolioCreationPort, PortfolioFindByNamePort {
  
  private final PortfolioRepository repository;
  
  @Override
  public Boolean createPortfolio(Portfolio portfolio) {
    repository.save(MongoPortfolio.makeFrom(portfolio));
    return null;
  }
  
  @Override
  public Optional<Portfolio> findByName(String name) {
    return Optional.empty();
  }
}

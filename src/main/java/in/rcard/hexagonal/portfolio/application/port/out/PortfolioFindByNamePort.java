package in.rcard.hexagonal.portfolio.application.port.out;

import in.rcard.hexagonal.portfolio.domain.Portfolio;
import java.util.Optional;

public interface PortfolioFindByNamePort {
  
  Optional<Portfolio> findByName(String name);
}

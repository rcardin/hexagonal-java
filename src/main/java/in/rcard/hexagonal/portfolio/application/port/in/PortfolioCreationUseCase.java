package in.rcard.hexagonal.portfolio.application.port.in;

import in.rcard.hexagonal.portfolio.domain.Portfolio;
import lombok.Value;

/**
 * Input port to create a new empty portfolio.
 */
public interface PortfolioCreationUseCase {
  // FIXME Do we like to return a simple boolean???
  Boolean createPortfolio(PortfolioCreationCommand cmd);
  
  /**
   * Creates a new Portfolio having the given name.
   */
  @Value
  class PortfolioCreationCommand {
    String name;
    
    public Portfolio toPortfolio() {
      return Portfolio.emptyPortfolio(name);
    }
  }
}

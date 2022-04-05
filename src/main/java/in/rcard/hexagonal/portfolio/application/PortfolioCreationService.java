package in.rcard.hexagonal.portfolio.application;

import in.rcard.hexagonal.portfolio.application.port.in.PortfolioCreationUseCase;
import in.rcard.hexagonal.portfolio.application.port.out.PortfolioCreationPort;
import in.rcard.hexagonal.portfolio.application.port.out.PortfolioFindByNamePort;
import in.rcard.hexagonal.portfolio.domain.Portfolio;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PortfolioCreationService implements PortfolioCreationUseCase {

  private final PortfolioCreationPort portfolioCreationPort;
  private final PortfolioFindByNamePort portfolioFindByNamePort;
  
  /**
   * @throws IllegalArgumentException if portfolio with given name already exists
   */
  @Override
  public Boolean createPortfolio(PortfolioCreationCommand cmd) {
    verifyPortfolioExistence(cmd);
    return portfolioCreationPort.createPortfolio(
        cmd.toPortfolio()
    );
  }
  
  private void verifyPortfolioExistence(PortfolioCreationCommand cmd) {
    final Optional<Portfolio> maybePortfolio = portfolioFindByNamePort.findByName(cmd.getName());
    if (maybePortfolio.isPresent()) {
      throw new IllegalArgumentException(
          "Portfolio with name '" + cmd.getName() + "' already exists");
    }
  }
}

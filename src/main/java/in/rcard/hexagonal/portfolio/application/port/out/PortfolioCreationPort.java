package in.rcard.hexagonal.portfolio.application.port.out;

import in.rcard.hexagonal.portfolio.domain.Portfolio;

public interface PortfolioCreationPort {
  Boolean createPortfolio(Portfolio portfolio);
}

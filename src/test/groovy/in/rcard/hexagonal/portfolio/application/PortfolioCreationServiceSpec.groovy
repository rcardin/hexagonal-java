package in.rcard.hexagonal.portfolio.application

import in.rcard.hexagonal.portfolio.application.port.in.PortfolioCreationUseCase
import in.rcard.hexagonal.portfolio.application.port.out.PortfolioCreationPort
import in.rcard.hexagonal.portfolio.application.port.out.PortfolioFindByNamePort
import in.rcard.hexagonal.portfolio.domain.Portfolio
import spock.lang.Specification

class PortfolioCreationServiceSpec extends Specification {
    def "createPortfolio should thrown an IllegalArgumentException if the name in not unique"() {
        given:
        Portfolio portfolio = Portfolio.emptyPortfolio("portfolio")
        PortfolioCreationPort portfolioCreationPort = Mock()
        PortfolioFindByNamePort portfolioFindByNamePort = Stub()
        portfolioFindByNamePort.findByName("portfolio") >> Optional.of(portfolio)

        PortfolioCreationService service =
                new PortfolioCreationService(portfolioCreationPort, portfolioFindByNamePort)

        when:
        service.createPortfolio(
                new PortfolioCreationUseCase.PortfolioCreationCommand("portfolio")
        )

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Portfolio with name 'portfolio' already exists"
        0 * portfolioCreationPort.createPortfolio(_)
    }
}

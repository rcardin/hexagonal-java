package in.rcard.hexagonal.portfolio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Stock {
  private final String name;
  private final long owned;
}

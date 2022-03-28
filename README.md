![](https://github.com/rcardin/hexagonal-java/workflows/Hexagonal-Java/badge.svg)

# Hexagonal Architecture

This toy project shows how to implement a service using Spring Boot, and the Hexagonal Architecture. The
represented domain model is the management of a **stocks' portfolio**. The reference implementation is the project [hexagonal](https://github.com/rcardin/hexagonal).

(STILL UNDER DEVELOPMENT)

## User Stories

The implemented user stories are the following:
- The system should receive the price of a stock via Kafka message
- The system should produce an event if the value of an owned stock falls down below a threshold
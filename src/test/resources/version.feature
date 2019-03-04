Feature: можно получить версию
  Scenario: клиент делает запрос на GET /version
    When клиент делает запрос на GET /version
    Then response code 200
    And клиент получает версию 3.0
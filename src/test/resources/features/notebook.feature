Feature: notebook

  Scenario: Consulta notebook
    Given que eu acesso o site do mercado livre
    When  pesquiso por "Notebook"
    And   clico na lupa
    Then  retorna lista para "Notebook" como resultado
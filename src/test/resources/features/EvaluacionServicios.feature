Feature: Pruebas Automatizadas de Servicios

  Background: : Evaluacion de Servicios
    Given York hace la consulta al servicio de Octoperf

  @ServicioCorrecto
  Scenario: Evaluacion de Servicios - Escenario Correcto
    And York accede con su password correcta "Globant123" y username "testautomationglobant@gmail.com"
    Then verificaremos que sea un login correcto obteniendo un token

  @ServicioIncorrecto
  Scenario: Evaluacion de Servicios - Escenario Incorrecto
    And York accede con una password incorrecta "Globant1232" y username "testautomationglobant@gmail.com"
    Then verificaremos que sea un login incorrecto
@Web
Feature: Pruebas Automatizadas Web

  Scenario: Evaluacion Web
    Given ingresamos a la pagina web de Google
    When accedemos al menu de Google Apps
    And abrimos Google Drive e ingresamos nuestra cuenta de Google
    And ingreso mi correo electronico
    And ingreso mi password
    And accedemos a Google Drive y creamos un nuevo documento en blanco
    And ingresamos el nombre del documento y guardamos
    Then regresamos a la pantalla principal para verificar que el archivo haya sido creado correctamente
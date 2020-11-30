## Proyecto Automatización Web y Servicios realizado en Maven
Se requiere tener instalado y configurado
* Java 8
* Maven
* Versión de Chrome 87.0.4280.66

### Información General
***
El proyecto en general ha sido realizado con el framework de Serenity BDD.

Para el proyecto de automatización web se uso el patrón de diseño
Page Object Model junto con Cucumber con escenarios redactados
en lenguaje Gherkin.
La estrategia para la identificación de elementos fue inspeccionar cada
elemento dentro de la pagina web, los elementos fueron localizados
por id, xpath, linkText y name.

Para el proyecto de automatización de servicios se uso el patrón de 
diseño Screenplay junto con Cucumber con escenarios redactados en
lenguaje Gherkin y la libreria Serenity Rest.

### Instrucciones de Ejecución de Pruebas Automatizadas Web y Servicios
***
Para realizar la ejecución de los features, se deberá identificar los **@Tags** de los **Features** y ejecutar el siguiente comando:
***
Para el escenario web 
```
mvn clean verify "-Dcucumber.filter.tags=@Web"
```
Para el escenario de servicios caso exitoso
```
mvn clean verify "-Dcucumber.filter.tags=@ServicioCorrecto"
```
Para el escenario de servicios caso error
```
mvn clean verify "-Dcucumber.filter.tags=@ServicioIncorrecto"
```
En caso se deseen ejecutar todos los escenarios al mismo tiempo
```
mvn clean verify
```
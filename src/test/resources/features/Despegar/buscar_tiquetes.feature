Feature: Buscar los 7 precios más baratos de tiquetes de la página despegar.com.co

  Scenario Outline: Búsqueda de tiquetes exitosa
    Given El usuario se encuentra en la <pagina>
    When El usuario selecciona <origen>, <destino>, <viajeros>, <fecha_inicio>, <fecha_fin> y da clic en buscar
    Then el usuario ve la lista de vuelos disponibles
    And se genera un archivo Excel con los 7 vuelos mas baratos y se marca en verde el precio mas economico

Examples: 
|pagina||origen||destino||viajeros||fecha_inicio||fecha_fin|
|https://www.despegar.com.co/||Medellín||Cartagena||2||01/09/2018||29/09/2018|



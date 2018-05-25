Feature: Buscar los 7 precios más baratos de tiquetes de la página despegar.com.co

  Scenario Outline: Búsqueda de tiquetes exitosa
    Given El usuario se encuentra en la <pagina>
    When El usuario selecciona <origen>, <destino>, <viajeros>, <anio_mes_inicio>, <dia_inicio>, <anio_mes_fin>, <dia_fin> y da clic en buscar
    Then el usuario ve la lista de vuelos disponibles
    And se almacena en un archivo de Excel los siete vuelos mas baratos y se marca en verde el precio más económico

Examples: 
|pagina|origen|destino|viajeros|anio_mes_inicio|dia_inicio|anio_mes_fin|dia_fin|
|https://www.despegar.com.co/|Medellín|Cartagena|2|2018-06|1|2018-06|30|

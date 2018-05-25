#Reto 2:  
##Consulta de vuelos en [Despegar](www.despegar.com.co)

Para el ejercicio se utilizó el plugin de Maven para Eclipse Version 2.19.1
El arquetipo inicial utilizado para el proyecto fue el de cucumber-serenity

##Versiones de los componentes utilizados
- maven plugin version 2.19.1
- serenity.version 1.9.7
- serenity.cucumber.version 1.9.4
- serenity-bdd
- cucumber.version 1.9.4
- junit version 4.12
- poi version 3.17

##Resumen de codificación y estrategia:

Se utilizó el modelo Page Object, haciendo uso de dos páginas:
- Página inicial despegar.com.co
- Página con el resultado de la búsqueda

Para dar claridad a la descripción de las pruebas, se escribió la historia de usuario con un escenario en leguaje Gherkin

Se definieron valores de la variables en cada corrida, incluyendo el caso positivo y el negativo. Las variables utilizadas fueron:
- pagina: Dirección de la página de despegar
- origen: Ciudad origen del vuelo
- destino: Ciudad destino del vuelo
- viajeros: cantidad de adultos a viajar
- anio_mes_inicio: Año y mes para el inicio del viaje (aaaa-mm)
- dia_inicio: Día para el inicio del viaje (a ó aa)
- anio_mes_fin: Año y mes para el fin del viaje (aaaa-mm)
- dia_fin: Día para el fin del viaje (a ó aa)

El navegador utilizado fue Chrome version 66.0.3359.181  

##Conclusiones de la automatización:  
Fue un reto de mucho aprendizaje donde se puede visualizar de manera concreta la utilidad de la automatización mediante Selenium, Gherkin, Cucumber y Serenity BDD, con las ventajas de poder agregar facilmente datos para corridas de casos positivos y negativos si se tiene en cuenta la inclusión de los parámetros correspondientes.


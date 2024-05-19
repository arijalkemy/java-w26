# Tipos de bases de datos a elegir

![Arbol de decisión](Como%20decidir%20que%20tipo%20de%20BD%20usar.drawio.png)


## Ejercicio 1

Si tengo que almacenar archivos binarios (recibos) para mi sistema de procesamiento de Billing...

¿Qué tipo de base de datos debo utilizar? ¿Por qué?

**Solución**

Observando el árbol de decisión ofrecido en LH, se podría decir que la mejor opción es ***Object Storage***, la cual es una estructura de "directorios" en la nube donde se guardan archivos que se recuperan con un Pathh. Se  necesita otra BD que administre lo Paths.

## Ejercicio 2

Si tengo que guardar todos los datos de los usuarios de MELI

¿Qué tipo de base de datos debo utilizar? ¿Por qué?  

**Solución**

Siguiendo el árbol de decisión lo primero es analizar si son datos binarios, lo cual no sucede, posteriormente la pregunta es si ¿necesito estos datos con frecuencia? y la respuesta es si por lo cual paso a la pregunta ¿necesito escalar horizontalmente las estructuras" y considero que si puestos que los usuarios hacen parte del core y el aumento de los mismos subió en un 5000%, además´de que constantemente requiero datos de ellos para logueos, para asociar a compras y para creación de los mismos. Posteriormente debo saber si la única forma de acceder a ellos es por la clave y pienso que no necesariamente, pero con base en lo leído y expuesto por Pablo, es una especie de sacrificio que se hace con el afán de mejorar la latencia, luego se sabe que no es un archivo tan pesado por lo cual solo queda saber si necesitamos o no consistencia a lo cual considero que si por lo cuala la respuesta final sería **BD de Key-Value** 

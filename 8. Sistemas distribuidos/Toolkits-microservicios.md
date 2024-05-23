# Meli-toolkits & Microservicios

## Ejercicio 1

Tenemos que construir un nuevo endpoint en nuestra API que participará en un flujo crítico para pagos con la app de MercadoPago vía QR en locales, informando al microservicio encargado de cobrar, el porcentaje de descuento que debe aplicar al monto total.

Dado que participamos de un flujo crítico, la app que nos llama nos pide que podamos responderles en menos de 500 ms, incluídos sus reintentos, y podamos mantener un Error Rate < 0.5 % para no afectar a la experiencia del comprador en el comercio.

Para resolver esto, debemos consultar a una api llamada discounts-api que nos informa todos los descuentos que aplican al cliente que está pagando, y entregar el más conveniente para él.

Dicha api tiene el siguiente SLA de respuesta

- Response Time
    - Average: 40 ms
    - P95:  150 ms
    - P99: 300 ms
    - MAX: 400 ms
- Error Rate: 0.9 %

Arma una propuesta para los valores de configuración del restclient y fundamenta el por qué cada valor:

- Timeout
- Retries
    - Cantidad
    - Strategy

Aclaraciones importantes:

- Se puede asumir que no hay requests más “pesados” que otros

### Propuesta ejercicio 1 

- **Timeout:**

    - **Valor propuesto:** 300 ms
    - **Justificación:** El valor del tiempo de espera debe ser lo suficientemente alto como para permitir que la solicitud se complete dentro del SLA de la API de descuentos, incluso considerando el peor caso (P99: 300 ms). Establecer el tiempo de espera en 300 ms permite una margen adicional para el procesamiento interno y la transmisión de datos. Esto garantiza que podamos manejar las respuestas dentro del tiempo límite de 500 ms para nuestro endpoint.

- **Retries:**

    - **Valor propuesto:** 2 intentos adicionales
    - **Justificación:** Con un tiempo de respuesta esperado promedio de 40 ms y un P95 de 150 ms, es poco probable que los errores sean causados por problemas persistentes en la API de descuentos. Sin embargo, dado el requisito de un tiempo de respuesta total de menos de 500 ms, permitir un único reintento podría ayudar a mitigar errores ocasionales o transitorios. Tener dos intentos adicionales cubriría la mayoría de los casos donde se produzcan errores ocasionales o retrasos en la red.

- **Cantidad:**

    - **Valor propuesto:** 1 solicitud simultánea
    - **Justificación:** Dado que estamos diseñando este cliente para un flujo crítico, y considerando que las solicitudes no son pesadas, no hay necesidad de realizar múltiples solicitudes simultáneas a la API de descuentos. Una única solicitud a la vez simplifica el manejo de la concurrencia y minimiza el riesgo de congestión en la red o sobrecarga en la API.

- **Strategy:**

    - **Valor propuesto:** Retry-After-Backoff Strategy
    - **Justificación:** Esta estrategia implica esperar un breve período antes de volver a intentar una solicitud fallida, y aumentar gradualmente el tiempo de espera entre reintentos. Esta estrategia es efectiva para manejar errores transitorios sin sobrecargar la API con solicitudes repetidas. Al aumentar gradualmente el tiempo de espera, permitimos que la API se recupere si está experimentando una sobrecarga temporal, y evitamos saturarla aún más con reintentos agresivos. Esto ayuda a mantener la tasa de error por debajo del 0.5% y garantiza que no sobrecarguemos la API de descuentos con reintentos excesivos.

## Ejercicio 2 

Suponiendo que nuestro microservicio consume a otro que cuando entre los status code que nos puede devolver se encuentra el 429, ante el que reintentamos 2 veces(máximo 3 requests, el original más 2 reintentos), y finalmente devolvemos 500, porque sin ese valor no podemos proseguir.  

Cada vez que el servicio que consumimos devuelve 429 por más de un minuto, nos alertamos porque el tiempo promedio de respuesta sube tendiendo al infinito (60 segundos!) y el error rate sube al 100%.  El problema que tenemos es que al reestablecerse el servicio que consumimos, el nuestro no lo hace, manteniendo tiempos altos. hasta que realizamos un black out (cortamos el tráfico entrante y reemplazamos todas las instancias).

Infiera el por qué ocurre esto, y plantee un cambio en la política de reintentos y status code que devuelve nuestro microservicio.

### Propuesta ejercicio 2

El problema principal aquí es que el microservicio no está manejando adecuadamente la situación cuando el servicio que consume devuelve repetidamente un código de estado 429 (Demasiadas solicitudes). Esto puede provocar una acumulación de solicitudes en el microservicio, lo que eventualmente lleva a un aumento en los tiempos de respuesta y un error rate del 100%.

El motivo de que el microservicio no se recupere incluso después de que el servicio consumido se haya restablecido es probablemente porque el microservicio está tratando cada solicitud de manera independiente y no está limitando la cantidad total de solicitudes que pueden realizarse simultáneamente o en un período de tiempo específico.

- **Política de reintentos:**

    - **Limitar la cantidad de reintentos:** En lugar de permitir un máximo de 3 intentos (el original más 2 reintentos), podemos reducir esto a un máximo de 2 intentos (el original más 1 reintento). Esto evitará que se realicen demasiados intentos de solicitud cuando el servicio consumido está experimentando problemas temporales.
    - **Incremento gradual del tiempo de espera entre reintentos:** En lugar de reintentar inmediatamente después de un código de estado 429, podemos implementar un incremento gradual del tiempo de espera entre reintentos. Por ejemplo, podemos comenzar con un breve tiempo de espera (por ejemplo, 1 segundo) y luego aumentar gradualmente este tiempo de espera con cada reintento.

- **Código de estado devuelto por nuestro microservicio:**

    - En lugar de devolver un código de estado 500 cuando no podemos continuar sin el valor necesario, podríamos considerar devolver un código de estado 503 (Servicio no disponible temporalmente). Esto indica que el servicio no puede manejar la solicitud en ese momento, pero puede estar disponible en el futuro.

- **Control de flujo y límites de solicitudes:**

    - **Implementar control de flujo:** Podemos implementar un mecanismo de control de flujo para limitar la cantidad total de solicitudes que pueden procesarse simultáneamente o en un período de tiempo específico. Esto ayudará a prevenir la acumulación de solicitudes cuando el servicio consumido está experimentando problemas.
    - **Establecer límites de solicitudes:** Podemos establecer límites en la cantidad máxima de solicitudes que pueden realizarse en un período de tiempo específico, lo que ayuda a prevenir la sobrecarga del sistema y garantiza una operación más estable.

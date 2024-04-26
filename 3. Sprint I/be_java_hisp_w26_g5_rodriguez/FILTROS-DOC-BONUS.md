US 0013: Obtener una lista completa de productos segun los filtros que se apliquen.

Parámetros de Solicitud:

1) name (opcional): Un String que representa el nombre del producto. Si se proporciona, el servicio filtrará los productos
que coincidan con este nombre.

2) type (opcional): Un String que representa el tipo de producto. Si se proporciona, el servicio filtrará los productos que
coincidan con este tipo.

3) brand (opcional): Un String que representa la marca del producto. Si se proporciona, el servicio filtrará los productos
que coincidan con esta marca.

4) color (opcional): Un String que representa el color del producto. Si se proporciona, el servicio filtrará los productos
que coincidan con este color.

5) has_promo (opcional, valor predeterminado = false): Un boolean que indica si se deben filtrar los productos que tienen
una promoción. Si se proporciona y es true, el servicio filtrará los productos que tienen una promoción.

6) min_price (opcional): Un Double que representa el precio mínimo del producto. Si se proporciona, el servicio filtrará
los productos que tienen un precio mayor o igual a este valor.

7) max_price (opcional): Un Double que representa el precio máximo del producto. Si se proporciona, el servicio filtrará
los productos que tienen un precio menor o igual a este valor.

Respuesta:
El servicio responde con un objeto FilterProductsResponse que contiene:
1) Lista de productos encontrados. Cada producto debera tener: 
   1.a) id: Long.

   1.b) nombre: String.

   1.c) precio: Double.

   1.d) si tiene promo : boolean.

   1.e) descuento: Double.

2) Este objeto tambien incluye un objeto de respuesta que contiene los filtros marca, tipo y promo.

   2.a) Marca y Tipo son objetos que tienen su respectivo nombre y cantidad de elementos encontrados.

   2.b) Promo es un dato priminivo long que representa la cantidad de productos con promo encontrados.

Ejemplo de solicitud:

  GET localhost:8080/product/list?name=mouse

  GET localhost:8080/product/list?type=Gamer

  GET localhost:8080/product/list?type=Gamer&brand=Racer

  GET localhost:8080/product/list?type=Gamer&brand=Racer&has_promo=true



### Ejercicio 1: Calculadora de Calorías
Un restaurante desea poder ofrecer a sus potenciales comensales la posibilidad de conocer los ingredientes y calorías de cada uno de los platos que se encuentran en su menú. Para esto, necesita el desarrollo de una API que a partir de la recepción de un plato del menú (brindando nombre y peso en gramos) sea capaz de retornar:


    a) Cantidad total de calorías del plato
    b) Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    c) El ingrediente con mayor cantidad de calorías

**Bonus**: Por otra parte, el dueño del restaurante está interesado en la posibilidad de que sus clientes, además de enviar plato por plato, puedan enviar una lista de platos y obtener estos mismos puntos diferenciados por cada uno de los platos brindados.


Para facilitar toda esta tarea, el dueño facilitó el archivo [food.json](https://learning.mercadolibre.com/assets/courseware/v1/bde58a3d54ebdb6897996ccc99e772be/asset-v1:it_prod+spring_esp+v1_2024+type@asset+block/1._c._food.zip) como base de datos a ser utilizada.


para testear los endpoints se pueden usar estos curl en postman o en la terminal:
```bash
curl --location 'http://localhost:8080/calculate' \
--header 'Content-Type: application/json' \
--data '  {
"name": "Ensalada Mediterránea",
"weight": 200,
"ingredients": [
"Aceitunas negras",
"Aceitunas verdes",
"Tomates",
"Pimiento",
"Cebolla",
"Pepino",
"Lechuga",
"Aceite de oliva",
"Vinagre",
"Sal"
]
}
'
```

```bash
curl --location 'http://localhost:8080/calculate_dishes' \
--header 'Content-Type: application/json' \
--data '[
  {
    "name": "Ensalada Mediterránea",
    "weight": 390,
    "ingredients": [
      "Aceitunas negras",
      "Aceitunas verdes",
      "Tomates",
      "Pimiento",
      "Cebolla",
      "Pepino",
      "Lechuga",
      "Aceite de oliva",
      "Vinagre",
      "Sal"
    ]
  },
  {
    "name": "Risotto de Champiñones",
    "weight": 390,
    "ingredients": [
      "Arroz",
      "Champiñón y otras setas",
      "Cebolla",
      "Caldo de verduras",
      "Vino blanco",
      "Aceite de oliva",
      "Queso parmesano",
      "Sal",
      "Pimienta"
    ]
  },
  {
    "name": "Pasta Primavera",
    "weight": 390,
    "ingredients": [
      "Pasta",
      "Brócoli",
      "Zanahoria",
      "Pimiento",
      "Calabacín",
      "Tomates",
      "Ajo",
      "Aceite de oliva",
      "Albahaca fresca",
      "Sal",
      "Pimienta"
    ]
  },
  {
    "name": "Guiso de Lentejas",
    "weight": 390,
    "ingredients": [
      "Lentejas",
      "Cebolla",
      "Zanahoria",
      "Apio",
      "Tomate triturado en conserva",
      "Ajo",
      "Caldo de verduras",
      "Aceite de oliva",
      "Sal",
      "Pimienta",
      "Pimentón"
    ]
  }
]
'
```

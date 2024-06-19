# REQUERIMIENTO 6 - INDIVIDUAL BASE

## CRUD PRODUCT

- Alta de un producto
- Alta de un conjunto de productos
- Baja de un producto
- Modificacion de un producto

### CONSIDERACION A TENER EN CUENTA

#### Dominio

Se decidió no realizar la vinculación del producto con el vendedor, ya que a la hora de crear la orden y los lotes, el vendedor no existe (es decir, nunca se hizo la distinción producto x cliente), por lo que se decidió no incluirlo en el dominio propuesto.

#### POSTMAN COLECCTION

Se eliminaron todas los token asociados a las peticiones, por lo que antes de querer ejecutar una peticion, deberá llamarse a "/auth/login", con las credenciales correctas para obtener un token de usuario.

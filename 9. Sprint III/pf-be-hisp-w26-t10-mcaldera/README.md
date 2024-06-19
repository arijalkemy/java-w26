# FrescosMeli - Individual Sprint lll

MercadoLibre es la empresa líder en comercio electrónico de LATAM con operaciones en  18 países. MELI (como se la conoce por sus siglas en la bolsa de NY) desea ampliar su negocio para incluir en su listing (oferta), productos FRESCOS. Hoy MELI ya vende productos alimenticios pero quiere incursionar en poder vender productos que necesitan refrigeración; a estos los denomina productos frescos. implica nuevos retos en la forma de almacenar,  transportar y comercializar los productos, ya que se realiza de una forma totalmente diferente. El modelo de negocios implementado actualmente en relación a cómo tratamos nuestros productos (almacenamiento, transporte y comercialización) es incompatible para los productos frescos de la industria alimentaria, motivo por el cual tenemos el desafío de cumplir con estos nuevos requisitos para así poder cubrir las necesidades de este nuevo mercado.

Todos los productos, para que puedan ser almacenables, transportables y comercializables deben de poseer información común como la fecha de caducidad y número de lote, y cada tipo de producto además posee alguna información específica.

### Instalación

El proyecto esta preparado para su uso, la colección de endpoints se encuentra registrado en el archivo "" que corresponde a una colección de la herramienta postman.
Dirección de autenticacion:
##### /auth/login

Estructura de json:

{
"username":"",
"password":""
}

### Accesos

Para usar esta herramienta, se requiere tener presente, que cada enpoint cuenta con seguridad de acceso al mismo, por lo tanto, cada usuario debe de autenticarse como se menciona en el punto anterior.
Para esto, la autenticación nos genera un token de acceso para ser enviado como header en la url a la cual queremos acceder.
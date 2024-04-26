## Endpoints numerados 

| Núm. |  Endpoint | Descripción | Método | Ejemplo | Opciones de ordenación |
|---|---|---|---|---|---|
| US0001 |   `PATCH /users/{userId}/follow/{userIdToFollow}` | Seguir a un usuario | PATCH | `PATCH /users/123/follow/234` | - |
| US0002 |   `GET /users/{userId}/followers/count` | Obtener la cantidad de seguidores de un usuario | GET | `GET /users/234/followers/count` | - |
| US0003 |  `GET /users/{userId}/followers/list` | Obtener la lista de seguidores de un usuario | GET | `GET /users/234/followers/list` | - |
| US0004 |  `GET /users/{userId}/followed/list` | Obtener la lista de usuarios seguidos por un usuario | GET | `GET /users/4698/followed/list` | - |
| US0005 | `POST /products/post` | Crear una nueva publicación | POST | `POST /products/post` (Payload en la documentación) | - |
| US0006 | `GET /products/followed/{userId}/list` | Obtener las publicaciones de los usuarios seguidos en las últimas dos semanas | GET | `GET /products/followed/4698/list` | - |
| US0007 |  `PATCH /users/{userId}/unfollow/{userIdToUnfollow}` | Dejar de seguir a un usuario | PATCH | `PATCH /users/234/unfollow/123` | - |
| US0008 |  `GET /users/{userId}/followers/list` | Obtener la lista de seguidores de un usuario | GET | `GET /users/234/followers/list` | `order=name_asc`, `order=name_desc` |
| US0008 |  `GET /users/{userId}/followed/list` | Obtener la lista de usuarios seguidos por un usuario | GET | `GET /users/4698/followed/list` | `order=name_asc`, `order=name_desc` |
| US0009 |  ` GET /products/followed/{userId}/list `  |Ordenamiento por fecha ascendente y descendente| GET | `GET /users/4698/followed/list` | `order=name_asc`, `order=name_desc` |

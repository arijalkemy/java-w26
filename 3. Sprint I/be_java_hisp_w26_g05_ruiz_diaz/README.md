### Marcar Publicación como Favorita (favorite)

| Operación | Descripción |
|-----------|-------------|
| Método | POST |
| Endpoint | `/{userId}/favorite/{postId}` |
| Parámetros | - `userId` (Long): ID del usuario que marca la publicación como favorita. <br> - `postId` (Long): ID de la publicación que se marcará como favorita. |
| Respuesta | ResponseEntity sin contenido (código de estado 204) |

### Desmarcar Publicación como Favorita (unfavorite)

| Operación | Descripción |
|-----------|-------------|
| Método | POST |
| Endpoint | `/{userId}/unfavorite/{postId}` |
| Parámetros | - `userId` (Long): ID del usuario que desmarca la publicación como favorita. <br> - `postId` (Long): ID de la publicación que se desmarcará como favorita. |
| Respuesta | ResponseEntity sin contenido (código de estado 204) |

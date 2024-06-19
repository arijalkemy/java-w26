## API Endpoints

### List Batches of Product in Purchase Order

This endpoint is used to list the batches of a product in a specific purchase order.

**URL:** `/api/v1/fresh-products/orders/{orderId}/batch-list`

**Method:** `GET`

**URL Parameters:**

- `orderId` (required): The ID of the purchase order.

**Success Response:**

- **Code:** 200 OK
- **Content:** `{ PickingResponseDTO }`

**Error Response:**

- **Code:** 400 BAD REQUEST
- **Content:** `{ error : "Bad Request Exception" }`

---

### List Batches of Product in Cart

This endpoint is used to list the batches of a product that are currently in the cart.

**URL:** `/api/v1/fresh-products/products/cart`

**Method:** `GET`

**Success Response:**

- **Code:** 200 OK
- **Content:** `{ List<StarProductsDTO> }`

**Error Response:**

- **Code:** 400 BAD REQUEST
- **Content:** `{ error : "Bad Request Exception" }`

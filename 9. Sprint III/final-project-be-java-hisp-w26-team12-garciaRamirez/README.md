# Sprint 3 individual project


# Important
Regarding the README file, it refers to this same document. The PDF documentation and the Postman collection are located in the docs folder. Lastly, the user story featuring 3 endpoints can be found at the end of the document.

This repository contains APIs for managing products and warehouses related to sellers.

---

## POST /{idSeller}

Creates multiple products for a specified seller.

- **Description:** Processes a request to create products for a seller.
- **Endpoint:** `/api/products/{idSeller}`
- **Method:** `POST`
- **Request Body:** `ProductCreationListRequestDTO`
    - Contains details of products to be created.
- **Response:** `ProductCreationResponseDTO`
    - Indicates the success of the operation.
- **Throws:**
    - `ApiException` if seller ID is not found or if a product already exists for the seller.

---

## PUT /{idSeller}/{idProduct}

Updates a product owned by a specified seller.

- **Description:** Processes a request to update a product for a seller.
- **Endpoint:** `/api/products/{idSeller}/{idProduct}`
- **Method:** `PUT`
- **Request Body:** `ProductCreationDTO`
    - Contains updated details of the product.
- **Response:** `ProductCreationResponseDTO`
    - Indicates the success of the update operation.
- **Throws:**
    - `ApiException` if seller ID is not found, if the product does not exist in the seller's scope, or if the product with the given ID is not found.

---

## GET /batch/list/scarce/{scarceLimit} (Own project)

Retrieves all warehouses with products below a specified scarcity limit.

- **Description:** Retrieves warehouses with products below a specified scarcity limit.
- **Endpoint:** `/api/batch/list/scarce/{scarceLimit}`
- **Method:** `GET`
- **Path Variable:** `scarceLimit`
    - Specifies the threshold of scarcity (positive number).
- **Response:**
    - Returns a list of `ScarceWarehouseDTO` objects representing warehouses and their scarce products.
- **Throws:**
    - `ApiException` if the scarcity limit is not positive.

---

### Contributors

- **Maintainer:** Mau!
- **Contact:** txai.garcia@mercadolibre.com.mx


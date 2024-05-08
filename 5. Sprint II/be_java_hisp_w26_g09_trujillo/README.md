
# MELI Social API 🚀

The MELI Social API provides endpoints to interact with a Meli social network.

## Description 📝

This API allows users to perform various actions on the MELI social network, such as creating posts, following other users, and viewing the content of their products.

## Packages

The MELI Social API architecture is organized into several packages for better code modularity and maintainability. Below is a graphical representation of examples:
![Repository](https://i.postimg.cc/Bn81gKCF/Captura-de-pantalla-2024-04-25-a-la-s-3-53-34-p-m.png "Repository")
![Repository](https://i.postimg.cc/ydTJdX7M/Captura-de-pantalla-2024-04-25-a-la-s-3-53-46-p-m.png "Repository")

## Endpoint Documentation 📋

Below are the available endpoints:

- `US-001 POST /users/{userId}/follow/{userIdToFollow}`: Ability to perform the "Follow" action on a specific seller.
- `US-002 GET /users/{userId}/followers/count`: Get the count of users following a specific seller.
- `US-003 GET /users/{userId}/followers/list`: Get a list of all users following a specific seller (Who follows me?).
- `US-004 GET /users/{userId}/followed/list`: Get a list of all sellers followed by a specific user (Whom do I follow?).
- `US-005 POST /products/post`: Create a new post.
- `US-006 GET /products/followed/{userId}/list`: Get a list of posts made by sellers that a user follows in the last two weeks.
- `US-007 POST /users/{userId}/unfollow/{userIdToUnfollow}`: Ability to perform the "Unfollow" action on a specific seller.
- `US-008.1 GET /users/{UserID}/followers/list?order=typeOrder`: Sorting followers alphabetically in ascending and descending order (Replace typeOrder with name_asc or name_desc).

| Sorting Types | Description |
| ------------ | ------------ |
| name_asc | Sorting by name in Ascending order |
| name_desc | Sorting by name in Descending order |

- `US-008.2 GET /users/{UserID}/followed/list?order=typeOrder`: Sorting followed users alphabetically in ascending and descending order (Replace typeOrder with name_asc or name_desc).

| Sorting Types | Description |
| ------------ | ------------ |
| name_asc | Sorting by name in Ascending order |
| name_desc | Sorting by name in Descending order |

- `US-009 GET /users/{UserID}/followers/list?order=typeOrder`: Sorting seller's posts by date in ascending and descending order (Replace typeOrder with date_asc or date_desc).

| Sorting Types | Description |
| ------------ | ------------ |
| date_asc | Sorting by publication date in Ascending order |
| date_desc | Sorting by publication date in Descending order |

## Postman Collection 📦

A Postman collection with request examples to test the MELI Social API services is included. The collection provides examples of all available operations.

To use the Postman collection, follow these steps:

1. Download and install [Postman](https://www.postman.com/downloads/).
2. Import the Postman collection by clicking the "Import" button in the Postman UI and selecting the JSON file of the collection attached at ***src/main/resources/Bootcamp sprint 1.postman_collection.json***.
![Collection url](https://i.postimg.cc/hvSdbZC4/Captura-de-pantalla-2024-04-25-a-la-s-3-04-14-p-m.png "Collection url")
4. Once imported, you'll see all the endpoints and pre-defined requests ready to be executed.

## Contributors 👥

- [@Jhonatan Sánchez](https://github.com/jhonatansanchezp-meli)
- [@Joan Andrés Gómez](https://github.com/jgomezreyes)
- [@Fabian Trujillo](https://github.com/fabian001254)
- [@Edwin Steven Guayacan](https://github.com/EdwinGuayacan)
- [@Mario Iván Lozano](https://github.com/ivanlozanoq)
- [@Geraldine Gómez](https://github.com/ggomezr1403)
- [@Nilson Vargas](https://github.com/nvargasparra)

## Modelo relacional

<img width="627" alt="Captura de pantalla 2024-05-26 a la(s) 1 57 46 p  m" src="https://github.com/arijalkemy/java-w26/assets/164801871/095a257a-2864-4f62-826d-39ef7e4d3d84">


{
	"info": {
		"_postman_id": "9a2be9c2-5e07-461b-bfd0-7a6e2bd2ed4d",
		"name": "joyas",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "34426729"
	},
	"item": [
		{
			"name": "Guardar joya",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nombre\": \"Anillo de diamantes\",\n  \"material\": \"Oro blanco\",\n  \"peso\": 2.5,\n  \"particularidad\": \"Engarzado con diamantes\",\n  \"posee_piedra\": true,\n  \"ventaONo\": true\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/joyas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"joyas"
					]
				}
			},
			"response": []
		},
		{
			"name": "Modificar joya con id 1",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nombre\": \" de diamantes\",\n  \"material\": \"Oro blanco\",\n  \"peso\": 2.5,\n  \"particularidad\": \"Engarzado diamantes\",\n  \"posee_piedra\": true,\n  \"ventaONo\": true\n}\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/joyas/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"joyas",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener joya con id 1",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nombre\": \" de diamantes\",\n  \"material\": \"Oro blanco\",\n  \"peso\": 2.5,\n  \"particularidad\": \"Engarzado diamantes\",\n  \"posee_piedra\": true,\n  \"ventaONo\": true\n}\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/joyas/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"joyas",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener todas las joyas",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nombre\": \" de diamantes\",\n  \"material\": \"Oro blanco\",\n  \"peso\": 2.5,\n  \"particularidad\": \"Engarzado diamantes\",\n  \"posee_piedra\": true,\n  \"ventaONo\": true\n}\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/joyas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"joyas"
					]
				}
			},
			"response": []
		},
		{
			"name": "Eliminar joya con id 2",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "",
						"value": "",
						"disabled": true
					}
				],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/joyas/2",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"joyas",
						"2"
					]
				}
			},
			"response": []
		}
	]
}

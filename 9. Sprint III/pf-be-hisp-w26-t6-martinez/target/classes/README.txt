{
	"info": {
		"_postman_id": "d48ffe7a-78ea-4aa8-9903-607ec48f3dea",
		"name": "SPRINT_3",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "34294294"
	},
	"item": [
		{
			"name": "req1",
			"item": [
				{
					"name": "New Request",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaGFybGllIiwicm9sIjoiU1VQRVJWSVNPUiIsImlhdCI6MTcxODgyMjYxNSwiZXhwIjoxNzE4ODI2MjE1fQ.VoFlpH1xucGCWP2nNtdMLGism7r_019QtXHhdt6VBIc",
									"type": "string"
								}
							]
						},
						"method": "POST",
						"header": [
							{
								"key": "X-TIGER-TOKEN",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"inbound_order\": {\n        \"order_number\": 2,\n        \"order_date\": \"10-04-2014\",\n        \"section\": {\n            \"section_code\": 1,\n            \"warehouse_code\": 1\n        },\n        \"batch_stock\": [\n            {\n                \"batch_number\": 2,\n                \"product_id\": 1,\n                \"current_temperature\": 15.00,\n                \"minimum_temperature\": 10.00,\n                \"initial_quantity\": 20,\n                \"current_quantity\": 20,\n                \"manufacturing_date\": \"15-04-2014\",\n                \"manufacturing_time\": \"15-04-2014 17:23:21\",\n                \"due_date\": \"15-05-2014 00:00:00\"\n            }\n        ]\n    }\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/inboundorder",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"inboundorder"
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "PUT",
						"header": [
							{
								"key": "X-TIGER-TOKEN",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"inbound_order\": {\n        \"order_number\": 1,\n        \"order_date\": \"10-04-2014\",\n        \"section\": {\n            \"section_code\": 4,\n            \"warehouse_code\": 2\n        },\n        \"batch_stock\": [\n            {\n                \"batch_number\": 2,\n                \"product_id\": 1,\n                \"current_temperature\": 15.00,\n                \"minimum_temperature\": 10.00,\n                \"initial_quantity\": 20,\n                \"current_quantity\": 20,\n                \"manufacturing_date\": \"15-04-2014\",\n                \"manufacturing_time\": \"15-04-2014 17:23:21\",\n                \"due_date\": \"15-05-2014 00:00:00\"\n            }\n        ]\n    }\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/inboundorder",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"inboundorder"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "req2",
			"item": [
				{
					"name": "New Request",
					"request": {
						"method": "POST",
						"header": [],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/orders",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"orders"
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/orders/{orderId}",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"orders",
								"{orderId}"
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "PUT",
						"header": [],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/orders/{orderId}",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"orders",
								"{orderId}"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "req3",
			"item": [
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/1/batch/list",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"1",
								"batch",
								"list"
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-tiger-token",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/1/batch/list?order=C",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"1",
								"batch",
								"list"
							],
							"query": [
								{
									"key": "order",
									"value": "C"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-tiger-token",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/11231231/batch/list",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"11231231",
								"batch",
								"list"
							]
						}
					},
					"response": []
				},
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-tiger-token",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{URL_2}}/api/v1/fresh-products/1/batch/list?order=ASD",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"1",
								"batch",
								"list"
							],
							"query": [
								{
									"key": "order",
									"value": "ASD"
								}
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "req4",
			"item": [
				{
					"name": "Find product stock by all warehouse",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaGFybGllIiwicm9sIjoiU1VQRVJWSVNPUiIsImlhdCI6MTcxODMwNTcxOSwiZXhwIjoxNzE4MzA5MzE5fQ.s2ZanApUZTrEsFBFXIc97QR8r7V-jsWbpoSozpq8iGY",
									"type": "string"
								}
							]
						},
						"method": "GET",
						"header": [
							{
								"key": "x-tiger-token",
								"value": "{{FURY_TOKEN}}",
								"type": "text"
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
							"raw": "{{URL_2}}/api/v1/fresh-products/1/warehouse/list",
							"host": [
								"{{URL_2}}"
							],
							"path": [
								"api",
								"v1",
								"fresh-products",
								"1",
								"warehouse",
								"list"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "req5",
			"item": []
		},
		{
			"name": "req6",
			"item": [
				{
					"name": "Register user",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Create outbound transfer",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"outbound_order\": {\n        \"outbound_order_number\": 1,\n        \"warehouse_origin_code\": 1,\n        \"warehouse_destination_code\": 2,\n        \"batches\": [\n            {\"batch_number\": 2},\n            {\"batch_number\": 3}\n        ]\n    }\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						}
					},
					"response": []
				},
				{
					"name": "Update outbound transfer",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "ping",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "X-Tiger-Token",
						"value": "{{FURY_TOKEN}}",
						"type": "text"
					}
				],
				"url": {
					"raw": "{{URL_2}}/ping",
					"host": [
						"{{URL_2}}"
					],
					"path": [
						"ping"
					]
				}
			},
			"response": []
		},
		{
			"name": "test",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "X-Tiger-Token",
						"value": "{{FURY_TOKEN}}",
						"type": "text"
					}
				],
				"url": {
					"raw": "{{sprint3}}/test",
					"host": [
						"{{sprint3}}"
					],
					"path": [
						"test"
					]
				}
			},
			"response": []
		},
		{
			"name": "Login",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "x-tiger-token",
						"value": "{{FURY_TOKEN}}",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"username\": \"charlie\",\n    \"password\": 12345\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{URL_2}}/auth/login",
					"host": [
						"{{URL_2}}"
					],
					"path": [
						"auth",
						"login"
					]
				}
			},
			"response": []
		}
	],
	"auth": {
		"type": "bearer",
		"bearer": [
			{
				"key": "token",
				"value": "{{TOKEN}}",
				"type": "string"
			}
		]
	},
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"packages": {},
				"exec": [
					"const API_URL_AUTH = pm.environment.get(\"URL_2\") + \"/auth/login\";",
					"const USERNAME = pm.variables.get(\"USERNAME\");",
					"const PW = pm.variables.get(\"PW\");",
					"const FURY_TOKEN = pm.environment.get(\"FURY_TOKEN\")",
					"const TOKEN_NAME = \"TOKEN\"",
					"// -------------",
					"const options = {",
					"    url: API_URL_AUTH,",
					"    method: \"POST\",",
					"    header: ",
					"        {",
					"            \"content-type\": \"application/json\",",
					"            \"X-Tiger-Token\": FURY_TOKEN",
					"    },",
					"    body: {",
					"        mode: \"raw\",",
					"        raw: JSON.stringify({ \"username\": USERNAME, \"password\": PW })",
					"    }",
					"}",
					"// -------------",
					"pm.sendRequest(options, function (err, response) {",
					"    const res = response.json();",
					"    if(response.code !== 200){",
					"        pm.environment.set(TOKEN_NAME, \"ERROR\");",
					"    } else {",
					"        pm.environment.set(TOKEN_NAME, res?.access_token)",
					"    }",
					"});"
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"type": "text/javascript",
				"packages": {},
				"exec": [
					""
				]
			}
		}
	],
	"variable": [
		{
			"key": "USERNAME",
			"value": "charlie",
			"type": "string"
		},
		{
			"key": "PW",
			"value": "12345",
			"type": "string"
		},
		{
			"key": "USERNAME",
			"value": "bob",
			"type": "string",
			"disabled": true
		},
		{
			"key": "PW",
			"value": "12345",
			"type": "string",
			"disabled": true
		}
	]
}
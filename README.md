
# Exercício 1: Microservices (Payment Service)


## Inicializar projeto

```sh
mvn sprint-boot:run
```

## Pagamentos

#### Listar

```sh
curl -X GET \
  http://localhost:8080/payments \
  -H 'content-type: application/json'
```

#### Inserir

```sh
curl -X POST \
  http://localhost:8080/payments \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4dfb9044-ceb1-74e0-7861-a5320674b729' \
  -d '{
    "brand": "VISA",
    "transactionType": "CREDITO",
    "cardNumber": "3901 5361 0584 9477",
    "expDate": "12/23",
    "cvv": 536,
    "price": 50.00
}'
```

#### Carregar

```sh
curl -X GET \
  http://localhost:8080/payments/8f427254-e923-f0de-7c03-97c0e7cedf44 \
  -H 'content-type: application/json'
```

#### Alterar

```sh
curl -X PUT \
  http://localhost:8080/payments \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4dfb9044-ceb1-74e0-7861-a5320674b729' \
  -d '{
    "brand": "MASTERCARD",
    "transactionType": "CREDITO",
    "cardNumber": "3901 5361 0584 9477",
    "expDate": "12/23",
    "cvv": 536,
    "price": 50.00
}'
```

#### Remover

```sh
curl -X DELETE \
  http://localhost:8080/payments/8f427254-e923-f0de-7c03-97c0e7cedf44
```


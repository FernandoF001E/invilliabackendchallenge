# Invillia recruitment challenge

## Database
* Oracle

## Steps to run api
* Execute command --> mvnw install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=13.9 -Dpackaging=jar
* Obs: Oracle driver from the maven repository has a problem downloading. Install driver locally with the command above. Driver already included in the project

## Endpoints
## GET and PUT
* http://localhost:8034/store/{id}
* http://localhost:8034/order/{id}
* http://localhost:8034/item/{id}
* http://localhost:8034/payment/{id}

## POST
* http://localhost:8034/store
* http://localhost:8034/order
* http://localhost:8034/item
* http://localhost:8034/payment

## JSON
* store
{
	"name": "Fernando Sanchez",
	"address": "Teste de rua, 208"
}
* order
{
	"address": "Teste de rua, 208",
	"confirmationdate": "2020-03-04",
	"status": 1
}
* item
{
	"description": "Cerveja Heineken",
	"unitprice": 2.99,
	"quantity": 12
}
* payment
{
	"credicardnumber": 231231321,
	"paymentdate": "2020-03-03",
	"status": 1
}

## Application.properties
* Inform username and password of the oracle database that will perform the test.


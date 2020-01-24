# Shopping Cart

Simple shopping cart project utilizing Angular 8, Spring Boot, Java 8, JWT, Lombok, Maven and others.

## Build
Execute this command on main root:

``mvn package``

Will be execute the scripts to do build the shoppingcart-api and shopping-cart-web.

## Running on Docker

To run on docker execute this command on main root after project build:

``docker-compose up -d --build``

This command will build image from Dockerfile of the each project and will server up the containers of each image of the project on Docker.

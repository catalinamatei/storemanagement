# storemanagement

I created an API with Maven dependencys and Spring Boot framework that acts like a store management service.
I store Products object and Users object in a database, for this project I used MySQL Server, and I acces them through JPA. I wraped that with controllers that allow acces over internet.
I kept it simple, just two classes. 
I tryed to desing an elegant project, a package for every type of use.
Entities class for keeping classed that represent our tables with their atributes.
Repository package for keeping interfaces that allow acces to databaase because implement JpaRepsotory that contains API for basic CRUD operation.
Services package where classes implement a specific repository to define CRUD methods in a personal way.
Controllers is the package where I created a controller for every entity class. 
Controllers use dependency injection, adnotation @Autowire inject class dependecy to instantiate the objectServices. 
Controllers provide acces to aplication behavior that I defined in Services package.
Adnotation @GetMapping, @PostMaping etc. interpret what kind of request client made and map URLs into particular handler method.
ApiError package has classes that help with exceptions. Depend on the logic of each method, this classes are called in Services classes for throwing exeption in case a product wasn't found for exaple. 
ServicesTest package has unit test for each Services class and methods from them.

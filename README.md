## Clean Architecture

This is demo application to demonstrate the structure of a spring
application using the [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
 model.
 
![Alt text](clean-architecture.png)

### Package structure

- [domain](#domain)
- [usecase](#use-cases)
    - [exception](#exception)
    - [port](#ports)
- [adapter](#adapter)
    - [controller](#controller)
    - [repository](#repository)
 
#### Domain
This package encapsulates all the domain objects and entities. Have in mind that no framework is allowed on this level,
 so the domain objects must not have ORM specific annotations.

#### Use cases
This package encapsulates the core business rules. In this example every crud operation is divided into a class with a 
single responsibility, e.g., the FindUser class provides different methods for finding the user, it communicates with a
data repository, applies the required business rules, and then returns the data.

##### Exception
This package containing business rules exceptions.

##### Ports
Interface for input and outputs adapters that are being used by the Use Cases. Since the use case must not know the
implementation of the input or output all communication between the layers is made through interfaces. In this sample 
every Use case has a different port, this is not required, but it helps separate the input from the outputs.

#### Adapter
This layer contains all the input and output implementations. Every class inside this package should not be available
outside this package. So it's recommended that every class use the default access modifier.

##### Controller
Contains the implementation for the spring controller. Holds all endpoints and makes the mapping of the domain object
to a response DTO.

##### Repository 
Contains the implementation of the repository using Spring Data. This package contains the database entities since all
JPA annotations should be inside an adapter package. The repository uses the query through the interface pattern but
as it needs to implement the ports interfaces it must have a gateway class for mapping the domain object to the
database entity and vice-versa.

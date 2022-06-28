package it.marchino.quarkus

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {

   fun greet(name: String) = "Hello $name";

}

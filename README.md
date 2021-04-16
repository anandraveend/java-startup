# Java 8 -Lambdas

**A lambda expression is an unnamed block of code (or an unnamed function) with a list of formal parameters
and a body**

### FunctionalInterface annotation to define a lambda expression interface
A functional interface is simply an interface that has exactly one abstract method
Other than the abstract method, they can have the below -
- Default methods
- Static methods
- Public methods inherited from Object class

### Use compose and andThen to chain functional interfaces
- The andThen() method returns a composed Function that applies this function to the argument, and then applies the specified after function to the result. 
- The compose() function returns a composed function that applies the specified before function to the argument, and then applies this function to the result. 
- The identify() method returns a function that always returns its argument.

### Predicate interface
A predicate represents a condition that is either true or false for a given input.


### Lexical scoping
Even though a lambda expression looks like a method declaration, it does not define a scope of its own.
It exists in its enclosing scope. This is known as lexical scoping for lambda expressions.
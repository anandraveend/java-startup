# Java 8 Inner Classes

### To execute a main class
 `mvn exec:java -D"exec.mainClass"="com.anand.App"`

### Uses of inner classes
- Additional namepsace
- Use for callbacks
- Implements closures
- Can be used for an extended form of inheritacnce

### Types of inner classes
- Member inner
- local inner
- anonymous inner

### A static Member Class Is Not an Inner Class
A static member class is not an inner class. It is considered a top-level class. It is also called a nested
top-level class. Since it is a top-level class, you do not need an instance of its enclosing class to create its
object.

### To instantiate an inner class, you must first create an object of outer and then invoke new on its inner class

### Local variables of enclosing class accessed by an inner lass should be final

### Inner classes cannot have static members

### Closures
A closure is a higher order function packaged with its defining environment. A closure carries with it the variables in scope when it was defined,
and it can access those variables even when it is invoked in a context other than the context in which it was
defined.

### Defining inner classes in static methods is allowed but you cannot reference non static methods/variables in the inner class
	

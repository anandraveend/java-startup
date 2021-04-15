# Java 8 Generics

### Used to help with polymorphism.

### The non-generic version of a generic type is called a raw type. Using raw types is discouraged.

### Unbounded wild cards
use of ? when the type is unclear

### Upper bounded wild cards
? extends <Parent> where ? can only be subtypes

### Lower bounded wild cards 
Use this to enforce type can only be a super of the given type

### Reification
Representing a type at runtime is called reification. A type that can be represented at runtime is called a reifiable type. A type that is not completely represented at runtime is called a non-reifiable type. 

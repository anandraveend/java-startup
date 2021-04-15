# Java 8 Reflections

### To create a new branch  using git
 `git checkout -b <branch-name>`

### Definition
Reflection is the ability of a program to query and modify its state “as data” during the execution of the program. The ability of a program to query or obtain information about itself is known as **introspection**.
The ability of a program to modify its execution state, modify its own interpretation or its meaning, or add new behaviors to the program as it is executing is called **intercession**.
	
### Class reflection can be done using-
1. using a class Literal
2. using the getClass() method of the Object class
3. using the forName() static method of Class class

### Deep reflection
Java has been allowing access to rather inaccessible members such as a private field of a class outside the class using reflection. This is called deep reflection
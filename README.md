# Java 8 Annotations

### To generate a new maven project 
 `mvn archetype:generate -DgroupId=com.anand -DartifactId=java-startup -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`


### Syntax:
[modifiers] @ interface <annotation-type-name> {
// Annotation type body goes here
}


`public @ interface Version {`
`	int major();`
`	int minor();`
`}`

### Restrictions
1. Cannot inherit from another annotation type
2. Methods cannot have parameter types
3. methods cannot have a throws clause
4. return types must be primitive, Class, String, enum, annotation or array of the above
5. Cannot override methods in Object
6. Cannot be  generic  
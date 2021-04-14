## To generate a new maven project ->  `mvn archetype:generate -DgroupId=com.anand -DartifactId=java-startup -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

# Java 8 

# Annotations

Syntax:
[modifiers] @ interface <annotation-type-name> {
// Annotation type body goes here
}


`public @ interface Version {`
`	int major();`
`	int minor();`
`}`
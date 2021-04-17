# Java 8 -Threads

## Some definitions
- A program is an algorithm expressed in a programming language. 
- A process is a running instance of a program with all system resources allocated by the operating system to that instance of the program.
Typically, a process consists of a unique identifier, a program counter, executable code, an address space,open handles to system resources, a security context, and many other things. 
- A program counter, also called an instruction pointer, is a value maintained in the CPU register that keeps track of the instruction being executed by the CPU.
- Multitasking is the ability of an operating system to execute multiple tasks (or processes) at once. 
- The switching of the CPU among processes is called a context switch. In a context switch, the running process is stopped, its state is saved, the state of the process that is going to get the CPU is restored, and the new process is run.

### Ways of creating threads
1. Inheriting the Thread class
2. Implementing the Runnable interface
3. Using a method reference in Thread class - method reference of a method (static or instance) that takes no parameters and returns void as the code to be executed by a thread.

### You can handle an uncaught exception thrown in your thread - implements Thread.UncaughtExceptionHandler

### Common Thread methods
- wait - wait until notified
- notify - notify a waiting thread
- park /unpark 
- join - used to serialize execution
- getCurrentThread - who is currently running

### Daemon Threads
A daemon thread is a kind of a service provider thread, whereas a user thread (or non-daemon thread) is a thread that uses the services of daemon threads. 

### Thread interrupt() vs isInterrupted()
First one clears the interrupted state, while the other just queries it

### Volatile variables
For every write request for a volatile variable, a thread writes the value to the main memory. In other words, a thread does not cache the value of a volatile variable in its working memory. 
You can declare only a class member variable (instance or static fields) as volatile.
You cannot declare a volatile variable final because the volatile keyword is used with a variable that changes.
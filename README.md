# Java 8 - NIO

### New IO is an improvement on the speed of older java io package by leveraging streaming by using channels and streams
A stream can be used for one-way data transfer. That is, an input stream can only transfer data from a data source to a Java program; an output stream can only transfer data from a Java program to a data sink. 
However, a channel provides a two-way data transfer facility

### Buffer classes
A buffer is a fixed-length data container. There is a separate buffer type to hold data for each type of primitive value, except for boolean type values.

The following are the four important properties of a buffer, which you must understand to use it
effectively:
• Capacity
• Position
• Limit
• Mark

A byte buffer gets special treatment in NIO. It has an extra method called allocateDirect() that creates a byte buffer for which the memory is allocated from the operating system memory, not from the JVM heap. This avoids copying the contents to intermediate buffers during I/O operations

### USe FileLock to get a exclusive lock on a file
### User transferFrom/trasnsferTo to copy data from/to one channel to another

### Use ByteOrder.nativeOrder() to get the ENDIAN-ness of machine

### Use the Watchable interface to track modifications to a file object
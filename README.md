# Java 8 -IO

### Piped Streams are used to maintain a continuous flow of data from a source to a sink
-  PipedOutputStream
-  PipedInputStream

### Decorator pattern 

### Serialization is the process of converting java objects to a sequence of bytes and saving to a storage medium
- implements Serializable
- use an ObjectOutputStream
- serialize using writeObject

### Difference between Serializable vs Externalizable
- S is just a marker. No methods defined in the interface while E requires you to implement readExternal and writeExternal
- E makes it users responsibility to implement the serialization process
- marking a field as static/transient skips them during the serialization process

### RandomAccessFile allows both read and writes 

### SerialTokenizer to split strings based on a combination of field separators 
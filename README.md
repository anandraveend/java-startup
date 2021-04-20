# Java 8 - Collections

## Collection Interface - root of all collections
Collection operations are split into -
### Basic operations
- size/contains/add/remove/iterator

### Bulk operations
- addAll/clear/containsAll/removeAll/retainAll

### Aggregate
- stream/parallelStream

### Array operations
- toArray

### Comparison operations
- equals/hashCode

# Iterators
An iterator lets you perform the following three operations on a collection:
• Check if there are elements that have not been yet accessed using this iterator.
• Access the next element in the collection.
• Remove the last accessed element of the collection


## Set - a collection of unique elements
- HashSet - does not guarantee ordering of elements
- Linked HashSet  orders elements in the same order of insertion
- Sorted Set sorts the elements - eg TreeSet
- use Set.of() to create an immutable set

## Navigable Set
A navigable set is a specialized sorted set that lets you work with its subsets in a variety of ways. An instance
of the NavigableSet<E> interface represents a navigable set. The NavigableSet interface inherits from
the SortedSet interface and defines some additional methods to extend the functionality provided by the
SortedSet. It extends SortedSet in the following ways:
• It lets you navigate the set in reverse order. The reverse order is the opposite order
in which your SortedSet would be sorted normally. Its descendingSet() method
returns a NavigableSet, which is another view of the same NavigableSet in the
reverse order. If you modify the original NavigableSet or the one returned from the
descendingSet() method, the modifications will be reflected in both sets.
• It adds another version of the three methods headSet(), tailSet(), and subSet()
in SortedSet, which accept a boolean flag to include the element at the beginning or
the end of the subset boundary.


## List - an ordered collection of objects
- can have duplicate
- can be accessed by the index

### ArrayList - backed by an array
- performs better read. 
- writes are fast if done at end
- slower inserts/deletes due to overhead of array rearrangement

### LinkedList - baked by a list
- performs better when inserting/deleting
- slower read/writes compared to ArrayList


### Queues 
- unbounded/bounded
- LIFo(Stack)/FIFO(queue)
- allows add/remove/query methods where each maybe implemented to throw an exception if the operation failed or return null instead

### Dequeue(pronounced deck not de-queue) - Double ended queues
 

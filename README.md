loginsystem
===========
Fall 2012 Object Oriented Design Final Exam Projec

This code was to create a basic Login System based of given Class Diagrams.
We implemented UML to design the system, then wrote a basic working version as a proof of concept. 

TODOS:

1. Rewrite the way AccountTable works. No need for an ArrayList. We should use a HashTable. Not a HashMap since we want
it to be Synchronous possibly for when It interacts with the Graphical Interface.  And since the Underlying implementation 
of a HashTable is an ArrayList we get the same data structure with added benefits of lookup and access.

2. Modify some of the validation methods and statements. There are many things that could be changed. This includes useless
boolean values where a simple <code> return someBoolFunction(value) && someOtherFunction(somval) </code> would do the trick.

3. Go over all files and uniformily write the accessors and mutators. Methods across the system should match, as well as
the way they return values. Some create a tmp variable, then return that. while others just return the class variable. 


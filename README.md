# Security

UTEID: dag2788; hck93; 
FIRSTNAME: Daniel; Holt; 
LASTNAME: Garza; Kostohryz;
CSACCOUNT: dgza88; holtk;
EMAIL: dgza88@utexas.edu; holtkostohryz@gmail.com; 


Description of the Code:

The SecuritySystem class reads a file with commands.
Each line is turned into an InstructionObject
Each InstructionObject will have 3 or 4 parts:
    1- command
    2- subject
    3- object
    4- value
The ReferenceMonitor keeps track of every subject and object and sets their corresponding level.
The ReferenceMonitor will check the level of the subject and object and if the instruction is valid call the ObjectManager to carryout the given command.
If it is illegal instruction then it is a BadInstruction
The ReferenceMonitor will return a value to a subject, either the value read or the value 0

  We created 8 classes.
    1) SecuritySystem.java : runs the main function, reads the intruction/command file from the path "/u/dgza88/CS361/Security/src/" and it has a local ReferenceMonitor object, InstructionObject and SecurityLevel objects.
    
    2)Subject.java : initializes subjects with its proper attributes along with setters and getters
    
    3)Objct.java : initializes objects with its proper attributes along with setters and getters
    
    4)SecurityLevel.java : established the dominates relation with HIGH = 1, and LOW = 0;
    
    5) InstructionObject.java : takes in a string and it is parsed into 3 or 4 tokens depending on the instruction. We have getters and setters for these attributes.
    
    6)ReferenceMonitor.java : receives an instruction through a method instruction, it is then evaluated based on the Simple Security property and Star property. 
    
    7)ObjectManager.java : local to ReferenceMonitor takes in a subject and object and writes or reads depending on the command.
    
    8) BadInstrucion : local to ReferenceMonitor, it displays the error message when an instruction is invalid.
    
    
    
  How much did we finish:
    1) We implemented the SecuritySystem class to carryout main and to read the instruction/command file.
    2) We implemented different classes for the objects and subjects.
    3) We implemented an ObjectManager to carry out the READ and WRITE instructions.
    4) We implemented an InstructionObject that is parsed and used to evaulate the validity of the command.
    5) We carried out a SecurityLevel class to establish the level of the subject and object.
    6) We implemented BadInstruction class to be used when an instruction is invalid.
    7) We were able to implement the Simple Security principle and the Star Property.
    
    
    We wrote 8 test cases. 
    
    The 1st through 4th test cases cover the validity of write instruction:
     1) write Sun HObj 50 // for invalid Subject and Object names
        write Hal Sun  50 // for invalid Subject and Object names
     2) write Hal Lyle 50 // Subject to Subject communication
        write Lyle Hal 50 // Subject to Subject communication
     3) write HObj LObj 50 // Object to Object communication
     4) write HObj Hal 50 //  Object to Subject communication
      
    The 5th through 8th test case cover the validity of read instructions 
     5) read Sun HObj // for invalid Subject and Object names
        read Hal Sun  // for invalid Subject and Object names
     6) read Hal Lyle // Subject to Subject communication
        read Lyle Hal  // Subject to Subject communication
     7) read HObj LObj // Object to Object communication
     8) read HObj Hal //  Object to Subject communication
     
     
     The Sample Input we used to test these cases is:
     
      write Hal HObj
      read Hal
      write Lyle LObj 10
      read Hal LObj
      write Lyle HObj 20
      write Hal LObj 200
      read Hal HObj
      read Lyle LObj
      read Lyle HObj
      foo Lyle LObj
      Hi Lyle,This is Hal
      The missile launch code is 1234567
      
      ///////TEST CASES /////////
      write Sun HObj 50
      write Hal Sun  50
      write Hal Lyle 50
      write Lyle Hal 50
      write HObj LObj 50
      write HObj Hal 50
      read Sun HObj
      read Hal Sun
      read Hal Lyle
      read Lyle Hal
      read HObj LObj
      read HObj Hal
      
      
      The output is :
        Bad Instructions
        The current state is:
        LObj has value 0
        HObj has value 0
        Lyle has recently read 0
        Hal has recently read 0
         
        Bad Instructions
        The current state is:
        LObj has value 0
        HObj has value 0
        Lyle has recently read 0
        Hal has recently read 0
         
        Lyle writes value  10 to LObj
        The current state is:
        LObj has value 10
        HObj has value 0
        Lyle has recently read 0
        Hal has recently read 0
         
        Hal reads LObj
        The current state is:
        LObj has value 10
        HObj has value 0
        Lyle has recently read 0
        Hal has recently read 10
         
        Lyle writes value  20 to HObj
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 10
         
        Hal writes value  200 to LObj
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 10
         
        Hal reads HObj
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Lyle reads LObj
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 10
        Hal has recently read 20
         
        Lyle reads HObj
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions 
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions      
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
         
        Bad Instructions
        The current state is:
        LObj has value 10
        HObj has value 20
        Lyle has recently read 0
        Hal has recently read 20
    


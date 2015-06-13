import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SecureSystem {

	
	 public static void main(String[] args) {
	       ReferenceMonitor refMon = new ReferenceMonitor();
	       SecurityLevel securityLevel = new SecurityLevel();
	       
	      refMon.addSubject(new Subject("Lyle"), securityLevel.getLow());
	      refMon.addSubject(new Subject("Hal"), securityLevel.getHigh());
	       
	      refMon.addObjects(new Objct("LObj"), securityLevel.getLow());
	      refMon.addObjects(new Objct("HObj"), securityLevel.getHigh());
	      
	       if(args[0] != null)
	    	   OpenFile(args[0], refMon);
	       else 
	    	   System.exit(1);
	       
	       
	    }
	 
	 
	 
	 public static void OpenFile(String arg, ReferenceMonitor refMon){
		 // The name of the file to open.
	        String fileName = "/u/dgza88/CS361/Security/src/" + arg;

	        // This will reference one line at a time
	        String line = null;

	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	               // System.out.println(line);
	                InstructionObject instObj = new InstructionObject(line);
	                refMon.instruction(instObj);
	                if( refMon.isValid()){
	                		
	                	if((refMon.getInst().getCommand()).toLowerCase().equals("read")){
	                		System.out.println(refMon.getInst().getSubject() + " reads " + refMon.getInst().getObject() );
	                		
	                	}
	                	if (refMon.getInst().getCommand().toLowerCase().equals("write")){
	                		System.out.println(refMon.getInst().getSubject() + " writes value  " + refMon.getInst().getValue()  + " to " + refMon.getInst().getObject() );
	                		}
	                	}
	                
	                else refMon.bad();
	                
	                System.out.println("The current state is:");
	                refMon.printState();
	        
	            }    

	            // Always close files.
	            bufferedReader.close();            
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                   
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	    }
	 }


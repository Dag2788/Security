
public class InstructionObject {

	private String command;
	private String subject;
	private String object;
	private String value;
	
	
	public InstructionObject (String command){
		//parse command store the 3 variables
		String delims = "[ ]+";
		String[] tokens = command.split(delims);
		if( tokens.length >= 3 && tokens.length <= 4){
		this.command = tokens[0];
		this.subject = tokens[1];
		this.object = tokens[2];
		
		if(tokens.length == 4){
			this.value = tokens[3];
		}
		}
		
	}


	public String getCommand() {
		if(command != null)
			return command;
		else
			return "bad";
	}


	public void setCommand(String command) {
		this.command = command;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getObject() {
		return object;
	}


	public void setObject(String object) {
		this.object = object;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	

	
	
}

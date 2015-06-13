
public class SecurityLevel {

	private static final int HIGH =1;
	private static final int LOW = 0;
	
	public SecurityLevel(){
		
	}
	
	public static int getHigh() {
		return HIGH;
	}

	public static int getLow() {
		return LOW;
	}

	public boolean dominatesRead(Subject subject, Objct object){
		if(subject.getLEVEL() >= object.getLEVEL()){
			return true;
		}
		return false;
	}
	
	public boolean dominatesWrite(Subject subject, Objct object){
		if(subject.getLEVEL() <= object.getLEVEL()){
			return true;
		}
		return false;
	}
}


public class ObjectManager {

	public ObjectManager(){
		
	}
	
	public int write(Subject subject, Objct object, int value){
		if(object != null && subject != null){
			object.setValue(value);
			return 1;
		}
		else
			return 0;
	}
	
	public int read(Subject subject, Objct object){
		if(object != null && subject != null){
			subject.setTemp(object.getValue());
			return 1;
		}
		else
			return 0;
	}
}

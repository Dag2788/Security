import java.util.*;


public class ReferenceMonitor {

	private Map<String, Subject> Subjects ;
	private Map<String, Objct> Objects;
	private ObjectManager ObjMan;
	private InstructionObject inst;
	private ArrayList<Subject> subs ;
	private ArrayList<Objct> obs ;

	
	public ReferenceMonitor(){
		this.ObjMan = new ObjectManager();
		 Subjects  = new HashMap<String, Subject>();
		Objects = new HashMap<String, Objct>();
		 subs  = new ArrayList<Subject>();
		 obs  = new ArrayList<Objct>();
	}
	
	public void instruction(InstructionObject inst){
		this.inst = inst;
	}
	
	
	public int getLevel(Subject subject){
		return (Subjects.get(inst.getSubject())).getLEVEL();
		
	}
	
	public int getLevel(Objct object){
		return (Objects.get(inst.getObject())).getLEVEL();
	}
	
	public void addSubject(Subject subject, int level){
		Subjects.put(subject.getName(), subject);
		subs.add(subject);
		subject.setLEVEL(level);
	}
	
	public Subject getSubject(String subject){
		return Subjects.get(subject);
	}
	
	public Objct getObject(String object){
		return Objects.get(object);
	}
	
	public void addObjects(Objct object, int level){
		Objects.put(object.getName(), object);
		obs.add(object);
		object.setLEVEL(level);
	}
	
	public boolean isValid(){
		String command = inst.getCommand().toLowerCase();
		if(command.equals("read")){
			//subject dominates object
			if(Subjects.get(inst.getSubject()).getLEVEL() >= Objects.get(inst.getObject()).getLEVEL() ){
				ObjMan.read(Subjects.get(inst.getSubject()), Objects.get(inst.getObject()));
				return true;
			}
			else{
				Subjects.get(inst.getSubject()).setTemp(0);
			return true;
			}
		}
		
		else if(command.equals("write")){
			//object dominates subject
			if(inst.getValue() == null)
				return false;
			if(Subjects.get(inst.getSubject()).getLEVEL() <= Objects.get(inst.getObject()).getLEVEL()  ){
				int foo = Integer.parseInt(inst.getValue());
				ObjMan.write(Subjects.get(inst.getSubject()), Objects.get(inst.getObject()), foo);
				return true;
			}
			else
				return true;
		}
		
			return false;
		
	}
	
	public InstructionObject getInst() {
		return inst;
	}

	public void setInst(InstructionObject inst) {
		this.inst = inst;
	}

	public BadInstruction bad(){
		return new BadInstruction();
	}
	
	public int getSubjectSize(){
		return Subjects.size();
	}
	
	
	public int getObjctSize(){
		return Objects.size();
	}
	
	public void printState(){
       
        for( Objct x : obs){
        	 System.out.println(x.getName() + " has value " + x.getValue());
        }
        for( Subject x : subs){
       	 System.out.println(x.getName() + " has recently read " + x.getTemp());
       }
        
        System.out.println(" ");
	}
}

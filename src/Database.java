import java.util.ArrayList;


public class Database {
	ArrayList<Field> myDatabase;
	public Database(){
		myDatabase = new ArrayList<Field>();
	}
	
	public ArrayList<Field> GetAllFields(){
		return myDatabase;
	}
	
	public void SetField(Field field){
		myDatabase.add(field);
	}
}

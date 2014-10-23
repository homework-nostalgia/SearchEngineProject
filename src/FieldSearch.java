import java.util.*;


final class FieldSearch {
	
	public FieldSearch(){	
	}
	
	public static ArrayList<Field> Find(Database database, String word){
		ArrayList<Field> fields = database.GetAllFields();
		ArrayList<Field> returnfields = new ArrayList<Field>();
		for ( Field field : fields){
			if (field.word == word){
				returnfields.add(field);
			}
		}
		return returnfields;
	}	
}
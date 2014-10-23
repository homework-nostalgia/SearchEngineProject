import java.util.ArrayList;


final class FieldSearch {
	
	private FieldSearch(){	
	}
	
	public static ArrayList<Field> Find(Database database, String word){
		ArrayList<Field> fields = database.GetAllFields();
		ArrayList<Field> returnfields = new ArrayList<Field>();
		Boolean foundflag;
		for ( Field field : fields){
			foundflag = false;
			if (field.word == word){
				for ( Field checkfield : returnfields){
					if (checkfield.fileName != null){
						if (field.fileName == checkfield.fileName){
							foundflag = true;
							break;
						}
					}
					if (foundflag == false){
						returnfields.add(field);
					}		
				}
			}
		}
		return returnfields;
	}	
}
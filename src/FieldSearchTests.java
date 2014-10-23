import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;


public class FieldSearchTests{
	
	Database db = new Database();
	
	public FieldSearchTests(){
		Field field1 = new Field("theartofwar.txt", "peace");
		Field field2 = new Field("theartofwar.txt", "love");
		Field field3 = new Field("twilight.txt", "badwriting");
		Field field4 = new Field("twilight.txt", "love");
		db.SetField(field1);
		db.SetField(field2);
		db.SetField(field3);
		db.SetField(field4);
	}
	
	@Test
	public void TestFind() throws Exception{
		
		ArrayList<Field> foundlist = new ArrayList<Field>();
		foundlist = FieldSearch.Find(db,"peace");
		assertEquals(foundlist.size(),1);
		assertEquals(foundlist.get(0).fileName,"theartofwar.txt");
		
		foundlist = FieldSearch.Find(db,"love");
		assertEquals(foundlist.size(),2);
		assertEquals(foundlist.get(0).fileName,"theartofwar.txt");
		assertEquals(foundlist.get(1).fileName,"twilight.txt");
		
		foundlist = FieldSearch.Find(db,"lightsaber");
		assertEquals(foundlist.size(),0);
	}
	
	
}
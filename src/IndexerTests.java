import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.junit.Test;


public class IndexerTests {
	Database DB = new Database();
	File file = new File("HelloHarry.txt");
	
	public IndexerTests() throws Exception{
		FillFile();
	}
	@Test
	public void TestIndexLines() throws Exception{
		
		Indexer myIndexer = new Indexer("HelloHarry.txt",DB);
		myIndexer.IndexLines();
		ArrayList<Field> expected = new ArrayList<Field>();
		expected.add(new Field("HelloHarry.txt", "HelloHarry"));
		expected.add(new Field("HelloHarry.txt", "Ickle"));
		expected.add(new Field("HelloHarry.txt", "diddykins"));
		expected.add(new Field("HelloHarry.txt", "Aragog"));
		expected.add(new Field("HelloHarry.txt", "Yer"));
		expected.add(new Field("HelloHarry.txt", "a"));
		expected.add(new Field("HelloHarry.txt", "wizard"));
		expected.add(new Field("HelloHarry.txt", "Harry"));
		ArrayList<Field> actual = DB.GetAllFields();
		for(int i = 0; i < expected.size();i++){
			assertEquals("fileNames match",expected.get(i).fileName, actual.get(i).fileName);
			assertEquals("words match",expected.get(i).word, actual.get(i).word);
		}
	}
	public void FillFile() throws Exception{

	      file.createNewFile();

	      FileWriter writer = new FileWriter(file); 

	      writer.write("HelloHarry Ickle diddykins\nAragog Yer a wizard Harry"); 
	      writer.flush();
	      writer.close();
	}
}

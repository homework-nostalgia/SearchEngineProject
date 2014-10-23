import java.io.*;


public class Indexer {
	String fileName;
	FileReader fileReader;
	BufferedReader bufferReader;
	Database database;
	public Indexer (String filename, Database database) throws Exception{
		this.fileName = filename;
		this.fileReader = new FileReader(fileName);
		this.bufferReader = new BufferedReader(fileReader);
		this.database = database;
	}
	public void IndexLines(String line) throws Exception{
		String[] words = line.split("\\s+");
		
		if (words[0].length() == 0) return;
		String fieldName = words[0];
		for (int i=1; i<words.length; i++){
			Field field = new Field( fieldName,words[i]);
			database.SetField(field);
		}
	}
	public void IndexLines() throws Exception{
		String line = null;
		line = bufferReader.readLine();
		while(true){
			if(line==null) break;
			IndexLines(line);
			line = bufferReader.readLine();
		}
	}
}

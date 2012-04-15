import java.util.*;
import java.io.*;

public class CreateData {
	
	// Words created with
	// gawk '{ if (length($1) > 4) print tolower($1) }' invisible-man.txt | sort | uniq | grep -v "[,;\)\(\*\!'\.\:\"\?\-\-]"

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("words.txt"));
		ArrayList<String> words = new ArrayList<String>();
		String inputLine;
		while( (inputLine = in.readLine()) != null)
			words.add(inputLine);
		in.close();
		int size = words.size();
		
		PrintWriter out = new PrintWriter(new FileWriter("dataset.txt"));
		for(long i = 0; i < 100000000L; i++) {
			out.println(i + "," +  (long)(10000.0*Math.random()) + "," + (long)(10000*Math.random()) + "," + words.get((int)(Math.random() * size)));
		}
		out.close();
	}
}

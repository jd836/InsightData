import java.io.*;
import java.util.*;

/**
 * The program of word count.
 * The largest text file can be processed is about 2GB
 * Author: Jiabin Dong
 */
//Time complexity---O(nlogn)
public class WordCountMain {

	public static void main(String[] args) {
		try{
			//Read input file
			String pathname = "../wc_input/wc_input.txt";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			String article = "";
			do{
				line = br.readLine();
				if(line != null && (!line.equals("")))
					article += line;
			}while(line != null);
			
			//Call word count algorithm
			List<WordCount> result = WordCountService.getWordCount(article);
			
			//Write into output file
			File writename = new File("../wc_output/wc_result.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for(WordCount res: result){
				out.write(res.getWord() + "\t" + res.getCount() + "\n");
				out.flush();
			}
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

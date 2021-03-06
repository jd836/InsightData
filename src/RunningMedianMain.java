import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Find the medians of stream:
 * Use two heaps.
 * Can read less than 2^30 files. 
 * Though no limit on the size of file, but this can only process files with less than 2^30 words per line.
 * Author: Jiabin Dong
 */
public class RunningMedianMain {

	public static void main(String[] args) {
		String directory = "../wc_input";
		String outName = "../wc_output/med_result.txt";
		File dir = new File(directory);
		File[] files = dir.listFiles();
		RunningMedian runningMedian=new RunningMedian();
		
		//Sort the files in alphabetical order
		Arrays.sort(files, new Comparator<File>(){
			public int compare(File f1, File f2){
				String s1 = f1.getName();
				String s2 = f2.getName();
				s1 = s1.substring(0, s1.indexOf('.'));
				s2 = s2.substring(0, s2.indexOf('.'));
				return s1.compareTo(s2);
			}
		});
		
		//Create new file for output
		//Write into output file
		try{
			File writename = new File(outName);
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//If the total number of file less than Integer.MAX_VALUE
		for(int i = 0; i < files.length; i++){
			try{
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(files[i]));
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				do{ 
					line = br.readLine();
					//Only process lines with content
					if(line != null && (!line.equals(""))){
						double median = 0;
						DecimalFormat df = new DecimalFormat("#.0");
						String[] words = line.split(" ");
						int number = words.length;
						
						//Get the median
						median = runningMedian.getMedian(number);
						
						writeToFile(outName, df.format(median));
					}
				}while(line != null);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Write into files 
	 * @param filename
	 * @param content
	 */
	public static void writeToFile(String filename, String content){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
										new FileOutputStream(filename, true)));
			out.write(content + "\n");
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

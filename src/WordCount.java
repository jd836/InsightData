/** Word count class, including word content and count */
public class WordCount{
	private String word;
	private int count;
	
	//Get the word count
	public int getCount(){
		return count;
	}
	
	//Set the word count
	public void setCount(int count){
		this.count = count;
	}
	
	//Get the content of word
	public String getWord(){
		return word;
	}
	
	//Set the content of word
	public void setWord(String word){
		this.word = word;
	}
}


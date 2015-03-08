import java.util.*;
/** Implement the word count algorithm*/
public class WordCountService {
	
	/**
	 * Generate word tree
	 * @param text
	 * @return
	 */
	private static CharTreeNode geneCharTree(String text){
		CharTreeNode root = new CharTreeNode();
		CharTreeNode p = root;
		char c = ' ';
		for(int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			if(c >= 'A' && c <= 'Z')
				c = (char)(c + 'a' - 'A');
			if(c >= 'a' && c <= 'z'){
				if(p.children[c - 'a'] == null)
					p.children[c - 'a'] = new CharTreeNode();
				p = p.children[c - 'a'];
			}
			else{
				p.cnt++;
				p = root;
			}
		}
		if(c >= 'a' && c<= 'z')
			p.cnt++;
		return root;
	}
	
	/**
	 * Use DFS and put word in the corresponding set
	 * @param result
	 * @param p
	 * @param buffer
	 * @param length
	 */
	private static void getWordCountFromCharTree(List<WordCount> result, CharTreeNode p, char[] buffer, int length){
		for(int i = 0; i < 26; i++){
			if(p.children[i] != null){
				buffer[length] = (char)(i + 'a');
				if(p.children[i].cnt > 0){
					WordCount wc = new WordCount();
					wc.setCount(p.children[i].cnt);
					wc.setWord(String.valueOf(buffer, 0, length + 1));
					result.add(wc);
				}
				getWordCountFromCharTree(result, p.children[i], buffer, length + 1);
			}
		}
	}
	
	private static void getWordCountFromCharTree(List<WordCount> result, CharTreeNode p){
		getWordCountFromCharTree(result, p, new char[100], 0);
	}
	
	/**
	 * get the word count from tree
	 * @param article
	 * @return
	 */  
	public static List<WordCount> getWordCount(String article){
		CharTreeNode root = geneCharTree(article);
		List<WordCount> result = new LinkedList<WordCount>();
		getWordCountFromCharTree(result, root);
		return result;
	}
	
}

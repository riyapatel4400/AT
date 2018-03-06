package ArrayList;

public class WordTally implements Comparable<WordTally>{

	int count=0;
	String word;
	
	public WordTally(String w){
		count=1;
		word=w;
	}
	
	public int getCount(){
		return count;
	}
	
	public void add(){
		count++;
	}
	
	public String getWord(){
		return word;
	}
	
	public String toString(){
		return word+" \t "+count;
	}

	@Override
	public int compareTo(WordTally word) {
	int num = word.getCount();
	return num-count;
	}
}

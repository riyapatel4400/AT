package ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CountWords {
	private static ArrayList<WordTally> words;
	private final String FILE_NAME = "dream.txt";
	private static int sum=1;

	public CountWords(){
		words = new ArrayList<WordTally>();
		File file = new File(FILE_NAME);

		try {
			@SuppressWarnings("resource")
			Scanner inFile = new Scanner (file);
			while (inFile.hasNext()){
				String temp = inFile.next();
				temp=temp.toLowerCase();
				temp = temp.replaceAll("[^A-Za-z0-9]", "");
				if (temp.length()>0)
					sum++;
				insert(temp);
			}	
		}
		catch (FileNotFoundException e){
			System.out.println(("FILE NOT FOUND"));
			e.printStackTrace();
		}
	}

	public static void insert(String t){
		int num =0;
		if (words.size()==0){
			WordTally s = new WordTally(t);
			words.add(s);
		}
		else{
			for (int i= 0; i<words.size(); i++){
				if (words.get(i).getWord().equalsIgnoreCase(t)){
					words.get(i).add();
					num=1;
				}
			}
			if (num==0){
				WordTally s = new WordTally(t);
				words.add(s);
			}
		}
	}

	public void display(){
		for (WordTally x: words){
			System.out.println(x.getWord() + " \t "+ x.getCount());
		}
	}

	public int size(){
		return words.size();
	}

	public int sum(){
		return sum;
	}

	public void sort(){
		Collections.sort(words);
	}
	
	public static void main (String [] args){
		CountWords a = new CountWords();
		System.out.println("TOTAL WORDS: "+a.sum());
		System.out.println("UNIQUE WORDS: "+ a.size());
		a.sort();
		System.out.println("WORD \t TALLY");
		System.out.println("__________________________");
		a.display();

	}
}

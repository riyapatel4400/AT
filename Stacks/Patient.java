package Stacks;

public class Patient {

	int prior;
	String name;
	
	public Patient(String n, int p){
		name = n;
		prior=p;
	}
	
	public void setName(String n){
		name = n;
	}
	public void setPriority(int p){
		prior = p;
	}
	
	public String getName(){
		return name;
	}
	public int getPriority(){
		return prior;
	}
	
	public String toString(){
		return name +" \t  Priority: " + prior;
	}
}

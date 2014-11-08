package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Editor {
	BufferedReader getTextInput = new BufferedReader(new InputStreamReader(System.in));
	Scanner getCommand = new Scanner(System.in);
	LinkedList list = new LinkedList();
	public Editor() throws IOException{
		getInput();
	}
	
	public void insert() throws IOException{
		String line = getTextInput.readLine();
		StringTokenizer analize = new StringTokenizer(line);
		if(!(analize.nextToken().equalsIgnoreCase("$"))){
			list.add(line);
			insert();
		}
	}
	
	public void delete(){
		int start = getCommand.nextInt();
		int end = getCommand.nextInt();
		if(list.isEmpty()){
			System.out.println("There is nothing to delete. The file is empty.");
		}else{
			for(int i = start; i <= end; i++){
				list.remove(i);
			}
		}
	}
	
	public void print(int start, int end){
		if(list.isEmpty()){
			System.out.println("You do not have any text in the file.");
		}else{
			for(int i = start; i <= end; i ++){
				System.out.println(i + " "+ list.getIndex(i));
				/*if(list.getIndex(i).next == null){
					System.out.println("No Such Element!");
					break;
				}*/
			}
		}
	}
	
	public void printAll(){
		for(int i = 0; i < list.getSize(); i ++){
			System.out.println(i + " "+ list.getIndex(i));
		}
	}
	
	public void line(){
		System.out.println("LINE");
	}
	
	public void getInput() throws IOException{
		int start = 0;
		int end = 0;
		System.out.println("Enter a line or command");
		String token = getCommand.next();
		if(token.equalsIgnoreCase("$insert")){
			insert();
			getInput();
		}
		else if(token.equalsIgnoreCase("$delete")){
			delete();
			getInput();
		}
		else if(token.equalsIgnoreCase("$print")){
			try{
				start = getCommand.nextInt();
				end = getCommand.nextInt();
				print(start, end);
				getInput();
			}catch(Exception e){
				System.out.println("You did not enter a start and end value to print. All text will be printed");
				printAll();
				getInput();
			}
		}
		else if(token.equalsIgnoreCase("$line")){
			line();
			getInput();
		}
		else if(token.equalsIgnoreCase("$printAll")){
			printAll();
			getInput();
		}
		else{
			System.out.println("Incorrect command.");
			getInput();
		}
	}

	public static void main(String[] args) throws IOException {
		new Editor();
	}

}

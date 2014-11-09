package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Editor {
	BufferedReader getTextInput = new BufferedReader(new InputStreamReader(System.in));
	Scanner getCommand;
	LinkedList list = new LinkedList();
	public Editor() throws IOException{
		getInput();
	}
	
	public void insert() throws IOException{
		String line = getTextInput.readLine();
		StringTokenizer analize = new StringTokenizer(line);
		if(!(analize.nextToken().equalsIgnoreCase("$"))){
			list.add(line);
			System.out.println("Enter another line of text or enter $ to exit insert mode.");
			insert();
		}
	}
	
	public void delete(int start, int end) throws IOException{
		for(int i = start; i <= end; i ++){
			System.out.println("Removed line: " + i +": "+list.getIndex(i));
			list.remove(i);
		}
		getInput();
	}
	
	public void print(int start, int end){
		if(list.isEmpty()){
			System.out.println("You do not have any text in the file.");
		}else{
			for(int i = start; i <= end; i ++){
				System.out.println(i + " "+ list.getIndex(i));
			}
		}
	}
	
	public void printAll(){
		if(!list.isEmpty()){
			for(int i = 0; i < list.getSize(); i ++){
				System.out.println(i + " "+ list.getIndex(i));
			}
		}else{
			System.out.println("The file is empty.");
		}
	}
	
	public void line(int lineNum) throws IOException{
		System.out.println(list.getIndex(lineNum - 1));
		System.out.println(list.getIndex(lineNum));
		System.out.println(list.getIndex(lineNum + 1));
		getInput();
	}
	
	public void search(String searchToken) throws IOException{
		Link stringToken = list.hasString(searchToken);
		if(stringToken == null){
			System.out.println("There is no match for '"+searchToken+"'");
			getInput();
		}else{
		    System.out.println(stringToken.index + ": "+ stringToken);
		    getInput();
		}
	}
	
	public void help() throws IOException{
		System.out.println("Always start entering a command by the $ symbol. Example: $insert");
		System.out.println("List of commands are: insert, delete, search, print, line, and done.");
		getInput();
	}
	
	public void exit(){
		System.out.println("Thank you for using the editor!");
		System.exit(1);
	}
	public void getInput() throws IOException{
		getCommand = new Scanner(System.in);
		int start = 0;
		int end = 0;
		System.out.println("Enter a line or command >");
		String token = getCommand.next();
		if(token.equalsIgnoreCase("$insert")){
			insert();
			getInput();
		}
		else if(token.equalsIgnoreCase("$delete")){
			try{
				start = getCommand.nextInt();
				end = getCommand.nextInt();
				if(list.isEmpty()){
					System.out.println("The file is empty");
					getInput();
				}
				else{
					if(end < start){
						System.out.println("Sorry, start index cannot be greater than ending index. Example: $delete 5 4 is incorrect. Proper usage is $delete 4 5");
						getInput();
					}else if(end > list.getSize()){
						System.out.println("You entered "+end+" which is greater than the size of the file. Please use command $printAll to see the contents of the file and get the line number");
						getInput();
					}
					else{
						delete(start, end);
					}
				}
				
			}catch(Exception e){
				System.out.println(e);
				getInput();
			}
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
			try{
				int lineNum = getCommand.nextInt();
				
				if(lineNum > list.getSize() && (!list.isEmpty())){
					System.out.println("This number is greater than the lenght of the file. The file size is "+ list.getSize());
					getInput();
				}else if(list.isEmpty()){
					System.out.println("The file is empty!");
					getInput();
				}else{
					line(lineNum);
				}
			}catch(InputMismatchException e){
				System.out.println("You must enter a proper line number");
				getInput();
			}
		}
		else if(token.equalsIgnoreCase("$printAll")){
			printAll();
			getInput();
		}
		else if(token.equalsIgnoreCase("$help")){
			help();
		}
		
		else if(token.equalsIgnoreCase("$done") || token.equalsIgnoreCase("$exit")){
			exit();
		}
		else if(token.equalsIgnoreCase("$search")){
			try{
				String searchToken = getCommand.next();
				if(list.isEmpty()){
					System.out.println("The file is empty!");
					getInput();
				}
				else{
					search(searchToken);
				}
				
			}catch(Exception e){
				System.out.println(e);
				getInput();
			}
		}
		else{
			System.out.println("Incorrect command");
			getInput();
		}
	}

	public static void main(String[] args) throws IOException {
		new Editor();
	}

}

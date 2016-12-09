import java.io.*;
import java.util.*;
public class problem3{
	private static String filename = "data.txt";
	private static ArrayList<String> stringsInData = new ArrayList<String>();
	private static ArrayList<Integer> numStringsInData = new ArrayList<Integer>();


	static void readFile(){
          try  {
                
                Scanner scan = new Scanner(new File(filename));//pull new file in
                scan.useDelimiter("[\\p{Blank}\\p{Punct}\\p{Space}]");//words are strings (ignoring case) that have spaces between them, excluding punctuation, tabs, newlines etc.
                while ((scan.hasNext()))
                {
                        String input = scan.next().toLowerCase();
                        if(input.length()<1){//don't need to add an empty string - this would occur with double spaces
                        	continue;//skip this word
                        }
                        int index = stringsInData.indexOf(input);
                        if(index==-1){//If the string is not already counted
                        	stringsInData.add(input);//add the string to the end of list
                        	numStringsInData.add(1);//there is one instance of it, so add a '1' to the end of list
                        }
                        else{
                        	numStringsInData.set(index, numStringsInData.get(index)+1);//already exists, just increment
                        }
                }
          }
          catch (IOException e)  {
                System.out.println(e.getMessage());
          }


	}

	static void results(){
		for(int i=0; i<stringsInData.size();i++){
			System.out.print("The word \""+stringsInData.get(i)+"\" occured "+numStringsInData.get(i)+" time(s).\n");
		}

	}

	public static void main (String[] args){

		readFile();
		System.out.println("Results: ");
		results();

	}

}
package com;

import java.util.Arrays;
import java.util.Scanner;

//	Main Class implementing Anagrams
public class Anagrams {
	
	//	Logic Implementation of Anagrams
	public void getAnagrams(String [] input){
		String [] userInputArray = input;																	//	Creating Local copy of User input of comma separated value
		String [] loopingArray = new String [input.length];													//	Creating String array for looping 
		String output = "";																					//	Will have Final output required
		
		Arrays.sort(userInputArray);																		//	Sorting the User input words
		
		for(int i=0; i<userInputArray.length; i++){															//	Loop to Sort the letters in the above sorted words array
			String wholeWord = "";
			String [] word = new String [userInputArray[i].length()];
			word = userInputArray[i].split("");
			Arrays.sort(word);																				//	Sorting the characters in the word
			for(String s : word) {
				wholeWord = wholeWord.concat(s);
			}
			loopingArray[i] = wholeWord;																	//	Populating the looping array with sorted words and its letters
		}
		
		for(int i=0; i<loopingArray.length; i++){										//	Loop for to find similar words and getting its original word from its position in the userInput Array
			String finalLoopOutput = "";
			String checkWord = loopingArray[i];																//	assigns current word in the loop
			String [] loopOutput = new String [loopingArray.length];										//	this array used to store the similar words
			int position = 0;
			for(int j=0; j<loopingArray.length; j++){														//	Loop to check the same word as the current word in the loop
				if(!(loopingArray[j].isEmpty()) && loopingArray[j] != null && checkWord.equalsIgnoreCase(loopingArray[j])){	
					loopOutput[position] = userInputArray[j];												//	If found storing the original word main array
					position++;
					loopingArray[j] = "";
				}
			}
			if(position > 1) {																				//	Condition to check the anagram of the word
				for(String s : loopOutput){																	//	If exists the loopOut is iterated and formating it display
					if(s != null && !(s.isEmpty())){
						finalLoopOutput = finalLoopOutput.concat(s).concat(",");
					}
				}
				output = output + "{" + finalLoopOutput.substring(0, finalLoopOutput.length()-1) + "}" ;	//	Formating to the final Output
			}
		}
		
		System.out.println("Output : " + output);															//	Displaying the final Output
	}
	
	//	Main Method
	public static void main(String [] args){
		Anagrams anagrams = new Anagrams();																	//	Object of the main class
		
		Scanner userInput = new Scanner(System.in);															//	Scanner to get the user input
		
		System.out.println("Enter a list of words saparated by comma");
		
		String [] input = userInput.nextLine().split(",");													//	Getting the user input separated by "," to use that as the delimiter to split
		
		anagrams.getAnagrams(input);																		//	To get the Anagram
		
		userInput.close();																					//	Closing the Scanner
	}
}

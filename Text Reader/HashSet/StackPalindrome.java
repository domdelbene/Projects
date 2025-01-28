package edu.monmouth.hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Stack;

public class StackPalindrome {

	public static void main(String[] args) {
		Properties properties = new Properties();
		
		if(args.length != HW4Constants.NUMBEROFSTACKARGUMENTS) {
			System.out.println("Enter name of props file");
			System.exit(HW4Constants.WRONGARGUMENTS);
		}
		String propsFileName = args[HW4Constants.STACKFILEINDEX];
		try {
			properties.load(new BufferedReader(new FileReader(propsFileName)));
		}
		catch(IOException e) {
			System.out.println("Cannot load " + propsFileName + " | " + e.getMessage());
			e.printStackTrace();
			System.exit(HW4Constants.READSTACKEXIT);
		}
		
		String fileNameValue = properties.getProperty(HW4Constants.LOGFILENAME);
		PrintStream newIO;
		
		try {
			newIO = new PrintStream(fileNameValue);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to " + fileNameValue);
			e.printStackTrace();
			System.exit(HW4Constants.FNFEXIT);
		}
		String word = properties.getProperty(HW4Constants.WORDS);
		String[] words = word.split(HW4Constants.DELIMITER);
		
		Stack<Character> palindrome = new Stack<>();
		int wordsIndex = 0;
		
		while(wordsIndex != words.length) {
			for(int i = 0; i < words[wordsIndex].length(); i++) {
				palindrome.push(words[wordsIndex].charAt(i));
			}
			StringBuilder build = new StringBuilder();
			for(int j = 0; j < words[wordsIndex].length(); j++) {
				build.append(palindrome.pop());
			}
			if(build.toString().equals(words[wordsIndex])) {
				System.out.println(words[wordsIndex] + " is a palindrome");
			}
			else {
				System.out.println(words[wordsIndex] + " is NOT a palindrome");
			}
			wordsIndex++;
		}
		System.exit(HW4Constants.OUTPUTEXIT);

	}

}

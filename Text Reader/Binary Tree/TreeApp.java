package edu.monmouth.tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class TreeApp {
	
	public static void main(String[] args) {
		// verify there is 1 and only 1 command line argument
		if(args.length != HW5Constants.NUMBEROFARGUMENTS) {
			System.err.println("Enter name of props file");
			System.exit(HW5Constants.WRONGARGUMENTS);
		}
       
		// load the properties file using command line argument
		Properties properties = new Properties();
		
		String propsFileName = args[HW5Constants.PROPSINDEX];
		try {
			properties.load(new BufferedReader(new FileReader(propsFileName)));
		}
		catch(IOException e) {
			System.out.println("Cannot load " + propsFileName + " | " + e.getMessage());
			e.printStackTrace();
			System.exit(HW5Constants.PROPSEXIT);
		}
      
		// list all properties to System.out
		properties.list(System.out);
       
		// obtain the value of log_file_name property
		String logFileName = properties.getProperty(HW5Constants.LOGFILENAME);
            
		// redirect stdout & stderr to the value of log_file_name
		PrintStream newIO;
		try {
			newIO = new PrintStream(logFileName);
			System.setErr(newIO);
			System.setOut(newIO);
		}
		catch(FileNotFoundException e) {
			System.err.println("Cannot redirect to " + logFileName);
			e.printStackTrace();
			System.exit(HW5Constants.FNFEXIT);
		}
       
		// obtain the value of node_values property
		String nodeValue = properties.getProperty(HW5Constants.NODEVALUES);
		String[] nodeValues = nodeValue.split(HW5Constants.NODEDELIMITER);
	
		// create an instance of the Tree class
		Tree tree = new Tree();
		
		// verify min, max and find operate on an empty tree
		tree.min();
		tree.max();
		tree.find(10);
	
		// parse the key / value pairs of node_values and insert into tree
		for(int i = 0; i < nodeValues.length; i++) {
			String[] keyValue = nodeValues[i].split(HW5Constants.KEYVALUEDELIMITER);
			int key = Integer.parseInt(keyValue[HW5Constants.KEYINDEX]);
			double value = Double.parseDouble(keyValue[HW5Constants.VALUEINDEX]);
			tree.insert(key, value);
		}
	
      	// print out the keys using inorder
		tree.traverse(2);
      
		// determine if the value 12 is in the tree
		System.out.println("Find 12: " + tree.find(12));

		// determine if the value 80 is in the tree
		System.out.println("Find 80: " + tree.find(80));
     
		// print out the minimum value in the tree 
		System.out.println("Min: " + tree.min());

		// print out the maximum value in the tree    
		System.out.println("Max: " + tree.max());
      
		System.exit(HW5Constants.OUTPUTEXIT);
	} 
}  
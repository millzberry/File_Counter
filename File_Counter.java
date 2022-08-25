/**
 * 
 */

/**
 /* @author drabe
 *
 */

//import java.io.BufferedReader;
//import java.io.File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


//In this program, we will enter a path name to a sub-directory
// and will find the number of lines
// within a chosen file and size, and return the values

public class File_Counter {

	
	public int getFileLineCount (File fleFile) throws IOException  
		  //public method that returns variable of type int 
		  //and takes a parameter of type File
		    {
		   
		   
		   int count = 0; // counter
		   String line = "";
		   
		   //List<String> allLines = new ArrayList<String>();
		  		   
		   try {
				 
				
				BufferedReader br = new BufferedReader(new FileReader(fleFile));	 
					while ((line = br.readLine()) != null) //
					{
						//System.out.println(line);
						count ++;

					}
					
					br.close();
					
				} catch (FileNotFoundException e) {
				   
				   System.out.println("File not found");
			    }
		   
		   				        
				return count;
		    }
	
	public File getFileLineCount (String strDirectoryPath) throws IOException  
	  //method that accepts a directory path containing a set of file; 
	  //opens each file in the sub-directory, counts each line in the file, 
	  //and makes a new file listing the name of each processed file 
	  //and the total lines in each of the files processed.
	    {
	   
	   
	   int count = 0; // counter
	   String fileName = "new";
	   String fileType = ".txt";
	   String sub_dir = "C:\\Users\\drabe\\OneDrive\\Documents\\DummyFile\\";
	   String f_path = sub_dir+fileName+fileType; 
	   
	   File f = new File(f_path);   
	   //String path = "strDirectoryPath" + File.separator + "line_counts.txt";
	   
	   File d_path = new File(strDirectoryPath); //accepts the path of the sub-directory
	   
	  	   
	   //Declares the location of both the sub-directory and file location
	   if (!f.getParentFile().exists() && !f.exists()) { //Creates the file and sub-directory only if they don't exist
		   
		   f.getParentFile().mkdir();
		   f.createNewFile();
	   	}
	   		else if (f.exists()) { // else if tests if the file exists
		    		
	   			String new_path = "";
	   			
				do { // do-while loop will create new files that do not have the same name as a previously made file
					 // to avoid overwriting previous information recorded
					
		    		  ++count;
		    		   new_path = sub_dir+fileName+count+fileType; 
		    		  f = new File (new_path);
		    		  		     
		    	  } while (f.exists());
		    		  
	   		}
	   				
	   			 else {
	      
	   				throw new IOException("Failed to create directory " + f.getParent()); //Exception if directory was not successfully created
		   
	   				}
	   	
	   PrintWriter pw = new PrintWriter (f); //PrintWriter will write contents into the file
	   
	      File filesList[] = d_path.listFiles(); //List of all files and directories
	      File_Counter gflc = new File_Counter(); // Instantiates the File Counter class to utilize the line counter method
	      //Scanner sc = null;
	      
	      for(File file : filesList) { //Loop examines all files in sub-directory until there are none
	    	  
	    	     String fn = file.getName(); //Acquires name of file
	    	     pw.println("File name: " + fn); //Prints name to file
		    	 int lines = gflc.getFileLineCount(file); //Acquires number of lines in the file
		    	 pw.println("Line count:" + lines); // Prints line amount to file
		    	 double size = file.getTotalSpace(); //Acquires the total space a file takes
		    	 pw.println("Total size:" + size); //Prints size to file
		    	 pw.println("\n"); //for spacing purposes
		    	 
		    	} pw.close(); // Closes writer
		    	
	    	  
			return f;// returns file 
	    }

	   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String path = "C:\\Users\\drabe\\OneDrive\\Documents\\EME 303 EXAMS\\exams\\exams\\exam_2"; //path name to sub-directory
		
	    File_Counter fc = new File_Counter(); //instantiates File Counter class
		
		File file = fc.getFileLineCount(path); //retrieves newly created file containing file name, lines, and byte size
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) { //reads the lines of the file
			   String line;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			}
		
		
		// 2-D array, open text file with information, create date/time stamp
   		// Hash Map, dumb data from data structure
   		
   		
   		
		/*
		 * System.out.print("Enter the path for the file: ");
			Scanner input = new Scanner (System.in);
		 * 
		 * String answer = "";
		
		
		do {
			
			File_Counter gf = new File_Counter();
			gf.getFile();
			
			System.out.print("Do you want to search another file? (Y/N)");
			Scanner recieve = new Scanner (System.in);
			answer = recieve.next();
						
		
			} while (answer.equalsIgnoreCase("Y"));
		
		    System.out.print("File Analyzer is now closing... ");
			System.exit(0); */
	}
			
		//If-Else Statement to verify if file was empty or not
		/*if (file.length() == 0) 
		{ 
			
			System.out.println("File is empty ..."); 
			
		} else 
		 { 
			System.out.println("File is not empty ..."); 
		 }*/

		
		
		 
			
		//List method utilized to read all the file lines into a list of string.   
		/*	try {
				 
				List<String> allLines = Files.readAllLines(Paths.get("C:/Users/drabe/OneDrive/Documents/Dummy Data/data_dummy.txt/"));
					 
					for (String line : allLines) //
					{
						System.out.println(line);
						//count ++;

					}
			} catch (FileNotFoundException e) {
				   
				   System.out.println("File not found");
			    }*/
			   
			
		
	}



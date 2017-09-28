package com.ali.java.jaFile ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection; 
import com.ali.java.jalo.Logger;

/**
 * Basic file helper class for reading and writing to files
 * @author aaronali
 *
 */
public class FileReader {
	
	 	 
	public FileReader(){ }
	 
	
	/** 
	 * Creates the file and returns true if successful. Will return false if the file already exists
	 * @param filename
	 * @return boolean  = file.exists();
	 */
	public static boolean CreateFile(String filename){
		File file = new File(filename);
		 try {
			if (file.createNewFile())
				 Logger.info(FileReader.class,"createFile()", "File is created!");
			 else
				 Logger.warning(FileReader.class, "createFile()","File already exists.");
		} catch (IOException e) {
			Logger.severe(FileReader.class, "createFile()",  "An error occured when trying to create ".concat(filename)  , e);
			Logger.error(FileReader.class, "createFile()",  "An error occured when trying to create ".concat(filename)  , e);

		} 
		 return file.exists();
	}
	
	
	
	/** 
	 * Creates the file and returns true if successful. Will return false if the file already exists
	 * @param filename
	 * @return boolean  = file.exists();
	 */
	public  boolean createFile(String filename){
		File file = new File(filename);
		 try {
			if (file.createNewFile())
				 Logger.info(FileReader.class,"createFile()", "File is created!");
			 else
				 Logger.warning(FileReader.class, "createFile()","File already exists.");
		} catch (IOException e) {
			Logger.severe(FileReader.class, "createFile()",  "An error occured when trying to create ".concat(filename)  , e);
			Logger.error(FileReader.class, "createFile()",  "An error occured when trying to create ".concat(filename)  , e);

		} 
		 return file.exists();
	}
	
	/***
	 * Appends text to the file
	 * @param filename
	 * @param text
	 */
	public static void AppendToFile(String filename, String text){
		BufferedWriter out = null;
		try { 
			out = new BufferedWriter(new FileWriter(filename, true)); 
			out.write(text);
			out.flush(); 
		} catch (IOException e) {
			 Logger.error(FileReader.class, "appendToFile()","Error writing to file".concat(filename) , e);
		} finally {
		
			if (out != null) {
				try {
					out.close()  ;
				} catch (IOException e) {		
					Logger.error(FileReader.class, "appendToFile()","Error closing BufferWriter for ".concat(filename) , e);				
					out=null;
				}
			}
			out=null;
		}
	}
 
	/***
	 * Appends text to the file
	 * @param filename
	 * @param text
	 */
	public  void appendToFile(String filename, String text){
		BufferedWriter out = null;
		try { 
			out = new BufferedWriter(new FileWriter(filename, true)); 
			out.write(text);
			out.flush(); 
		} catch (IOException e) {
			 Logger.error(FileReader.class, "appendToFile()","Error writing to file".concat(filename) , e);
		} finally {
		
			if (out != null) {
				try {
					out.close()  ;
				} catch (IOException e) {		
					Logger.error(FileReader.class, "appendToFile()","Error closing BufferWriter for ".concat(filename) , e);				
					out=null;
				}
			}
			out=null;
		}
	} 
	
	/**
	 * Reads a file and returns a String containing all the readable file contents or returns null
	 * @param filename
	 * @return 
	 * @return String of file contents
	 */
	public  static String ReadFile(String filename){
		String  result = new String(); 
		Path file = Paths.get(filename); 
		BufferedReader reader =null;
		try {
			InputStream in = Files.newInputStream(file); 
			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				result = result.concat(line).concat("\n"); 
			}
		} catch (IOException e) {
			Logger.error(FileReader.class,"readFile()","Error reading file" , e);
			result = null;
		}finally {
			if(reader!=null) {
				try {
					reader.close();
					reader=null; 
				}catch(IOException e) {
					Logger.error(FileReader.class,"readFile()","Error closing BufferReader for ".concat(filename) , e);
					reader =null;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Reads a file and returns a String containing all the readable file contents or returns null
	 * @param filename
	 * @return 
	 * @return String of file contents
	 */
	public  String readFile(String filename){
		String  result = new String(); 
		Path file = Paths.get(filename); 
		BufferedReader reader =null;
		try {
			InputStream in = Files.newInputStream(file); 
			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				result = result.concat(line).concat("\n"); 
			}
		} catch (IOException e) {
			Logger.error(FileReader.class,"readFile()","Error reading file" , e);
			result = null;
		}finally {
			if(reader!=null) {
				try {
					reader.close();
					reader=null; 
				}catch(IOException e) {
					Logger.error(FileReader.class,"readFile()","Error closing BufferReader for ".concat(filename) , e);
					reader =null;
				}
			}
		}
		return result;
	}
	
	
	
	/**
	 * Reads a url and returns it as a string or returns null
	 * @param contextUrl
	 * @return
	 */
	public static String ReadUrl(String contextUrl){
		URL url;
		String returnString = null;
		BufferedReader in = null;
		try {
			url = new URL(contextUrl); 
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine; 
			url=null; 
			while ((inputLine = in.readLine()) != null) {
				returnString =returnString.concat(inputLine); 
				inputLine=null;
			} 
			in.close(); 
			url=null;   
			in= null;
		} catch (IOException e) {
			Logger.error(FileReader.class,"readFile()","Error reading file" , e); 
		}finally {
			if(in!=null) {
				try {
					in.close();
					in=null; 
				}catch(IOException e) {
					Logger.error(FileReader.class,"readFile()","Error closing BufferReader for ".concat(contextUrl) , e);
					in =null;
				}
			}
		}
		return returnString;
	}

	/**
	 * Reads a url and returns it as a string or returns null
	 * @param contextUrl
	 * @return
	 */
	public  String readUrl(String contextUrl){
		URL url;
		String returnString = null;
		BufferedReader in = null;
		try {
			url = new URL(contextUrl); 
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine; 
			url=null; 
			while ((inputLine = in.readLine()) != null) {
				returnString =returnString.concat(inputLine); 
				inputLine=null;
			} 
			in.close(); 
			url=null;   
			in= null;
		} catch (IOException e) {
			Logger.error(FileReader.class,"readFile()","Error reading file" , e); 
		}finally {
			if(in!=null) {
				try {
					in.close();
					in=null; 
				}catch(IOException e) {
					Logger.error(FileReader.class,"readFile()","Error closing BufferReader for ".concat(contextUrl) , e);
					in =null;
				}
			}
		}
		return returnString;
	}
	/**
	 * Returns an array with a string collection of the current listing in the path or returns null 
	 * if there is an error
	 * @param path
	 * @return
	 */
	public static Collection<String> GetDirListing(String path){ 
		ArrayList<String> strings= new ArrayList<String>();
		Path dir =  Paths.get(path);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) { strings.add(file.getFileName().toString());  }
		} catch (IOException | DirectoryIteratorException e) {  
			Logger.error(FileReader.class,"getDirListing()","Error reading file" , e);  
			strings=null;
		}
		return strings; 
	}

	/**
	 * Returns an array with a string collection of the current listing in the path or returns null 
	 * if there is an error
	 * @param path
	 * @return
	 */
	public Collection<String> getDirListing(String path){ 
		ArrayList<String> strings= new ArrayList<String>();
		Path dir =  Paths.get(path);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) { strings.add(file.getFileName().toString());  }
		} catch (IOException | DirectoryIteratorException e) {  
			Logger.error(FileReader.class,"getDirListing()","Error reading file" , e);  
			strings=null;
		}
		return strings; 
	}
}

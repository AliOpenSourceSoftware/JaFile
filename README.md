## JaFile

A java file reading and writing utility project. 

### Create a new file

```boolean = fileReader.createFile(filename);```<br>
Returns true if the file exists 

### Append text to the file

```void = fileReader.appendToFile(fileName, text);```<br>
Returns null if there is an error
	 
### Read from file

```String = fileReader.readFile(String filename);```<br>
Returns a string instance of the file contents or returns null if there is an error
	 
### Get Directory listing
```Collection<String> = fileReader.getDirListing(path);```<br>
Returns a string collection of the current listing in the path or returns null if there is an error 

### Static methods
The above methods are available can be called statically using the below syntax


```boolean= FileReader.CreateFile(filename);<br>
void = FileReader.AppendToFile(fileName, text);<br> 
String = FileReader.ReadFile(String filename);<br> 
Collection<String> = FileReader.GetDirListing(path)
```

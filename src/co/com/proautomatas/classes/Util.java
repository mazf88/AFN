package co.com.proautomatas.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class responsible for the files to load the definition
 * of the automaton and perform tests.
 * @author mazapatafr
 */
public class Util {
    
    /**
     * Method responsible for locating the file definitions.txt with the definition of the automaton.
     * @return List<> Files
     * @throws java.io.IOException
     */
    public List<String> getFileWithDefinition() throws IOException{
        return Files.readAllLines(Paths.get("E://MAZF//NetBeansProjects//ProyectoDeAulaAutomatas//src//co//com//proautomatas//file//definitions.txt"));
        
    }
    
    /**
     * Method responsible for locating the file test.txt with the input for the test.
     * @return List<> Files
     * @throws java.io.IOException
     */
    public List<String> getFileWithTest() throws IOException{
        return Files.readAllLines(Paths.get("E://MAZF//NetBeansProjects//ProyectoDeAulaAutomatas//src//co//com//proautomatas//file//test.txt"));
        
    }
    
    /**
     * Method of locating the file resultMethodOne.txt
     * to write the output of the program according to the method one
     * @return List<> Files
     * @throws java.io.IOException
     */
    public FileWriter getFileForWriteResultMethodOne() throws IOException{
        return new FileWriter("E://MAZF//NetBeansProjects//ProyectoDeAulaAutomatas//src//co//com//proautomatas//file//resultMethodOne.txt");
        
    }
    
    /**
     * Method of locating the file resultMethodTwo.txt
     * to write the output of the program according to the method two
     * @return List<> Files
     * @throws java.io.IOException
     */
    public FileWriter getFileForWriteResultMethodTwo() throws IOException{
        return new FileWriter("E://MAZF//NetBeansProjects//ProyectoDeAulaAutomatas//src//co//com//proautomatas//file//resultMethodTwo.txt");
        
    }
}

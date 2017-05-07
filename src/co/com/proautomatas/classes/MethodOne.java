package co.com.proautomatas.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Class that has the two method, in which the output is a sequence of Q lines
 * each with a Yes or NO depending on if your query strings.
 * @author mazapatafr
 */
public class MethodOne {
    
    public void methodOne() throws IOException {
        
        Util util = new Util();
        //each line in the file that contains the definition of the automaton is obtained
        List<String> file = util.getFileWithDefinition();
        //you get each line of the file that contains the strings to be tested by the Automat
        List<String> test = util.getFileWithTest();
        
        HashMap<String,String> states = new HashMap<>();
        HashMap<String,String> words = new HashMap<>();
        HashMap<String,String> end = new HashMap<>();
        //transition matrix
        String[][] matrix = null;
        //Creates instance of AFD
        Afn automato = new Afn();
        
        try (FileWriter fileResponse = util.getFileForWriteResultMethodOne()) {
            PrintWriter response = new PrintWriter(fileResponse);
            
            for(int line = 0; line < file.size();line++){
                int i;
                
                if(line == 0){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        //System.out.println("add state: " + split[i]);
                        states.put(split[i],String.valueOf(i));
                    }
                }
                
                else if(line == 1){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        //System.out.println("add words: " + split[i]);
                        words.put(split[i],String.valueOf(i));
                    }
                    matrix = new String[states.size()][words.size()];
                }
                
                else if(line > 1 && line <file.size()-2){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        //System.out.println("Linha: "+(line-2)+ " coluna: "+i+" add: " +split[i]);
                        matrix[line-2][i] = split[i];
                    }
                }
                
                else if(line == file.size()-2){
                    automato.setNextState(file.get(line));
                    automato.setInitialSate(file.get(line));
                }
                
                else if(line == file.size()-1){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        //System.out.println("end words: " + split[i]);
                        end.put(split[i],String.valueOf(i));
                    }
                }
            }
            
            for(int line = 0; line < test.size();line++){
                String[] split = test.get(line).split(" ");
                for (String split1 : split) {
                    automato.setNextState(matrix[Integer.parseInt(states.get(automato.getNextState()))][Integer.parseInt(split1)]);
                    // System.out.println("Recebeu: "+split[i]+" Foi para: "+ automato.activeState);
                }
                if(end.get(automato.getNextState()) == null){
                    response.printf("Line "+(line+1)+": "+"NO%n");
                    System.out.println("NO");
                }
                else{
                    response.printf("Line "+(line+1)+": "+"SI%n");
                    System.out.println("SI");
                }
                automato.setNextState(automato.getInitialSate());
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}

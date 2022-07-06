import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class SlangWord {
	
	private Map<String, List<String>> slangWords = new LinkedHashMap<>();
	
//    private static final String DEFAULT_FILE_NAME = "slang.txt";
//    private static final String ORIGINAL_FILE_NAME = "original-slang.txt";
//    private static final String HISTORY_FILE_NAME = "history-slang.txt";
    private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String GRAVE_ACCENT_DELIMITER = "`";
	private static final String PIPE_DELIMITER = "|";
    
	/*
	 * Bill Pugh Singleton Implementation
	 */
	
	private SlangWord() {
		
	}
	
	private static class SingletonHelper {
		static final SlangWord INSTANCE = new SlangWord();
	}
	
	public static SlangWord getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public Map<String, List<String>> getData() {
		return slangWords;
	}
	
	public Boolean writeFile(String fileName) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            for (Entry<String, List<String>> entry : this.slangWords.entrySet()) {       
            	bw.append(entry.getKey()).append(GRAVE_ACCENT_DELIMITER); // add slang 
            	
            	// add definition
            	List<String> definitions = entry.getValue();
            	StringBuilder defnitionBuilder = new StringBuilder();
            	for(String definition : definitions) {
            		defnitionBuilder.append(definition).append(PIPE_DELIMITER);
				}
            	defnitionBuilder.deleteCharAt(defnitionBuilder.length() - 1);
            	defnitionBuilder.append(NEW_LINE_SEPARATOR);
            	bw.append(defnitionBuilder);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            bw.flush();
            bw.close();
        }
        return true;
    }

	public Boolean readFile(String fileName) throws IOException {
    	Path path = null;
        BufferedReader br = null;
        long startTime = System.currentTimeMillis();
        try {
        	path = Paths.get(fileName);
            br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            slangWords.clear();
            String csvLine;
            
            while ((csvLine = br.readLine()) != null) {
            	String[] data = csvLine.split(GRAVE_ACCENT_DELIMITER, -1);
            	slangWords.put(data[0], Arrays.stream(data[1].split("\\".concat(PIPE_DELIMITER), -1)).map(String::trim).collect(Collectors.toList()));
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            br.close();
        }
        
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds: " + timeElapsed);
        return true;
    }
	
	public Boolean isExists(String slang) {
		return slangWords.keySet().stream().anyMatch(s -> s.equals(slang));
	}
	
	public void add(String slang, String defnition, AddType addType) throws IOException {
		if (addType.equals(AddType.DUPLICATE)) {
			slangWords.get(slang).add(defnition);
		}
		writeFile("test.txt");
//		} else if (addType.equals(AddType.OVERRIDE)) {
////			slangWords.get(slang).clear()
//		}
	}
}

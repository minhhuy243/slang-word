import java.io.BufferedReader;
import java.io.BufferedWriter;
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


public class SlangWord {
	
	private Map<String, List<String>> slangWords = new LinkedHashMap<>();
	
//    private static final String DEFAULT_FILE_NAME = "slang.txt";
//    private static final String ORIGINAL_FILE_NAME = "original-slang.txt";
//    private static final String HISTORY_FILE_NAME = "history-slang.txt";
    private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String GRAVE_ACCENT_DELIMITER = "\\`";
	private static final String PIPE_DELIMITER = "\\|";
    
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
	
//	public Boolean writeFile(String fileName) throws IOException {
//        BufferedWriter bw = null;
//        try {
//            bw = new BufferedWriter(new FileWriter(fileName));
//            for(Student student : students) {
//                bw.append(student.getId().toString());
//                bw.append(COMMA_DELIMITER);
//                bw.append(student.getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(student.getScore() == null ? "" : student.getScore().toString());
//                bw.append(COMMA_DELIMITER);
//                bw.append(student.getImage());
//                bw.append(COMMA_DELIMITER);
//                bw.append(student.getAddress());
//                bw.append(COMMA_DELIMITER);
//                bw.append(student.getNote());
//                bw.append(NEW_LINE_SEPARATOR);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            bw.flush();
//            bw.close();
//        }
//        return true;
//    }
//	
	
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
                slangWords.put(data[0], Arrays.asList(data[1].split(PIPE_DELIMITER, -1)));
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
	
}

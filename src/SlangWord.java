import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlangWord {
	
	private Map<String, List<String>> slangWords = new HashMap();
	
    private static final String DEFAULT_FILE_NAME = "slang.txt";
    private static final String ORIGINAL_FILE_NAME = "original-slang.txt";
    private static final String HISTORY_FILE_NAME = "history-slang.txt";
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
	
}

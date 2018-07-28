import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * This class maps the dolphin sounds to human-readable English
 * 
 * @author Stephanie Quek
 * @version 1.0
 * @since 27 July 2018
 */
public class Translator {
	// Variable
	private final char separator = ' ';											// Acceptable separator of dolphin's pattern
	private final String separatorString = " ";									// Acceptable separator of dolphin's pattern
	private Hashtable <String, String> mapping;									// Mapping of dolphin pattern to human-readable English provided by Scientists
	private List<String> dolphinPattern; 										// Interpreted dolphin patterns from scientists
	private List<String> translatedPattern;										// Translated dolphin pattern to human-readable English
	
	// Constructor
	public Translator(Hashtable<String, String> mapping, List<String> dolphinPattern) {
		this.mapping = mapping;
		this.dolphinPattern = dolphinPattern;
		translatedPattern = new ArrayList<String>();
		
		// Start translation
		this.translate();
	}
	
	// Method	
	/**
	 * This method returns the current value of getMapping.
	 * @return mapping The mapping of dolphin patterns with human-readable English
	 */
	public Hashtable <String, String> getMapping() {
		return mapping;
	}
	
	/**
	 * This method returns the current value of dolphinPattern.
	 * @return dolphinPattern The dolphin pattern provided by Scientists
	 */
	public List<String> getDolphinPattern() {
		return dolphinPattern;
	}
	
	/**
	 * This method returns the current value of translatedPattern.
	 * @return translatedPattern The human-readable English text after mapping
	 */
	public List<String> getTranslatedPattern() {
		return translatedPattern;
	}
	
	/**
	 * This method does the logic of translation according to mapping
	 */
	private void translate() {
		String result, translated;
		
		for (int i = 0; i < dolphinPattern.size(); i++) {
			// Split name via ":" as name does not need to be translated
			String[] nameSpeech = dolphinPattern.get(i).split(":");				//[0]: Name, [1]: Speech
			result = nameSpeech[0] + ":";
			
			// Get key (dolphin pattern) from mapping
			Set<String> keysSet = mapping.keySet();
			List<String> keys = new ArrayList<>(keysSet);

			// Translate the speech
			translated = translateLogic(nameSpeech[1], keys);
			result = result.concat(translated);
			
			// Put into result
			translatedPattern.add(result);
		}
	}
	
	/**
	 * This method contains the logic to translate dolphin pattern to human-readable English
	 * Replaces dolphin pattern with human-readable English
	 * @param speech Line of dolphin pattern
	 * @return translatedSpeech The line of translated result
	 */
	private String translateLogic(String speech, List<String> dolphinMap) {
		String translatedSpeech = speech;
		
		// Find each dolphin pattern and replace with the human-readable English
		for(int i = 0; i < dolphinMap.size(); i++) {
			String pattern = dolphinMap.get(i);
			String translated = mapping.get(pattern);
			translatedSpeech = translatedSpeech.replace(pattern, translated);
		}
		
		return translatedSpeech;
	}
}

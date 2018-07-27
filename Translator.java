import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * This class maps the dolphin sounds to human-readable English
 * 
 * @author Stephanie Quek
 * @version 1.0
 * @since 27 July 2018
 */
public class Translator {
	// Variable
	private Hashtable <String, String> mapping;	// Mapping of dolphin pattern to human-readable English provided by Scientists
	private List<String> dolphinPattern; 		// Interpreted dolphin patterns from scientists
	private List<String> translatedPattern;		// Translated dolphin pattern to human-readable English
	
	// Constructor
	public Translator(Hashtable<String, String> mapping, List<String> dolphinPattern) {
		this.mapping = mapping;
		this.dolphinPattern = dolphinPattern;
		translatedPattern = new ArrayList();
		
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
		String result, temp;
		
		for (int i = 0; i < dolphinPattern.size(); i++) {
			// Split name via ":" as name does not need to be translated
			String[] nameSpeech = dolphinPattern.get(i).split(":");	//[0]: Name, [1]: Speech
			result = nameSpeech[0] + ":";
			
			// Translate the speech
			/*temp = translateLogic(nameSpeech[1]);
			result.concat(temp);*/
			
			// Put into result
			translatedPattern.add(result);
		}
	}
	
	/**
	 * This method contains the logic to translate dolphin pattern to human-readable English
	 * @param speech Line of dolphin pattern
	 * @return translatedSpeech The line of translated result
	 */
	private String translateLogic(String speech) {
		String translatedSpeech = null;
		
		// logic
		
		return translatedSpeech;
	}
}

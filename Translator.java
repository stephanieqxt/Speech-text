import java.util.Hashtable;

/**
 * This class maps the dolphin sounds to human-readable English
 * 
 * @author Stephanie Quek
 * @version 1.0
 * @since 27 July 2018
 */
public class Translator {
	// Variable
	private String mappingFile;					// Mapping file name
	private Hashtable <String, String> mapping;	// Mapping of dolphin pattern to human-readable english provided by Scientists
	private String [] dolphinPattern; 			// Interpreted dolphin patterns from scientists
	private String [] translatedPattern;		// Translated dolphin pattersn to human-readable english
	
	// Constructor
	public Translator(String[] dolphinPattern, String mappingFile) {
		this.dolphinPattern = dolphinPattern;
		this.mappingFile = mappingFile;
	}
	
	// Method
	/**
	 * This method returns the current value of mappingFile.
	 * @return mappingFile The file name of mapping
	 */
	public String getMappingFileName() {
		return mappingFile;
	}
	
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
	public String[] getDolphinPattern() {
		return dolphinPattern;
	}
	
	/**
	 * This method returns the current value of translatedPattern.
	 * @return translatedPattern The human-readable English text after mapping
	 */
	public String[] getTranslatedPattern() {
		return translatedPattern;
	}
	
	/**
	 * This method reads the input text file of mappings between dolphin pattern and human-readable English.
	 * Writes to Hashtable mapping
	 */
	private void readMapping() {
		// Reads input file and write to Hashtable
	}
	
	/**
	 * This method does the logic of translation according to mapping
	 */
	private void translate() {
		// Does translation
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The SpeechTranslator program translates interpreted dolphin sounds to human-readable English.
 * 
 * Input is a text file of interpreted dolphin sounds.
 * Output is a text file of human-readable English translated 
 * from dolphin sounds according to mapping.
 * 
 * @author Stephanie Quek
 * @version 1.0
 * @since 27 July 2018
 */
public class SpeechTranslator {	
	/**
	 * This methods gets user input.
	 * @return input The texts that user types
	 */
	private static String getUserInput() {
		String input = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return input;
	}
	
	/** 
	 * This method reads the dolphin pattern text file. 
	 * @param inputFile Input text file path
	 * @return dolphinPattern Interpreted speech of dolphin
	 */
	private static List<String> readSpeech(String inputFile) {
		List<String> dolphinPattern = new ArrayList<String>();
		
		try {
			dolphinPattern = Files.readAllLines(Paths.get(inputFile));
			
			// Convert to lower case
			dolphinPattern.replaceAll(String::toLowerCase);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dolphinPattern;
	}
	
	/**
	 * This method reads the mapping text file
	 * @param inputFile Input text file path
	 * @return mapping Mapping of dolphin and human-readable English
	 */
	private static Hashtable<String, String> readMapping(String inputFile){
		Hashtable<String, String> mapping = new Hashtable<String, String>();
		
		try {
			Stream<String> stream = Files.lines(Paths.get(inputFile));
			
			// Convert string
			List<String> input = stream.collect(Collectors.toList());
			stream.close();
			
			// Split into key and value for each line of mapping via "="
			for(int i = 0; i < input.size(); i++) {
				String [] keyVal = input.get(i).split("=");
				mapping.put(keyVal[0].toLowerCase(), keyVal[1].toLowerCase());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping;
	}
	
	/**
	 * This method outputs the translated result
	 * @param outputFile Output text file path
	 * @param translatedPattern Translated result of comparing mapping
	 */
	private static void writeFile(String outputFile, List<String> translatedPattern) {
		try {
			Files.write(Paths.get(outputFile), translatedPattern);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * This is the main method which makes use of readFile and writeFile methods.
	 * @param args
	 * @return Nothing
	 * @exception IOException on input error
	 * @see IOException
	 */
	public static void main(String[] args) {
		String inputFile, outputFile, mappingFile;
		Hashtable<String, String> mapping;
		List<String> dolphinPattern;
		List<String> translatedPattern;
		
		// Request user to enter input and output file path
		System.out.println("Welcome to speech-to-text translator!\n");
		System.out.println("Please enter the following...");
		System.out.print("Input file path: ");
		inputFile = getUserInput();
		System.out.print("Output file path: ");
		outputFile = getUserInput();
		System.out.print("Mapping file path: ");
		mappingFile = getUserInput();
		
		// Read input file dolphin pattern
		dolphinPattern = readSpeech(inputFile);
		
		// Read input file mapping
		mapping = readMapping(mappingFile);
		
		// Instantiate object to trigger translation
		Translator translator = new Translator(mapping, dolphinPattern);
		
		// Output to file
		translatedPattern = translator.getTranslatedPattern();
		writeFile(outputFile, translatedPattern);
		System.out.println("\nWrite to file '" + outputFile + "' completed.");
	}
}

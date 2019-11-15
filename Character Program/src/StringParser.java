
public class StringParser {

	//instance class variables/objects
	private String raw;
	private String[] strings;
	private int characterCount;
	private int wordCount;
	
	//constructor
	public StringParser(String str) {
		raw = str.toLowerCase();
		characterCount = -1;
		wordCount = 0;
	}
	
	//calculates result
	public void generate() {
		String correct = removeSpaces(raw);
		wordCount = getAmountOfWords(correct);
		characterCount = determineCharacterCount(correct);
		strings = splitString(correct, ' ');
		removeSinglePunctuation();
	}
	
	//removes extra spaces and leaves one between words
	private String removeSpaces(String str) {
		String result = "";
		int length = str.length();
		for(int i = 0; i < length; i++) {
			while(i < length -1 && !(str.charAt(i) == ' ' && str.charAt(i+1) == ' ')) {
				result += str.charAt(i);
				i++;
			}
			if(i == length-1 && !isSpace(str.charAt(i))) {
				result += str.charAt(i);
			}
		}
		if(isSpace(result.charAt(0))){
			result = result.substring(1);
		}
		return result;
	}
	
	private boolean isSpace(char c) {
		if(c == ' ')return true;
		else return false;
	}
	
	//split string method
	private String[] splitString(String str, char c) {
		String[] result = new String[getAmountOfWords(str)];
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			String s = "";
			while(i < str.length() && str.charAt(i) != c) {
				s+=str.charAt(i);
				i++;
			}
			if(s.length() > 0)result[count++] = s;
			if(s.length() == 1)wordCount--;
		}
		return result;
	}
	
	private int getAmountOfWords(String str) {
		int amount = 1;
		for(int i = 0; i < str.length(); i++) {
			//if(Character.isAlphabetic(str.charAt(i)))
			if(str.charAt(i) == ' ')amount++;
		}
		return amount;
	}

	//remove the last punctuation in each word
	private void removeSinglePunctuation(){
		for(int i = 0; i < strings.length; i++) {
			if(isPunctuation(strings[i].charAt(strings[i].length()-1))) {
				strings[i] = strings[i].substring(0, strings[i].length()-1);
			}	
		}
	}
	
	private boolean isPunctuation(char c) {
		if(c == '.' || c == '?' || c == '!')return true;
		else return false;
	}
	
	private int determineCharacterCount(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!isSpace(c))count++;
		}
		return count;
	}
	
	//output
	public String toString() {
		String result = 
				characterCount + " Characters\n" + 
				wordCount + " Word(s)\n";
		for(int i = 0; i < strings.length; i++) {
			String str = strings[i];
			if(strings[i].isEmpty())continue;
			if(exists(strings,str,i))continue;
			int occurrences = amountOfOccurrences(str);
			makeFirstCharUpperCase();
			result += strings[i] + " " + occurrences + '\n';
		}
		return result;
	}
	
	//these 2 methods are used to exclude duplicate words/characters in output
	private boolean exists(String[] arr, String str, int start) {
		boolean result = false;
		for(int i = start-1; i >= 0; i--) {
			if(arr[i].equals(str))return true;
		}
		return result;
	}
	
	private boolean exists(String str, char c, int start) {
		boolean result = false;
		for(int i = start-1; i >= 0; i--) {
			if(str.charAt(i) == c)return true;
		}
		return result;
	}
	
	//these 2 methods are used to count up how many time a word/character appears in the input 
	private int amountOfOccurrences(String str) {
		int occurrences = 0;
		for(String s : strings) {
			if(s.equals(str))occurrences++;
		}
		return occurrences;
	}
	
	private int amountOfOccurrences(String str, char c) {
		int occurrences = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)occurrences++;
		}
		return occurrences;
	}
	
	//formats
	private void makeFirstCharUpperCase() {
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].length() == 0)continue;
			if(Character.isAlphabetic(strings[i].charAt(0))) {
				strings[i] = Character.toUpperCase(strings[i].charAt(0)) + strings[i].substring(1);
			}
		}
	}
	
	public String getCharacterCount() {
		String result = "";
		for(int i = 0; i < raw.length(); i++) {
			if(isSpace(raw.charAt(i)))continue;
			char c = raw.charAt(i);
			if(exists(raw,c,i))continue;
			int occurrences = amountOfOccurrences(raw,c);
			result += c + " " + occurrences + '\n';
		}
		return result;
	}
	
}

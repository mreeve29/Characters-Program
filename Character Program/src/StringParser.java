
public class StringParser {

	private String raw;
	
	private String[] strings;
	
	private int characterCount;
	
	public StringParser(String str) {
		raw = str.toLowerCase();
		raw = raw.replace('\t', ' ');
		characterCount = -1;
	}
	
	public void generate() {
		String correct = removeSpaces(raw);
		strings = splitString(correct, ' ');
		removeTrailingCharacters();
	}
	
	private String removeSpaces(String str) {
		String result = "";
		char[] split = createCharArray(str);
		determineCharacterCount(split);
		for(int i = 0; i < split.length; i++) {
			while(i < split.length -1 && !(isTabSpace(split[i]) && isTabSpace(split[i+1]))) {
				result += split[i];
				i++;
			}
			if(i == split.length-1 && !isTabSpace(split[i])) {
				result += split[i];
			}
		}
		if(isTabSpace(result.charAt(0))){
			result = result.substring(1);
		}
		return result;
	}
	
	private boolean isTabSpace(char c) {
		if(c == ' ') {
			return true;
		}
		else return false;
	}
	
	private char[] createCharArray(String str) {
		char[] result = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			result[i] = str.charAt(i);
		}
		return result;
	}
	
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
		}
		return result;
	}
	
	public int getAmountOfWords(String str) {
		int amount = 1;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ')amount++;
		}
		return amount;
	}
	
	private void removeTrailingCharacters() {
		char[] last = createCharArray(strings[strings.length-1]);
		String lastStr = strings[strings.length-1];
		for(int i = last.length-1; i > 0; i--) {
			char c = last[i];
			char h = last[i-1];
			if(Character.isAlphabetic(h))break;
			if(isPunctuation(c) && isPunctuation(h)) {
				lastStr = lastStr.substring(0, lastStr.length()-1);
			}
		}
		if(isPunctuation(strings[strings.length-1].charAt(strings[strings.length-1].length()-1))){
			strings[strings.length-1] = lastStr.substring(0,lastStr.length()-1);
		}
		
	}
	
	private boolean isPunctuation(char c) {
		if(c == '.' || c == '?' || c == '!' || c == ',' || c == '\'' || c == ':' || c == ';')return true;
		else return false;
	}
	
	private void determineCharacterCount(char[] charArr) {
		int count = 0;
		for(char c : charArr) if(!Character.isWhitespace(c))count++;
		characterCount = count;
	}
	
	public String toString() {
		String result = 
				characterCount + " Characters\n" + 
				strings.length + " Words\n";
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
		
	private boolean exists(String[] arr, String str, int start) {
		boolean result = false;
		for(int i = start-1; i >= 0; i--) {
			if(arr[i].equals(str))return true;
		}
		return result;
	}
	
	private int amountOfOccurrences(String str) {
		int occurrences = 0;
		for(String s : strings) {
			if(s.equals(str))occurrences++;
		}
		return occurrences;
	}
	
	private void makeFirstCharUpperCase() {
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].length() == 0)continue;
			if(Character.isAlphabetic(strings[i].charAt(0))) {
				strings[i] = Character.toUpperCase(strings[i].charAt(0)) + strings[i].substring(1);
			}
		}
	}
}

public class CharacterGUI {
	public static void main(String[] args) {
		String test = "                     And     he     came 2   school.";
		
		String correctSpaces = "";
		
		char[] split = toCharArrayCool(test);
		for(int i = 0; i < split.length; i++) {
			while(i < split.length -1 && !(split[i] == ' ' && split[i+1] == ' ')) {
				correctSpaces += split[i];
				i++;
			}
			if(i == split.length-1 && split[i] != ' ') {
				correctSpaces += split[i];
			}
		}
		correctSpaces = correctSpaces.substring(1);
		
		System.out.println(correctSpaces);
		
		String[] test2 = correctSpaces.split(" ");
		System.out.println(test2.length);
		for(String s : test2) {
			System.out.println("\"" + s + "\"");
		}
	}
	
	
	public static char[] toCharArrayCool(String str) {
		char[] result = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			result[i] = str.charAt(i);
		}
		return result;
	}
	
	public static String[] splitString(String str, char c) {
		String[] result = new String[getAmountOfWords(str)];
		for(int i = 0; i < str.length(); i++) {
			String s = "";
		}
		return result;
	}
	
	public static int getAmountOfWords(String str) {
		int amount = 1;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ')amount++;
		}
		return amount;
	}
	
}

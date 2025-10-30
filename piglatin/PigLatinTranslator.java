package piglatin;

public class PigLatinTranslator {

public static Book translate(Book input) {

    Book translatedbook = new Book();

    int Jen = input.getLineCount();
    for(int J = 0; J < Jen; J++) {
           String Line = input.getLine(J);
           String translatedLine = translate(Line);
           translatedbook.appendLine(translatedLine);
       }
       return translatedbook;
}
public static String translate(String input) {

    String result = "";

    for(String word: input.split(" ")) {
        result += " " + translateWord(word);
    }
    return result.trim();
}

private static String translateWord(String input) {

    String result = "";
    if (input == null || input.trim().length() == 0){
           return "";
       }
       int vowelIndex = 0;
       int puncIndex = 0;
       boolean hasPunctuation = false;
       String firstLetter = input.substring(0, 1);


       if (isVowel(firstLetter)){
           result = input + "ay";
       }

       for (int J = 0; J < input.length(); J++) {
        if (isVowel(input.substring(J, J+1))) {
            vowelIndex = J;
            break;
        }
       }
        String start = input.substring(0,vowelIndex);
        String rest = input.substring(vowelIndex);
        result = rest + start.toLowerCase() + "ay";

         if (result.indexOf(".") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf(".");
       } else if (result.indexOf("!") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf("!");
       } else if (result.indexOf("?") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf("?");
       }  else if (result.indexOf(",") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf(",");
       } else if (result.indexOf(";") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf(";");
       } else if (result.indexOf(":") != -1){
           hasPunctuation = true;
           puncIndex = result.indexOf(":");
       }
  if (hasPunctuation){
           result = result.substring(0, puncIndex) + result.substring(puncIndex + 1) + result.charAt(puncIndex);
       }


       if (Character.isUpperCase(input.charAt(0))){
           result = result.substring(0, 1).toUpperCase() + result.substring(1);
       }
       return result;
   }


   public static boolean isVowel(String letter){
       String Vowels = "aeiouAEIOU";
       if (Vowels.indexOf(letter) != -1) {
           return true;
       }
       return false;
   }


   public static boolean isPunc(String letter){
       String Specialletters = ".!?";
       if (Specialletters.indexOf(letter) != -1){
           return true;
       }
       return false;
   }
}

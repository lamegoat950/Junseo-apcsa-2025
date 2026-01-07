package piglatin;

public class PigLatinTranslator {

public static Book translate(Book Input) {

    Book translatedbook = new Book();

    int Jen = Input.getLineCount();
    for(int J = 0; J < Jen; J++) {
           String Line = Input.getLine(J);
           String translatedLine = translate(Line);
           translatedbook.appendLine(translatedLine);
       }
       return translatedbook;
}
public static String translate(String Input) {

    String result = "";

    for(String word: Input.split(" ")) {
        result += " " + translateWord(word);
    }
    return result.trim();
}

private static String translateWord(String Input) {

    String result = "";
    if (Input == null || Input.trim().length() == 0){
           return "";
       }
       int VowelIndex = 0;
       int puncIndex = 0;
       boolean hasPunctuation = false;
       String firstLetter = Input.substring(0, 1);


       if (isVowel(firstLetter)){
           result = Input + "ay";
       }

       for (int J = 0; J < Input.length(); J++) {
        if (isVowel(Input.substring(J, J+1))) {
            VowelIndex = J;
            break;
        }
       }
        String Begin = Input.substring(0,VowelIndex);
        String leftover = Input.substring(VowelIndex);
        result = leftover + Begin.toLowerCase() + "ay";

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


       if (Character.isUpperCase(Input.charAt(0))){
           result = result.substring(0, 1).toUpperCase() + result.substring(1);
       }
       return result;
   }


   public static boolean isVowel(String Letter){
       String Vowels = "aeiouAEIOU";
       if (Vowels.indexOf(Letter) == -1) {
           return false;
       }
       else
       return true;
   }


   public static boolean isPunc(String Letter){
       String Special = ".!?";
       if (Special.indexOf(Letter) == -1) {
           return false;
       }
       else
       return true;
   }
}

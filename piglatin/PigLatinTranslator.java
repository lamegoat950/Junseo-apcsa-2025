package piglatin;

import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {

   

public static Book translate(Book input) {
Book translatedBook = new Book();
for (int i = 0; i < input.getLineCount(); i++) {
String line = input.getLine(i);
translatedBook.appendLine(translate(line));
}
return translatedBook;
}

public static String translate(String input) {
if (input == null || input.isEmpty()) return input;

Pattern p = Pattern.compile("[A-Za-z]+(?:-[A-Za-z]+)*");
Matcher m = p.matcher(input);

StringBuilder out = new StringBuilder();
int last = 0;

while (m.find()) {
out.append(input, last, m.start());

String word = m.group();
out.append(translateHyphenatedWord(word));

last = m.end();
}

out.append(input.substring(last));
return out.toString();
}

private static String translateHyphenatedWord(String word) {
if (!word.contains("-")) return translateWord(word);

String[] parts = word.split("-");
StringBuilder sb = new StringBuilder();
for (int i = 0; i < parts.length; i++) {
sb.append(translateWord(parts[i]));
if (i < parts.length - 1) sb.append("-");
}
return sb.toString();
}

private static String translateWord(String word) {
if (word == null || word.isEmpty()) return word;

boolean isCapitalized = Character.isUpperCase(word.charAt(0));
String lower = word.toLowerCase();


int firstVowel = findFirstVowel(lower);
String translated;



if (firstVowel == 0) {
translated = lower + "ay";
} else if (firstVowel > 0) {
translated = lower.substring(firstVowel) + lower.substring(0, firstVowel) + "ay";
} else {
translated = lower + "ay";
}

if (isCapitalized && translated.length() > 0) {
translated = Character.toUpperCase(translated.charAt(0)) + translated.substring(1);
}

return translated;
}

private static int findFirstVowel(String s) {
String vowels = "aeiou";
for (int i = 0; i < s.length(); i++) {
if (vowels.indexOf(s.charAt(i)) >= 0) return i;
}
return -1;
}
}



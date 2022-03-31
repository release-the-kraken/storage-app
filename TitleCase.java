public class TitleCase {
//changing the first letter of a word to upper case
    String titleCase(String str){
        String firstLetter = "" + str.charAt(0);
        return str.replace(firstLetter, firstLetter.toUpperCase());
    }
}

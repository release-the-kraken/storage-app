public class TitleCase {
//changing the first letter of a word to upper case
    String titleCase(String str){
        String[] arrayFromStr = str.split(" ");
        for(int i = 0; i < arrayFromStr.length; i++){
            String firstLetter = "" + arrayFromStr[i].charAt(0);
            arrayFromStr[i] = arrayFromStr[i].replaceFirst(firstLetter, firstLetter.toUpperCase());
        }
        return String.join(" ", arrayFromStr);
    }
}

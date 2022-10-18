import java.util.Locale;

public class PalindromeSolution {

    private boolean isPalindrome(String text){
        text = text.toLowerCase();
        for(int i = 0; i < text.length() / 2; i++){
            if(text.charAt(i) != text.charAt(text.length() - i - 1)){
                return false;
            }
        }

        return true;
    }

}

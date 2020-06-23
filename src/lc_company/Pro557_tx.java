package lc_company;

public class Pro557_tx {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word:words)
        {
            StringBuilder temp = new StringBuilder(word);
            sb.append(temp.reverse());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

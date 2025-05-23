package scanner;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private final String[] tokens;

    public Scanner(String input) {
        this.tokens = tokenize(input).toArray(new String[0]);
    }

    public String[] getToken() {
        return tokens;
    }

    private List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }

        if (!number.isEmpty()) {
            tokens.add(number.toString());
            number.setLength(0);
        }


        return tokens;
    }
}

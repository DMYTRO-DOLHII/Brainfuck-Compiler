package lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortcutLexeme extends Lexeme {

    private static final Pattern pattern = Pattern.compile("[0-9]+[+-<>]");

    public ShortcutLexeme() {
        super(pattern.pattern());
    }

    @Override
    public boolean isIn(String input) {
        Matcher matcher = pattern.matcher(input);
        String value = "";
        while(matcher.find()) {
            value = matcher.group(0);
            break;
        }
        setValue(value);
        return true;
    }
}

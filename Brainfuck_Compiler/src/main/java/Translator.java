import lexeme.*;


import java.util.ArrayList;
import java.util.List;

public class Translator {

    private static final List<Lexeme> lexemes =
            List.of(new PreviousCellLexeme(),
                    new NextCellLexeme(),
                    new IncrementCellLexeme(),
                    new DecrementCellLexeme(),
                    new PrintCellLexeme(),
                    new LoopStartLexeme(),
                    new LoopEndLexeme(),
                    new ShortcutLexeme());

    public List<Lexeme> transcode(String code) {
        String remaining = code;
        List<Lexeme> result = new ArrayList<>();
        boolean isAdded;
        while (!remaining.isEmpty()) {
            isAdded = false;
            for (Lexeme current : lexemes) {
                if (current.isIn(remaining)) {
                    result.add(current.newLexeme());
                    remaining = remaining.substring(current.value().length());
                    isAdded = true;
                }
            }
            if (!isAdded){
                result.clear();
                int position = code.length() - remaining.length();
                System.out.println("Unexpected symbol at position " + Integer.toString(position) + " : " + remaining.charAt(0));
                break;
            }
        }
        return result;
    }
}

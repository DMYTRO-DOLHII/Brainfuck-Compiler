import lexeme.Lexeme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compiler {

    private final IncrementCell incrementCell = new IncrementCell();
    private final DecrementCell decrementCell = new DecrementCell();
    private final NextCell nextCell = new NextCell();
    private final PreviousCell previousCell = new PreviousCell();
    private final PrintCell printCell = new PrintCell();
    private final LoopStartCell loopStartCell = new LoopStartCell();
    private final LoopEndCell loopEndCell =  new LoopEndCell();

    private final Pattern pattern = Pattern.compile("[0-9]+");


    public List<Command> compile(List<Lexeme> lexemes) {
        List<Command> commands = new ArrayList<>();
        for (Lexeme lexeme : lexemes) {
            Matcher matcher = pattern.matcher(lexeme.value());
            String value = "";
            int amount = 0;
            while(matcher.find()){
                value = matcher.group();
                amount = Integer.parseInt(value);
            }
            if(amount != 0){
                if(lexeme.value().contains("+")){
                    for(int i = 0; i < amount; i++){
                        commands.add(incrementCell);
                    }
                } else if(lexeme.value().contains("-")){
                    for(int i = 0; i < amount; i++){
                        commands.add(decrementCell);
                    }
                } else if(lexeme.value().contains(">")){
                    for(int i = 0; i < amount; i++){
                        commands.add(nextCell);
                    }
                } else if(lexeme.value().contains("<")){
                    for(int i = 0; i < amount; i++){
                        commands.add(previousCell);
                    }
                }
            }
            switch (lexeme.value()) {
                case "+":
                    commands.add(incrementCell);
                    break;
                case "-":
                    commands.add(decrementCell);
                    break;
                case ">":
                    commands.add(nextCell);
                    break;
                case "<":
                    commands.add(previousCell);
                    break;
                case ".":
                    commands.add(printCell);
                    break;
                case "[":
                    commands.add(loopStartCell);
                    break;
                case "]":
                    commands.add(loopEndCell);
                    break;
            }
        }

        return commands;
    }
}

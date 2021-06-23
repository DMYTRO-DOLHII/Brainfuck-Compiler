package lexeme;

public class Lexeme {

    protected String value;

    protected Lexeme(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public boolean isIn(String input) {
        return input.startsWith(value);
    }

    public Lexeme newLexeme(){
        Lexeme lexeme = new Lexeme(value);
        return lexeme;
    }


}

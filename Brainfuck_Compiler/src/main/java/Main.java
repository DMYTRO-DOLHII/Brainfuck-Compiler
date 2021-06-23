public class Main {
    public static void main(String[] args){
        String code = "72+.29+.7+.0+.3+.";

        Translator translator = new Translator();
        Compiler compiler = new Compiler();
        Runtime runtime = new Runtime();

        runtime.run(compiler.compile(translator.transcode(code)));
    }
}
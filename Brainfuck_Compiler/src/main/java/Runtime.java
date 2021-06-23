import java.util.List;

public class Runtime {

    private Context context = new Context();


    public void run(List<Command> commands){
        for(int i = context.getCurrentCommandIndex(); i < commands.size(); ){
            commands.get(i).execute(context);
            i = context.getCurrentCommandIndex();
        }
    }
}
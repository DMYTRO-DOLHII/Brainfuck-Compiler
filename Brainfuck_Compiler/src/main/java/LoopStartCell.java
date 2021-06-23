public class LoopStartCell implements Command{
    @Override
    public void execute(Context context) {
        context.loopStartCell();
    }
}

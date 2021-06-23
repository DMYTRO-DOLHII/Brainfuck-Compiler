public class IncrementCell implements Command{
    @Override
    public void execute(Context context) {
        context.incrementCurrent();
    }
}

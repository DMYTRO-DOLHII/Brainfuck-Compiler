public class DecrementCell implements Command{
    @Override
    public void execute(Context context) {
        context.decrementCurrent();
    }
}

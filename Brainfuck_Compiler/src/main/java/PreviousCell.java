public class PreviousCell implements Command{
    @Override
    public void execute(Context context) {
        context.previousCell();
    }
}

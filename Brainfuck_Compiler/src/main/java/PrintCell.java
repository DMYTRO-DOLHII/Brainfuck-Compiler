public class PrintCell implements Command{
    @Override
    public void execute(Context context) {
        context.printCell();
    }
}

public class Context {
    private final int[] memory = new int[30000];
    private int i = 0;
    private int currentCommandIndex = 0;
    private int loopStartIndex;
    private int loopEndIndex;

    public void incrementCurrent(){
        memory[i]++;
        currentCommandIndex++;
    }

    public void decrementCurrent(){
        memory[i]--;
        currentCommandIndex++;
    }

    public void nextCell(){
        i++;
        currentCommandIndex++;
    }

    public void previousCell(){
        i--;
        currentCommandIndex++;
    }

    public void printCell(){
        System.out.printf(String.valueOf((char)memory[i]));
        currentCommandIndex++;
    }

    public void loopStartCell(){
        loopStartIndex = currentCommandIndex;
        if(memory[i] != 0){
            currentCommandIndex++;
        } else {
            currentCommandIndex = loopEndIndex++;
        }
    }

    public void loopEndCell(){
        loopEndIndex = currentCommandIndex;
        if(memory[i] != 0){
            currentCommandIndex = loopStartIndex;
        } else{
            currentCommandIndex++;
        }
    }

    public int getCurrentCommandIndex(){
        return currentCommandIndex;
    }

    public int getCellValue(){
        return memory[i];
    }

    public int getCell(){
        return i;
    }
}

/**
 * Created by Evan Otero
 * 11/16/16
 */

public class ErrorState implements State {
    private final CSVMachine csvMachine;

    public ErrorState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    // Do not change state
    public void quote(char c) { }

    public void comma(char c) {
        csvMachine.fieldComplete();
        csvMachine.setState(csvMachine.getBeginFieldState());
    }

    // Do not change state
    public void other(char c) { }
}

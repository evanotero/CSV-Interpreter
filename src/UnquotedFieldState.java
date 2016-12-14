/**
 * Created by Evan Otero
 * 11/16/16
 */

public class UnquotedFieldState implements State {
    private final CSVMachine csvMachine;

    public UnquotedFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void quote(char c) {
        csvMachine.setState(csvMachine.getErrorState());
    }

    public void comma(char c) {
        csvMachine.fieldComplete();
        csvMachine.setState(csvMachine.getBeginFieldState());
    }

    // Do not change state
    public void other(char c) {
        csvMachine.addCharToField(c);
    }
}

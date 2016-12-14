/**
 * Created by Evan Otero
 * 11/16/16
 */

public interface State {
    void quote(char c);
    void comma(char c);
    void other(char c);
}

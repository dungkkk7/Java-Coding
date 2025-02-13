
package j1.s.p011;

/**
 *
 * @author 84823
 */
public class Main {

    public static void main(String[] args) {
        // đối tượng đây nè 
        while (true) {
            BaseConverEngine convertEngine = new BaseConverEngine();
            int choiceInput = View.menu(0);
            int choiceOuput = View.menu(choiceInput);
            convertEngine.start(choiceInput, choiceOuput);
        }
    }
    
}

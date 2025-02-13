
package j1.s.p011;

public class View {

    public static int menu(int flag) {
        System.out.println("==== Base Conversion Menu ====");
        System.out.println("1.  Binary");
        System.out.println("2.  Decimal");
        System.out.println("3.  Hexadecimal");
        System.out.println("4. Exit");        
        int choice = InputGetter.getChoice("Enter your choice : ", flag); 
        if(choice == 4){
            System.exit(0);
        }
        return choice;
    }
}

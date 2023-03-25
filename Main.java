import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Main {

    public static <T> void main(String[] args)throws Exception {
        Scanner in = new Scanner(System.in);
        String input;
        String decider;
        do {
            System.out.print("Stack or queue?(s/q): ");
            decider = in.nextLine();
        }while(!(decider.toLowerCase().equals("q") || decider.toLowerCase().equals("s")));
        do {
            System.out.print("Enter anything: ");
            input = in.nextLine();
        }while(input.length() == 0);

        if (decider.equals("s")){
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Elements that will be inserted to the stack checker: " + input.substring(0, input.length()/2));
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Elements that will be compared to the stack: " + input.substring((int) Math.ceil((float)input.length()/2), input.length()));
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
            System.out.print(palindromeStack(input.toLowerCase()));
        } else {
            System.out.println();
            System.out.print(palindromeQueue(input.toLowerCase()));
        }
    }

    public static <T> String palindromeQueue(String elem) throws InterruptedException {
        if(elem.length() == 1) return "The element '" + elem + "' is a palindrome";

        LinkedQueue queue = new LinkedQueue();
        String reversed = "";

        System.out.println("Original element: ");
        for (int i = 0; i < elem.length(); i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(elem.charAt(i));
            System.out.print(" | ");
        }

        for (int i = elem.length()-1; i >=0; i--) {
            queue.offer(elem.charAt(i));
        }

        System.out.println();
        System.out.println("Checking by queuing elements from the back: ");
        while (!queue.isEmpty()) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(queue.poll());
            System.out.print(" | ");
        }

        System.out.println();
        TimeUnit.SECONDS.sleep(1);
        if (elem.equals(reversed)){
            System.out.println("Element matched!");
            System.out.println();
            return "The element '" + elem + "' is a palindrome";
        }
        else{
            System.out.println("Element mismatch!");
            System.out.println();
            return "The element '" + elem + "' is not a palindrome";
        }
    }
    public static <T> String palindromeStack(String elem) throws InterruptedException {
        if(elem.length() == 1) return "The element '" + elem + "' is a palindrome";

        ListStack p = new ListStack();
        String list = "";
        char a;
        char u = '\u00AF';

        for(int i = 0; i < elem.length()/2; i++){
            p.push(elem.charAt(i));
            list += elem.charAt(i);
        }

        stackIllustrate(list);

        for(int i = (int) Math.ceil((float)elem.length()/2); i < elem.length(); i++){
            a = elem.charAt(i);
            stackPopper(p);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Current element: ");
            System.out.println("|"+u+u+u+u+u+u+u+"|");
            System.out.println("|   "+a+"   |");
            System.out.println("|_______|");
            TimeUnit.SECONDS.sleep(1);
            if (Objects.equals(a, p.peek())){
                a = elem.charAt(i);
                p.pop();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Element matched!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Popped '" + a+"'");
            }
            else {
                System.out.println("Element mismatch!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("'"+a + "' will not be popped");
            }
        }

        System.out.println();

        if(p.isEmpty()) return "The element '" + elem + "' is a palindrome";

        return "The element '" + elem + "' is not a palindrome";
    }

    public static void stackIllustrate(String i) throws InterruptedException {
        char[] a = i.toCharArray();
        char u = '\u00AF';
        System.out.println("Current stack: ");
        for(int j = a.length-1; j >= 0; j--){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("|"+u+u+u+u+u+u+u+"|");
            System.out.println("|   "+a[j]+"   |");
            System.out.println("|_______|");
        }
        TimeUnit.SECONDS.sleep(1);
    }

    public static void stackPopper(ListStack i) throws InterruptedException {
        char[] a = i.toString().replaceAll("\\s", "").replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]","").toCharArray();;
        System.out.println();
        char u = '\u00AF';
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Checking stack:");
        if(!(i.isEmpty())){
            for(int j = a.length-1; j >= 0; j--){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("|"+u+u+u+u+u+u+u+"|");
                System.out.println("|   "+a[j]+"   |");
                System.out.println("|_______|");
            }
        }
    }
}

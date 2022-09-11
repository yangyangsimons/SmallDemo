import java.sql.SQLOutput;
import java.util.Scanner;

public class stackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number to create the stack");
        int size = scanner.nextInt();
        arrayStack stack = new arrayStack(size);

        boolean controller = true;
        while(controller){
            System.out.println("show: show the whole stack");
            System.out.println("push: add one number in stack");
            System.out.println("pop: get one number out of stack");
            System.out.println("exit: exit this programm");
            String option = scanner.next();
            switch (option){
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("Input a number");
                    int n = scanner.nextInt();
                    stack.push(n);
                    break;
                case "pop":
                    int pop_number = stack.pop();
                    System.out.printf("The pop out value is: %d \n", pop_number);
                    break;
                case "exit":
                    controller = false;
                    break;
                default:
                    break;
            }

        }
    }
}

class arrayStack {
    //    maxSize -- capacity of this stack;
//    top -- the indicator of the stack top (stored data) default  -1;
//    stack -- the array in order to mock stack;
    private int maxSize;
    private int top;
    private int[] stack;

    public arrayStack(int maxSize) {
//        initialize the stack;
        this.top = -1;
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }
    private boolean isFull(){
        if(top == maxSize - 1){
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }
    public void push(int number) {
//        move the indicator(top) and assign the value;

        if(this.isFull()){
            throw new RuntimeException("stack is full");
        }else{
            top = top + 1;
            stack[top] = number;
        }
    }

    public int pop() {
//        get the value of stack[top] then top --;
        if(this.isEmpty()){
            throw new RuntimeException("this stack is empty");
        }else{
            int value = stack[top];
            top = top - 1;
            return value;
        }
    }

    public void show(){
        for (int i = top; i >= 0 ; i--) {
                System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }
}
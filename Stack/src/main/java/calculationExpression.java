public class calculationExpression {
    public static void main(String[] args) {
//        define 2 stacks to store the number and operator of the expression;
        arrayStack2 numStack = new arrayStack2(10);
        arrayStack2 operStack = new arrayStack2(10);

    }
}

class arrayStack2 {
//    maxSize -- capacity of this stack;
//    top -- the indicator of the stack top (stored data) default  -1;
//    stack -- the array in order to mock stack;
    private int maxSize;
    private int top;
    private int[] stack;

    public arrayStack2(int maxSize) {
//        initialize the stack;
        this.top = -1;
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    private boolean isFull() {
        if (top == maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int number) {
//        move the indicator(top) and assign the value;

        if (this.isFull()) {
            throw new RuntimeException("stack is full");
        } else {
            top = top + 1;
            stack[top] = number;
        }
    }

    public int pop() {
//        get the value of stack[top] then top --;
        if (this.isEmpty()) {
            throw new RuntimeException("this stack is empty");
        } else {
            int value = stack[top];
            top = top - 1;
            return value;
        }
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }

//     calculate the result of the subexpression, calculate order is from later to former;
    public int calculate(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

//    define the priority of operators;
    public int priority(char oper) {
        if (oper == '+' || oper == '-') {
            return 10;
        } else if (oper == '*' || oper == '/') {
            return 100;
        } else {
            return 0;
        }
    }
//    character is an operator or not;
    public boolean isOperator(char ch){
        if(ch == '+'|| ch == '-' || ch =='*' || ch == '/' ){
            return true;
        }else{
            return false;
        }
    }
}

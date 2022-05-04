import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        ReversePolishNotation obj = new ReversePolishNotation();
        System.out.println(obj.evalRPN(tokens));
    }

    // Java doesn't have ***operator overloading****, so you can't use ANY operators for non-primitive types

    public int evalRPN(String[] tokens) {
//        int ans = 0;
        //You're declaring a Stack<Object> implicitly, but that's not what you want
//      Look up generic types!!!!!
        Stack<Integer> inputNums = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("*")) {
                int num1 = inputNums.pop();
                int num2 = inputNums.pop();
                inputNums.push(num1 * num2);
                continue;
            }
            if (tokens[i].equals("+")) {
                int num1 = inputNums.pop();
                int num2 = inputNums.pop();
                inputNums.push(num1 + num2);
                continue;
            }
            //
            if (tokens[i].equals("-")) {
                int num1 = inputNums.pop();
                int num2 = inputNums.pop();

                inputNums.push(num2 - num1);
                continue;
            }
            if (tokens[i].equals("/")) {
                int num1 = inputNums.pop();
                int num2 = inputNums.pop();

                inputNums.push(num2 / num1);
                continue;
            }

            // A character code represents a single printable character in a string

            int tokenNum = Integer.parseInt(tokens[i]);

            inputNums.push(tokenNum);
        }

        return inputNums.pop();
    }
}

public class Quiz14 {

    public static void main(String[] arg865) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(8);
        stack.push(7);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(2 * 63);
        stack.push(0);

        System.out.println("bottom " + stack.toString() + " top");
        removeEvenNumbers(stack);
        System.out.println("bottom " + stack.toString() + " top");
    }

    public static void removeEvenNumbers(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.empty()) {
            int temp = stack.pop();
            if (!(temp % 2 == 0))
                tempStack.push(temp);
        }

        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }
}

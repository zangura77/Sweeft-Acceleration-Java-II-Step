import java.util.Stack;

public class IsProperlySolution {

    private boolean isProperly(String sequence){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                stack.push(sequence.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }

                if (sequence.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

}

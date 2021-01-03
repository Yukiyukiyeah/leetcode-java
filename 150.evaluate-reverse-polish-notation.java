class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+" :
                    s.push(s.pop() + s.pop());
                    break;
                case "-" :
                    int val = s.pop();
                    s.push(s.pop() - val);
                    break;
                case "*" :
                    s.push(s.pop() * s.pop());
                    break;
                case "/" :
                    int val2 = s.pop();
                    s.push(s.pop() / val2);
                    break;
                default :
                    s.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return s.peek();
    }
}
package matrix.concurrency.utils;

import java.util.Stack;

public class StackBalancedParentheses {
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        // Recorremos cada carácter en la cadena de entrada
        for (char c : input.toCharArray()) {
            if (isOpenParenthesis(c)) {
                // Si es un símbolo de apertura, lo apilamos en la pila
                stack.push(c);
            } else if (isCloseParenthesis(c)) {
                // Si es un símbolo de cierre, verificamos si el tope de la pila coincide
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // Al final, la pila debe estar vacía si la cadena está balanceada
        return stack.isEmpty();
    }

    private static boolean isOpenParenthesis(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isCloseParenthesis(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String balancedExpression = "{[()]()}";
        String unbalancedExpression = "{[(])}";

        System.out.println("La expresión balanceada es: " + isBalanced(balancedExpression)); // Debe imprimir true
        System.out.println("La expresión no balanceada es: " + isBalanced(unbalancedExpression)); // Debe imprimir false
    }
}


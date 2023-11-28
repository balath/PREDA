package DataStructures;

public class Recursividad{

    public static Queue<Integer> reverse(Queue<Integer> queue){
        int elem;
        Queue<Integer> reversed;

        if (queue.isEmpty()) return queue;

        elem = queue.getFirst();
        queue.dequeue();

        reversed = reverse(queue);

        reversed.enqueue(elem);
        return reversed;
    }

    public static Stack<Integer> wrongReverseStack(Stack<Integer> stack){
        int elem;
        Stack<Integer> reversed;

        if (stack.isEmpty()) return stack;

        elem = stack.getTop();
        stack.pop();

        reversed = wrongReverseStack(stack);

        reversed.push(elem);
        return reversed;
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stack,Stack<Integer> reversed){
        int elem;
        if (stack.isEmpty()) return reversed;

        elem = stack.getTop();
        reversed.push(elem);
        stack.pop();

        return reverseStack(stack, reversed);
    }
}

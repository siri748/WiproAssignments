package java8Features;

import java.util.Stack;

public class UndoStack {
    public static void main(String[] args) {
        Stack<String> commandStack = new Stack<>();
        commandStack.push("priyanka");
        commandStack.push("bandi");
        commandStack.push("poojitha");
        System.out.println("Stack commands: " + commandStack);

        String undoneCommand = commandStack.pop();
        System.out.println("Undo : " + undoneCommand);
        System.out.println("Stack undo: " + commandStack);

        commandStack.push(undoneCommand);
        System.out.println("Stack redo: " + commandStack);
    }
}

import java.util.Scanner;

// Step 1: Define Stack Interface
interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
}

// Step 2: Implement Stack using Array
class ArrayStack<T> implements Stack<T> {
    private Object[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        capacity = size;
        stack = new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
            return;
        }
        stack[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return (T) stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

// Step 3: Text Editor with Undo Feature
class TextEditor {
    private String text = "";
    private Stack<String> history;

    public TextEditor(Stack<String> stack) {
        this.history = stack;
    }

    public void type(String newText) {
        history.push(text); // Save current state before change
        text += newText;
    }

    public void delete(int count) {
        if (count > text.length()) count = text.length();
        history.push(text); // Save current state before change
        text = text.substring(0, text.length() - count);
    }

    public void undo() {
        String prev = history.pop();
        if (prev != null) {
            text = prev;
        }
    }

    public void display() {
        System.out.println("Current Text: " + text);
    }
}

// Step 4: Main Class
public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor(new ArrayStack<>(100));

        while (true) {
            System.out.println("\n1. Type");
            System.out.println("2. Delete");
            System.out.println("3. Undo");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to type: ");
                    String input = sc.nextLine();
                    editor.type(input);
                    break;
                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    int count = sc.nextInt();
                    editor.delete(count);
                    break;
                case 3:
                    editor.undo();
                    break;
                case 4:
                    editor.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


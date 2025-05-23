package stack;

public class Stack<T> implements SimpleStack<T> {

	private Node<T> top;

	private static class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
		}
	}

	@Override
	public void push(T item) {
		Node<T> node = new Node<>(item);
		node.next = top;
		top = node;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new Underflow("Stack Underflow: pop() on empty stack");
		}
		T value = top.value;
		top = top.next;
		return value;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new Underflow("Stack Underflow: peek() on empty stack");
		}
		return top.value;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public T top() {
		if (isEmpty()) {
			throw new Underflow("Stack Underflow: top() on empty stack");
		}
		return top.value;
	}

	@Override
	public String toString() {
		if (top == null) return "<empty>";

		StringBuilder sb = new StringBuilder();
		buildToString(top, sb);
		return sb.toString();
	}

	private void buildToString(Node<T> node, StringBuilder sb) {
		if (node.next != null) {
			buildToString(node.next, sb);
			sb.append("-");
		}
		sb.append(node.value);
	}



}


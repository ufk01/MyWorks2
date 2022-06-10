package hangman;

import java.util.ArrayList;

public class LinkedList {
	Node head;
	int size, size2 = 0;
	char arr[] = new char[100];

	public LinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty(Node head) {
		return head == null;
	}

	public void add(Node n) {
		if (isEmpty(head)) {
			head = n;
			arr[size] = '_';
			size++;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node temp = new Node(n.data);
			current.next = temp;
			temp.next = null;
			arr[size] = '_';
			size++;
		}

	}

	public void findingChar(char n) {
		if (isEmpty(head)) {
			return;
		} else {
			Node current = head;
			while (current != null) {
				if (Character.toUpperCase(current.data) == Character.toUpperCase(n)) {
					arr[size2] = n;

				}
				current = current.next;
				size2++;

			}
		}
		size2 = 0;

	}

	public void print() {
		int temp = 0;
		while (arr[temp] != '\0') {
			System.out.print(arr[temp] + " ");
			temp++;
		}
		System.out.println();
	}

	public boolean checkWord(String word) {
		int length = word.length();
		int s = 0, i = 0, temp = 1;
		ArrayList<Character> temp2 = new ArrayList<Character>();
		if (isEmpty(head)) {
			return false;
		} else {
			Node current = head;
			while (current != null) {
				while (i < length) {
					if (Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(current.data) || word.charAt(i) == ' ') {
						temp2.add(word.charAt(i));
						break;
					}
					i++;
				}
				i = 0;
				i += temp;
				current = current.next;
			}
			if (temp2.size() == length) {				
				return true;
			}
		}

		return false;
	}

}

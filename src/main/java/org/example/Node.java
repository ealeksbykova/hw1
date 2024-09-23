package org.example;

import lombok.Getter;
import lombok.Setter;


/**
 * Реализация базовой структуры односвязного списка
 * При необходимости, можно доработать реализацию
 *
 * @param <T>
 */
@Getter
@Setter
public class Node<T> {

    private T value;

    private Node<T> next;

    private int size;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> add(T value) {
        Node<T> emptyNode = this;
        size = 1;
        while (emptyNode.getNext() != null) {
            emptyNode = emptyNode.getNext();
            ++size;
        }
        Node<T> newNode = new Node<>(value);
        emptyNode.setNext(newNode);
        ++size;
        return newNode;
    }
}

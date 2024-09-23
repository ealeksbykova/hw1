package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HomeWorkTest {

    HomeWork homeWork;
    Node<Integer> node;
    Predicate<Integer> divisionPred;
    Predicate<Integer> comparisonPred;

    @BeforeEach
    void setUp() {
        homeWork = new HomeWork();
        node = generateNodeCollection();
        divisionPred = generateDivisionPredicate();
        comparisonPred = generateComparsionPredicate();
    }

    @Test
    @DisplayName("Успешный подсчет подходящих по условию узлов: использованы корректые данные")
    void partitionBy_SuccessTest_CorrectData() {
        assertEquals(4, homeWork.partitionBy(node, divisionPred));
        assertEquals(3, homeWork.partitionBy(node, comparisonPred));
    }

    @Test
    @DisplayName("Ошибка подсчета подходящих по условию узлов: использованы некорректые данные")
    void partitionBy_FailTest_IncorrectData() {
        assertEquals(-1, homeWork.partitionBy(null, divisionPred));
        assertEquals(-1, homeWork.partitionBy(node, null));
    }

    @Test
    @DisplayName("Успешный поиск элемента на позиции N в списке: использованы корректые данные")
    void findNthElement_SuccessTest_CorrectData() {
        assertEquals(4, homeWork.findNthElement(node, 4));
        assertEquals(3, homeWork.findNthElement(node, 0));
        assertEquals(1000, homeWork.findNthElement(node, node.getSize() - 1));
    }

    @Test
    @DisplayName("Ошибка поиска элемента на позиции N в списке: использованы некорректые данные")
    void findNthElement_FailTest_IncorrectData() {
        assertNull(homeWork.findNthElement(null, 6));
        assertNull(homeWork.findNthElement(node, 8));
        assertNull(homeWork.findNthElement(node, Integer.MAX_VALUE));
    }

    private Node<Integer> generateNodeCollection() {
        Node<Integer> node = new Node<>(3);
        node.add(9);
        node.add(99);
        node.add(-33);
        node.add(4);
        node.add(-3);
        node.add(6);
        node.add(1000);

        return node;
    }

    private Predicate<Integer> generateDivisionPredicate() {
        return i -> i % 3 == 0;
    }

    private Predicate<Integer> generateComparsionPredicate() {
        return i -> i > 0;
    }
}

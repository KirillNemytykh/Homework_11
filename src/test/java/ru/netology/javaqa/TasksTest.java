package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void SimpleTaskMatchesQuery() {
        SimpleTask task = new SimpleTask(11, "Пропылесосить квартиру");

        boolean actual = task.matches("Пропылесосить");
        boolean expected = true; //Совпадает заголовок

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskNotMatchesQuery() {
        SimpleTask task = new SimpleTask(11, "Пропылесосить квартиру");

        boolean actual = task.matches("Помыть");
        boolean expected = false; //Не совпадает заголовок

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicTaskMatchesQuery() {
        String[] subtasks = {"Молоко", "Сыр", "Хлеб"};
        Epic task = new Epic(11, subtasks);

        boolean actual = task.matches("Сыр");
        boolean expected = true; //Совпадает пункт подзадач

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicTaskNotMatchesQuery() {
        String[] subtasks = {"Молоко", "Сыр", "Хлеб"};
        Epic task = new Epic(11, subtasks);

        boolean actual = task.matches("Сметана");
        boolean expected = false; //Не совпадает пункт подзадач

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingTopicMatchesQuery() {
        Meeting task = new Meeting(11, "Собеседование", "Работа", "12.00");

        boolean actual = task.matches("Собеседование");
        boolean expected = true; //Совпадает тема

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingProjectMatchesQuery() {
        Meeting task = new Meeting(11, "Собеседование", "Работа", "12.00");

        boolean actual = task.matches("Работа");
        boolean expected = true; //Совпадает цель

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingProjectAndTopicNotMatchesQuery() {
        Meeting task = new Meeting(11, "Собеседование", "Работа", "12.00");

        boolean actual = task.matches("Уборка");
        boolean expected = false; //Не совпадает тема и цель

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingStartMatchesQuery() {
        Meeting task = new Meeting(11, "Собеседование", "Работа", "12.00");

        boolean actual = task.matches("12.00");
        boolean expected = false; //Проверяем совпадение по поиску времени старта

        Assertions.assertEquals(expected, actual);
    }

}

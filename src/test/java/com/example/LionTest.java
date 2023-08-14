package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline felineMock;
    // получить количество котят
    @Test
    public void getLionKittens() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        System.out.println(lion.getKittens());
    }
    // сравнить два верных значения
    @Test
    public void shouldBeTwoKittensMeaningEquals() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        assertEquals("Должно возвращаться 1", 1, actual);
    }
    // мок Проверить, сколько раз вызвали метод
    @Test
    public void test() {
        felineMock.getKittens();
        felineMock.getKittens();
        felineMock.getKittens();
        felineMock.getKittens();
        Mockito.verify(felineMock, Mockito.times(4)).getKittens();
    }
    // получить список еды для львов
    @Test
    public void getLionFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        System.out.println(feline.eatMeat());
    }
    // сравнить два списка с едой
    @Test
    public void shouldBeTwoLionFoodEquals() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals("Лев - хищник. И ему нужно мясо!", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
    // мок на проверку аргументов
    @Test
    public void testFood() throws Exception {
        felineMock.getFood("Хищник");
        Mockito.verify(felineMock).getFood("Хищник");
    }
    // обработка исключения по полу
    @Test
    public void doesHaveManeException() {
        Feline feline = new Feline();
        try {
            Lion lion = new Lion("Не самец", feline);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    @Test
    public void doesHaveMane() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        System.out.println(lion.doesHaveMane());
    }
}
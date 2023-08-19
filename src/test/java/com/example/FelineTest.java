package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    // получить название семейства
    public void getNameFamily() {
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        assertEquals(feline.getFamily(), expectedResult);
    }
    // сравнить два названия семейства
    @Test
    public void shouldBeTwoNamesFamilyEquals() {
        Feline feline = new Feline();
        Assert.assertEquals("Неверное значение! Должно быть семейство кошачьих", "Кошачьи", feline.getFamily());
    }
    // мок Проверить аргументы
    @Test
    public void checkArgumentsMock() {
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }
    // получить список еды
    @Test
    public void getListWhoEatMeat() throws Exception{
            Feline feline = new Feline();
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
            List<String> actualFood = feline.eatMeat();
            Assert.assertEquals(expectedFood, actualFood);
    }
    // сравнить два списка с едой
    @Test
    public void shouldBeTwoListWhoEatMeatEquals() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals("Хищники относятся к семейству кошачьих", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    // получить количество котят
    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int expectedCount = 1;
        int actualCount = feline.getKittens();
        Assert.assertEquals(expectedCount, actualCount);
    }
    // сравнить два неверных значения
    @Test
    public void shouldBeTwoKittensMeaningNotEquals() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertNotEquals("Не должно возвращаться 1", 3, actual);
    }
}

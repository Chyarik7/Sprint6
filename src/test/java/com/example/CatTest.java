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
public class CatTest {
    @Mock
    Cat catMock;

    // получить, что говорит кошка
    @Test
    public void getSoundCat() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        System.out.println(cat.getSound());
    }
    // сравнить два звука
    @Test
    public void shouldBeTwoSoundsEquals() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кошка должна говорить Мяу", "Мяу", cat.getSound());
    }
    // мок Проверить аргументы
    @Test
    public void checkArgumentsMock() {
        catMock.getSound();
        Mockito.verify(catMock).getSound();
    }
    // получить список кошачьей еды
    @Test
    public void getCatFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        System.out.println(cat.getFood());
    }
    // сравнить два списка кошачьей еды
    @Test
    public void shouldBeTwoFoodEquals() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кошке нужно мясо, так как она Хищник", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
    // мок Проверить, сколько раз вызвали метод
    @Test
    public void howManyTimesOtherMethodCalledMock() throws Exception {
        catMock.getFood();
        catMock.getFood();
        catMock.getFood();
        Mockito.verify(catMock, Mockito.times(3)).getFood();
    }
}
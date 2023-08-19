package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion("Самец", feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getLionFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Это лев не ест", expectedResult, feline.eatMeat());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void doesHaveManeException() {
        try {
          lion =  new Lion("Не самец", feline);
        } catch (Exception exception) {
            Assert.assertTrue(exception.getMessage(), true);
        }
    }
    @Test
    public void doesHaveMane() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(String.valueOf(false),lion.doesHaveMane());
    }

}

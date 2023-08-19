package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTestWithParameters {
    private final String foodList;
    private final List expected;
    public AnimalTestWithParameters(String foodList, List expected) {
        this.foodList = foodList;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getFoodList() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void shouldCheckGetFood() throws Exception {
        Animal animal = new Animal();
        List actual = animal.getFood(foodList);
        assertEquals(expected, actual);
    }
}
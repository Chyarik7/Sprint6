package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestWithParameters {
    Feline feline;

    private final String gender;
    private final boolean expected;

    public LionTestWithParameters(String gender, boolean expected) {
        this.gender = gender;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    // сравнить пол льва, используя параметризацию
    @Test
    public void shouldBeMane() throws Exception {
        Lion lion = new Lion(gender, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}

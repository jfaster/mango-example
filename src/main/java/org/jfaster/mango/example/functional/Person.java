package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.enums.EnumToIntegerFunction;
import org.jfaster.mango.invoker.function.enums.IntegerToEnumFunction;

/**
 * @author ash
 */
public class Person {

    private int id;

    private String name;

    private Gender gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Getter(EnumToIntegerFunction.class)
    public Gender getGender() {
        return gender;
    }

    @Setter(IntegerToEnumFunction.class)
    public void setGender(Gender gender) {
        this.gender = gender;
    }

}

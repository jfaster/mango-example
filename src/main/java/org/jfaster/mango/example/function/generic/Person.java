package org.jfaster.mango.example.function.generic;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.enums.EnumToStringFunction;
import org.jfaster.mango.invoker.function.enums.StringToEnumFunction;
import org.jfaster.mango.invoker.function.json.GsonToObjectFunction;
import org.jfaster.mango.invoker.function.json.ObjectToGsonFunction;

/**
 * @author ash
 */
public class Person {

    private int id;
    private String name;
    private Gender gender;
    private Card card;

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

    @Getter(EnumToStringFunction.class)
    public Gender getGender() {
        return gender;
    }

    @Setter(StringToEnumFunction.class)
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Getter(ObjectToGsonFunction.class)
    public Card getCard() {
        return card;
    }

    @Setter(GsonToObjectFunction.class)
    public void setCard(Card card) {
        this.card = card;
    }
}

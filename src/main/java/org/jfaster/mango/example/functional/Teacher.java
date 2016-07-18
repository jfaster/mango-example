package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.IntegerListToStringFunction;
import org.jfaster.mango.invoker.function.StringToIntegerListFunction;

import java.util.List;

/**
 * @author ash
 */
public class Teacher {

    private int id;

    private String name;

    private List<Integer> studentIds;

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

    @Getter(IntegerListToStringFunction.class)
    public List<Integer> getStudentIds() {
        return studentIds;
    }

    @Setter(StringToIntegerListFunction.class)
    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

}

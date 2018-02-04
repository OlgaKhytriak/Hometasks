package com.epam.decoratorpattern.elements;
public interface InputTextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);
}

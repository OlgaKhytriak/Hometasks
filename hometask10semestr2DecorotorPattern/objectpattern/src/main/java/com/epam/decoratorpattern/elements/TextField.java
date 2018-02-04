package com.epam.decoratorpattern.elements;

import org.openqa.selenium.Keys;

public interface TextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);
    
    void click();

	void type(Keys keys);
}

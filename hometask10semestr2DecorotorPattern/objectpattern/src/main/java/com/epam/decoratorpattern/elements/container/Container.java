package com.epam.decoratorpattern.elements.container;

import org.openqa.selenium.WebElement;

import com.epam.decoratorpattern.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}

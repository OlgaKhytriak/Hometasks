package com.epam.decoratorpattern.elements;

import org.openqa.selenium.WebElement;

class InputTextFieldImpl extends AbstractElement implements InputTextField {
    protected InputTextFieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        wrappedElement.sendKeys(text);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        type(text);
    }
}

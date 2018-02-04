package com.epam.decoratorpattern.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

class TextFieldImpl extends AbstractElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {
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

	@Override
	public void click() {
		wrappedElement.click();
		
	}

	@Override
	public void type(Keys keys) {
		wrappedElement.sendKeys(keys);
		
	}
}

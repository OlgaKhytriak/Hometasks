package com.epam.finalproject.xml.jaxbadapter;

import java.io.File;

public interface Object2Xml {
	public <T> T load(File file);
    public <T> void save(File file, T object);
}

package com.epam.lab.task14.patterns.adapter;

import java.io.File;

public interface Object2Xml {
	public <T> T load(Class<T> clazz,File file);
    public <T> void save(File file, T object);
}

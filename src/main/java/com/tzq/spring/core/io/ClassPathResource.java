package com.tzq.spring.core.io;

import com.tzq.spring.util.ClassUtils;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Data
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException(this.path
                    + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}

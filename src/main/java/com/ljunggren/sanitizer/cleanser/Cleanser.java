package com.ljunggren.sanitizer.cleanser;

public interface Cleanser<T> {

    String cleanse(T value);
    String description();
}

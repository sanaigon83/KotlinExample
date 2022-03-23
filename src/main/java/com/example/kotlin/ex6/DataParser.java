package com.example.kotlin.ex6;

import java.util.List;

public interface DataParser<T> {
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}

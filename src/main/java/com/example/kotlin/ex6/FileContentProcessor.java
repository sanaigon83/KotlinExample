package com.example.kotlin.ex6;

import java.io.File;
import java.util.List;

interface FileContentProcessor {
    void processContents(
            File path,
            byte[] binaryContents,
            List<String> textContents
    );
}

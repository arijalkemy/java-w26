package org.example.be_java_hisp_w26_g04.service;

import org.example.be_java_hisp_w26_g04.BeJavaHispW26G04Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BeJavaHispW26G04ApplicationTest {
    @Test
    @DisplayName("App loads without errors")
    public void contextLoads() {
        Assertions.assertDoesNotThrow(() -> BeJavaHispW26G04Application.main(new String[]{}));
    }
}

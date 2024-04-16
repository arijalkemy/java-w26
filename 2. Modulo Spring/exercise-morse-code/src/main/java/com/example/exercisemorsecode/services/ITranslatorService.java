package com.example.exercisemorsecode.services;

public interface ITranslatorService {
    String alphanumericToMorse(String alphanumericText);
    String morseToAlphanumeric(String morseText);
}

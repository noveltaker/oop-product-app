package org.example.service.input;

public interface Input<T> {
  T getInput(String prompt);
}

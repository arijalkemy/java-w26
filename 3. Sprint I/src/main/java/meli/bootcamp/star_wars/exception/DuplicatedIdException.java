package meli.bootcamp.star_wars.exception;

public class DuplicatedIdException extends RuntimeException {
  public DuplicatedIdException(String msg) {
    super(msg);
  }
}

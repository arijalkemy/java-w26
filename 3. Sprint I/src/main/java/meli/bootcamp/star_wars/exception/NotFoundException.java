package meli.bootcamp.star_wars.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String msg) {
    super(msg);
  }
}

package Exceptions;

public class ItemDuplicated extends RuntimeException{
  public ItemDuplicated(String msg){
    super(msg);
  }
}

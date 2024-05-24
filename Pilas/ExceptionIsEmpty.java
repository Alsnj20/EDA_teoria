package Pilas;

public class ExceptionIsEmpty extends Exception{
  public ExceptionIsEmpty(){
    super("La pila esta vacia");
  }
  
  public ExceptionIsEmpty(String message){
    super(message);
  }
}

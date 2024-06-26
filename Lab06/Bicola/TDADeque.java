package Bicola;
public interface TDADeque<T> {
  public void agregarFrente(T x);
  public void agregarFinal(T x);
  public T removerFrente();
  public T removerFinal();
  public boolean estaVacia();
  public int tamano();
}
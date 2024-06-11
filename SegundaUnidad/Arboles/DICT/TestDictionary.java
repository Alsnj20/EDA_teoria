package DICT;

public class TestDictionary {
  public static void main(String[] args) {
    DictionaryBST<Integer, String> dict = new DictionaryBST<Integer, String>();
    try{
      dict.insert(1, "uno");
      dict.insert(2, "dos");
      dict.insert(4, "cuatro");
      dict.insert(6, "seis");
      dict.insert(0, "cero");
      System.out.println(dict.search(1));
      System.out.println(dict.search(2));
      dict.printDict();

    }catch(Exception e){
      System.out.println(e);
    }
  }
}

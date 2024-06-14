package DICT;

public class TestDictionary {
  public static void main(String[] args) {
    DictionaryAVL<Integer, String> dict = new DictionaryAVL<Integer, String>();
    try{
      dict.insert(3, ":)");
      dict.insert(5, ":(");
      dict.insert(7, ":D");
      dict.insert(8, ":O");
      dict.insert(9, ":P");
      dict.insert(10, ":Q");
      dict.insert(11, ":|");
      dict.insert(12, " ♥");
      dict.printDict();

    }catch(Exception e){
      System.out.println(e);
    }
  }
}

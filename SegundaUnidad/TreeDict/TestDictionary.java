package TreeDict;

public class TestDictionary {
  public static void main(String[] args) {
    DictionaryBST<Integer, String> dict = new DictionaryBST<Integer, String>();
    try{
      dict.insert(3, "-");
      dict.insert(5, ":-");
      dict.insert(7, ":-");
      dict.insert(8, ":o");
      dict.printDict();

    }catch(Exception e){
      System.out.println(e);
    }
  }
}

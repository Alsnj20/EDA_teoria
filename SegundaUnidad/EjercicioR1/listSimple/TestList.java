package EjercicioR1.listSimple;

public class TestList {
    public static void main(String[] args) {
        System.out.println("Lista Enteros");
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.add(4);
        list.addKesimo(12, 4);
        list.addKesimo(14, 8);
        list.addKesimo(14, -2);
        System.out.println(list.toString());
        System.out.println("Lista de Caracteres");
        LinkedList<Character> list2 = new LinkedList<>();
        list2.addFirst('a');
        list2.addFirst('b');
        list2.addLast('c');
        list2.addLast('d');
        list2.destroyList();
        list2.addKesimo('e', 4);
        list2.addKesimo('f', 8);
        list2.addKesimo('g', -2);
        System.out.println(list2.toString());
        System.out.println("Lista Inicializada");
        list2.initializeList();
        list2.add('a');
        System.out.println(list2.toString());
    }
}

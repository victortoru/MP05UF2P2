package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void count() {

    }

    @Test
    void size() {
    }

    @Test
    void put_buida() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        System.out.println(
                hashTable.getCollisionsForKey("1", 4)
        );
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]", hashTable.toString());

        Assertions.assertEquals(16, hashTable.size());
        Assertions.assertEquals(1, hashTable.count());
    }

    @Test
    void put_no_buida() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_2a() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("35", "Element 35");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2] -> [35, Element 35]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_3a() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("3", "Element 3");
        hashTable.put("36", "Element 36");
        hashTable.put("47", "Element 47");

        System.out.println(hashTable.getCollisionsForKey("3", 5));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2]\n" +
                " bucket[3] = [3, Element 3] -> [36, Element 36] -> [47, Element 47]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_exist() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("1", "Element remplazado");
        System.out.println(hashTable.getCollisionsForKey("2", 4));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element remplazado]\n" +
                " bucket[2] = [2, Element 2]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_exist1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("24", "Element 24");
        hashTable.put("2", "Element reemplazado");
        System.out.println(hashTable.getCollisionsForKey("2", 4));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element reemplazado] -> [24, Element 24]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_exist2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("24", "Element 24");
        hashTable.put("24", "Element reemplazado");
        System.out.println(hashTable.getCollisionsForKey("2", 4));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2] -> [24, Element reemplazado]", hashTable.toString()
        );
    }

    @Test
    void put_no_buida_exist3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("24", "Element 24");
        hashTable.put("35", "Element 35");
        hashTable.put("35", "Element reemplazado");
        System.out.println(hashTable.getCollisionsForKey("2", 4));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2] -> [24, Element 24] -> [35, Element 35] -> [35, Element reemplazado]", hashTable.toString()
        );
    }


    @Test
    void get_element_buit() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        System.out.println(hashTable.getCollisionsForKey("1", 3));

        Assertions.assertEquals("Element 1", hashTable.get("1"));
    }

    @Test
    void get_element_buit1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("13", "Element 13");
        System.out.println(hashTable.getCollisionsForKey("2", 3));

        Assertions.assertEquals("Element 2", hashTable.get("2")
        );
    }

    @Test
    void get_element_buit2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("13", "Element 13");
        hashTable.put("24", "Element 24");
        System.out.println(hashTable.getCollisionsForKey("2", 3));

        Assertions.assertEquals("Element 2", hashTable.get("2")
        );
    }

    @Test
    void get_element_buit3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("13", "Element 13");
        hashTable.put("24", "Element 24");
        hashTable.put("35", "Element 35");
        System.out.println(hashTable.getCollisionsForKey("2", 4));

        Assertions.assertEquals("Element 2", hashTable.get("2")
        );
    }

    @Test
    void drop_no_colisiona() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("3", "Element 3");
        hashTable.put("14", "Element 14");
        hashTable.put("25", "Element 25");
        hashTable.put("36", "Element 36");
        System.out.println(hashTable.getCollisionsForKey("3", 4));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[3] = [3, Element 3] -> [14, Element 14] -> [25, Element 25] -> [36, Element 36]", hashTable.toString()
        );
    }

    @Test
    void drop_si_colisiona1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("3", "Element 3");
        hashTable.put("14", "Element 14");
        System.out.println(hashTable.getCollisionsForKey("3", 4));

        hashTable.drop("14");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[3] = [3, Element 3]", hashTable.toString()
        );

    }

    @Test
    void drop_si_colisiona2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("3", "Element 3");
        hashTable.put("14", "Element 14");
        hashTable.put("25", "Element 25");
        System.out.println(hashTable.getCollisionsForKey("3", 4));

        hashTable.drop("25");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[3] = [3, Element 3] -> [14, Element 14]", hashTable.toString()
        );
    }

    @Test
    void drop_si_colisiona3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("3", "Element 3");
        hashTable.put("14", "Element 14");
        hashTable.put("25", "Element 25");
        hashTable.put("36", "Element 36");
        System.out.println(hashTable.getCollisionsForKey("3", 4));

        hashTable.drop("36");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[3] = [3, Element 3] -> [14, Element 14] -> [25, Element 25]", hashTable.toString()
        );
    }

    @Test
    void drop_no_existeix() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("3", "Element 3");
        hashTable.put("14", "Element 14");
        hashTable.put("36", "Element 36");
        System.out.println(hashTable.getCollisionsForKey("3", 4));

        hashTable.drop("25");

        Assertions.assertNull(hashTable.get("25"));
    }
}
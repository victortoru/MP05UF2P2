package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                hashTable.getCollisionsForKey("1",4)
        );
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]",hashTable.toString());
    }
    @Test
    void put_no_buida() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2]",hashTable.toString()
        );
    }

    @Test
    void put_no_buida_2a() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Element 1");
        hashTable.put("2", "Element 2");
        hashTable.put("35", "Element 35" );
        System.out.println(hashTable.getCollisionsForKey("2",5));

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, Element 1]\n" +
                " bucket[2] = [2, Element 2] -> [35, Element 35]",hashTable.toString()
        );
    }

    @Test
    void get() {
    }

    @Test
    void drop() {
    }
}
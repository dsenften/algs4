package ch.ffhs.hash;

public class Overflow {

    public static void main(String[] args) {
        int hash = "polygenelubricants".hashCode();
        System.out.println("hash  = " + hash + "\n % 31 = " + hash % 31);
    }
}

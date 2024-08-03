// 705

import java.util.*;

class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println(hs.contains(1));
        System.out.println(hs.contains(3));
        hs.remove(2);
        System.out.println(hs.contains(2));
    }
}

class MyHashSet {

    // not a proper solution
    
    ArrayList<Integer> al;

    public MyHashSet() {
        al = new ArrayList<>();
    }
    
    public void add(int key) {
        if (al.isEmpty() || !this.contains(key)) {
            al.add(key);
        }
    }
    
    public void remove(int key) {
        if (this.contains(key))
            al.remove(al.indexOf(key));  
    }
    
    public boolean contains(int key) {
        if (al.isEmpty()) {
            
        } else {
            for (int x:al) {
            if (x == key)
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
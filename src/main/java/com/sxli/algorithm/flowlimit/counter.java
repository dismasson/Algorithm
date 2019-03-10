package main.java.com.sxli.algorithm.flowlimit;

/**
 * 高并发系统的限流：计数器限流
 */
public class counter {



    /*public static void main(String[] args) {
        *//*
        * HashMap是线程不安全的原因是内部没有使用Synchronized
        *//*
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("key", "value");
        hashMap.get("key");

        *//*
         *HashTable是线程安全的，原因是内部使用了Synchronized
         *//*
        Hashtable<String, Object> hashTable = new Hashtable<>();
        hashTable.put("key", "value");
        hashTable.get("key");

        *//*
         *synchronizedMap是线程安全的，是Collections提供的一个线程安全的静态方法
         *//*
        Map<String, Object> map = Collections.synchronizedMap(new HashMap<String, Object>());
        map.put("key", "value");
        map.get("key");

        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
    }*/
}

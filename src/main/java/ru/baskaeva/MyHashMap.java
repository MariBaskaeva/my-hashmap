package ru.baskaeva;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] buckets;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int keyHash = calculateBucket(key);
        if(buckets[keyHash] != null) {
            LinkedList<Node<K, V>> bucket = buckets[keyHash];
            for (Node<K, V> node : bucket) {
                if(node.getKey().equals(key))
                    return node.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int keyHash = calculateBucket(key);
        LinkedList<Node<K, V>> bucket = buckets[keyHash];

        for(Node<K, V> node: bucket) {
            if(node.getKey().equals(key)) {
                V prevVal = node.getValue();
                node.setValue(value);
                return prevVal;
            }
        }
        bucket.add(new Node<>(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        int keyHash = calculateBucket(key);
        LinkedList<Node<K, V>> bucket = buckets[keyHash];
        for(Node<K, V> node: bucket) {
            if(node.getKey().equals(key)) {
                V prevVal = node.getValue();
                bucket.remove(node);
                return prevVal;
            }
        }
        return null;
    }

    public int calculateBucket(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}

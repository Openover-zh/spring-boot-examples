package com.neo.pojo;

import java.util.Collection;
import java.util.HashSet;

public class HashSetDemo<E> extends HashSet<E> {
    private int addCount = 0;

    public HashSetDemo() {
    }

    public HashSetDemo(Collection<? extends E> c) {
        super(c);
    }

    public HashSetDemo(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public HashSetDemo(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

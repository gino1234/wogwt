package com.webobjects.foundation;

import java.util.Map;

/**
 * Fully implemented except for NSKeyValueCodingAdditions
 */
public class NSMutableDictionary<K,V> extends NSDictionary<K,V> {

	public NSMutableDictionary() {
		super();
	}
	
	public NSMutableDictionary(int capacity) {
		super(capacity);
	}
	
	public NSMutableDictionary(Map<K,V> map) {
		super(map);
	}
	
	public NSMutableDictionary(NSArray<V> objects, NSArray<K> keys) {
		super(objects, keys);
	}
	
	public NSMutableDictionary(NSMutableDictionary<K,V> otherDictionary) {
		super(otherDictionary);
	}
	
	public NSMutableDictionary(V[] objects, K[] keys) {
		super(objects, keys);
	}
	
	public NSMutableDictionary(V object, K key) {
		super();
		put(key, object);
	}
	
	public void addEntriesFromDictionary(NSDictionary otherDictionary) {
		putAll(otherDictionary);
	}
	
	public NSDictionary<K, V> immutableClone() {
		return new NSDictionary<K, V>(this);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public V removeObjectForKey(Object key) {
		return (V)remove(key);
	}
	
	public void removeObjectsForKeys(NSArray keys) {
		if (keys == null)
			return;
		for (int i = 0; i < keys.size(); i++) {
			remove(keys.get(i));
		}
	}
	
	public void setDictionary(NSDictionary otherDictionary) {
		clear();
		putAll(otherDictionary);
	}
	
	public void setObjectForKey(V object, K key) {
		put(key, object);
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		put((K)key, (V)value);
	}
	
	@Override
	public void takeValueForKeyPath(Object value, String keyPath) {
		String firstKey;
		String restOfKeyPath = null;
		int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
		if (dotIndex == -1) {
			firstKey = keyPath;
		} else {
			firstKey = keyPath.substring(0, dotIndex);
			if (keyPath.length()-1 > dotIndex) {
				restOfKeyPath = keyPath.substring(dotIndex+1);
			}
		}

		Object firstValue = get(firstKey);
		if (firstValue != null && 
				(firstValue instanceof NSKeyValueCodingAdditions)
				&& restOfKeyPath != null) {
			((NSKeyValueCodingAdditions)firstValue).takeValueForKeyPath(value, restOfKeyPath);
		} else {
			takeValueForKey(value, keyPath);
		}
	}
	
	@Override
	public void clear() {
		superDotClear();
	}
	
	@Override
	public Object clone() {
		return mutableClone();
	}
	
	@Override
	public V put(K key, V value) {
		return superDotPut(key, value);
	}
	
	@Override
	public void putAll(Map m) {
		superDotPutAll(m);
	}
	
	@Override
	public V remove(Object key) {
		return superDotRemove(key);
	}
}

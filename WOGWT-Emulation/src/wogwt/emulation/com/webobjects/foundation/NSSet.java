package com.webobjects.foundation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;

public class NSSet<E> extends HashSet<E> {

	public static final transient boolean CheckForNull = true;
	public static final transient NSSet EmptySet = new NSSet();
	public static final transient boolean IgnoreNull = true;
	
	private static final transient String UNSUPPORTED = " is not a supported operation in com.webobjects.foundation.NSSet";
	protected static final transient String NULL_NOT_ALLOWED = "Attempt to insert null into an NSArray.";
	
	public NSSet() {
		super();
	}
	
	protected NSSet(int capacity) {
		super(capacity);
	}
	
	public NSSet(Collection<? extends E> collection) {
		super();
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			E element = (E) iterator.next();
			superDotAdd(element);
		}
	}
	
	public NSSet(E object) {
		super();
		superDotAdd(object);
	}
	
	public NSSet(E[] objects) {
		super();
		for (int i = 0; i < objects.length; i++) {
			superDotAdd(objects[i]);
		}
	}
	
	public NSSet(NSArray<? extends E> objects) {
		super();
		for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
			E element = (E) iterator.next();
			superDotAdd(element);
		}
	}
	
	public NSSet(NSSet<? extends E> otherSet) {
		super();
		NSArray<? extends E> objects = otherSet.allObjects();
		for (int i = 0; i < objects.size(); i++) {
			superDotAdd(objects.get(i));
		}
	}
	
	public NSSet(Set<? extends E> set, boolean checkForNull) {
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			if (e == null) {
				if (checkForNull) {
					throw new IllegalArgumentException(NULL_NOT_ALLOWED);
				} else {
					throw new NullPointerException();
				}
			} else {
				superDotAdd(e);
			}
		}
	}
	
	@Override
	public boolean add(E o) {
		throw new UnsupportedOperationException("add" + UNSUPPORTED);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException("addAll" + UNSUPPORTED);
	}
	
	public NSArray<E> allObjects() {
		NSMutableArray<E> result = new NSMutableArray<E>();
		for (Iterator iterator = iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			result.add(e);
		}
		return result.immutableClone();
	}
	
	public E anyObject() {
		if (isEmpty())
			return null;
		
		int index;
		if (GWT.isScript()) {
			index = Random.nextInt(size());
		} else {
			index = 0;
		}
		return (E) allObjects().get(index);
	}
	
	@Override
	public void clear() {
		throw new UnsupportedOperationException("clear" + UNSUPPORTED);
	}
	
	@Override
	public Object clone() {
		return this;
	}
	
	public boolean containsObject(Object object) {
		return contains(object);
	}
	
	public int count() {
		return size();
	}
	
	public static <T> NSSet<T> emptySet() {
		return EmptySet;
	}
	
	public HashSet<E> hashSet() {
		return this;
	}
	
	public NSSet<E> immutableClone() {
		return this;
	}
	
	public boolean intersectsSet(NSSet otherSet) {
		NSArray thisObjects = allObjects();
		NSArray otherObjects = otherSet.allObjects();
		
		for (int i = 0; i < otherObjects.size(); i++) {
			if (thisObjects.contains(otherObjects.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEqualToSet(NSSet otherSet) {
		return equals(otherSet);
	}
	
	public boolean isSubsetOfSet(NSSet otherSet) {
		NSArray thisObjects = allObjects();
		NSArray otherObjects = otherSet.allObjects();
		
		for (int i = 0; i < thisObjects.size(); i++) {
			if (!otherObjects.contains(thisObjects.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public Object member(Object object) {
		NSArray<E> objects = this.allObjects();
		int index = objects.indexOfObject(object);
		if (index != -1) {
			return objects.get(index);
		} else {
			return null;
		}
	}
	
	public NSMutableSet<E> mutableClone() {
		return new NSMutableSet<E>(this);
	}
	
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("remove" + UNSUPPORTED);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("removeAll" + UNSUPPORTED);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("retainAll" + UNSUPPORTED);
	}
	
	public NSSet<E> setByIntersectingSet(NSSet<?> otherSet) {
		NSArray thisObjects = allObjects();
		NSArray otherObjects = otherSet.allObjects();
		NSMutableArray commonObjects = new NSMutableArray();
		
		for (int i = 0; i < thisObjects.size(); i++) {
			if (otherObjects.contains(thisObjects.get(i))) {
				commonObjects.add(thisObjects.get(i));
			}
		}
		
		return new NSSet(commonObjects);
	}
	
	public NSSet<E> setBySubtractingSet(NSSet<?> otherSet) {
		NSSet<E> result = mutableClone();
		result.removeAll(otherSet);
		return result;
	}
	
	public NSSet<E> setByUnioningSet(NSSet<? extends E> otherSet) {
		NSSet<E> result = mutableClone();
		result.addAll(otherSet);
		return result;
	}
	
	protected boolean superDotAdd(E o) {
		if (o == null)
			throw new IllegalArgumentException(NULL_NOT_ALLOWED);
		return super.add(o);
	}
	
	protected boolean superDotAddAll(Collection<? extends E> c) {
		if (c.contains(null))
			throw new IllegalArgumentException(NULL_NOT_ALLOWED);
		return super.addAll(c);
	}
	
	protected void superDotClear() {
		super.clear();
	}
	
	protected boolean superDotRemove(Object o) {
		return super.remove(o);
	}
	
	protected boolean superDotRemoveAll(Collection<?> c) {
		return super.removeAll(c);
	}
	
	protected boolean superDotRetainAll(Collection<?> c) {
		return super.retainAll(c);
	}
	
}

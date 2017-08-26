package database;

import java.util.Collection;

public interface Database<T> {
	public T getIndex();
	
	public void add(T object);
	
	public Collection<T> getAll();
	
	public void remove(T object);
	
	public void remove(int index);
	
	public void addAt(T object, int index);
	
	public void removeAll();
	
	public boolean contains(T object);
	
	public int indexOf(T object);
	
}

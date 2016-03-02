package entities;

public interface Repository {
	
	public void persist (Entity entity);
	public void list (Entity entity);
	public void updateEntity (Entity entity);
	public void remove (Entity entity);
	
}

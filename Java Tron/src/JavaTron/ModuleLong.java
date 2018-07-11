package JavaTron;

public class ModuleLong {

	/**
	 * Souvenir du placement précédent
	 */
	private int x, y;
	private ModuleLong next;
	
	public ModuleLong(int x, int y, ModuleLong next)
	{
		this.x = x;
		this.y = y;
		this.next = next;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ModuleLong getNext() {
		return next;
	}

	public void setNext(ModuleLong next) {
		this.next = next;
	}
	
	public boolean sameValues(ModuleLong other)
	{
		if(other.getX() == this.getX() && this.getY() == other.getY())
			return true;
		else
			return false;
	}
	

	
	
}


public class FileItem  {

	private String name;
	private int size;
	
	public FileItem(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FileItem) {
			FileItem other = (FileItem) obj;
			return name.equals(other.name) && size==other.size;
		} else {
			return false;
		}
	}
}

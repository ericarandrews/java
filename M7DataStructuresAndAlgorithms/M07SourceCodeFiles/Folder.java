import java.util.*;

public class Folder  {
	
	private List<Folder> folders;
	private List<FileItem> files;
	
	private String name;

	public Folder(String name) {
		this.name = name;
		folders = new ArrayList<Folder>();
		files = new ArrayList<FileItem>();
	}

	public List<Folder> getFolders() {
		return folders;
	}
	
	public List<FileItem> getFiles() {
		return files;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public void addFile(FileItem file) {
		files.add(file);
	}
	
	public void addFolder(Folder folder) {
		folders.add(folder);
	}
	
	public int getSizeOfFiles() {
		int fileSize = 0;
		for(FileItem file : files) {
			fileSize += file.getSize();
		}
		return fileSize;
	}
	
	
	public boolean containsFile(FileItem file) {
		if(files.contains(file)) {
			return true;
		} else {
			return false;
		}
	}
}

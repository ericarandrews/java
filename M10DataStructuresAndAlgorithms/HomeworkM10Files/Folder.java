import java.util.*;

public class Folder {

	private List<File> fileList;
	private List<Folder> folderList;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		fileList = new ArrayList<File>();
		folderList = new ArrayList<Folder>();
	}
	

	public String getName() {
		return name;
	}
	
	public List<File> getFileList() {
		return fileList;
	}
	public List<Folder> getFolderList() {
		return folderList;
	}

	public boolean addFile(File file) {
		return fileList.add(file);
	}
	
	public boolean addFolder(Folder folder) {
		return folderList.add(folder);
	}

	@Override
	public String toString() {
		return name;
	}
}

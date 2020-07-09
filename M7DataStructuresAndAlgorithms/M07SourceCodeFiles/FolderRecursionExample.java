import java.util.*;

public class FolderRecursionExample {

	public static void main(String[] args) {
		FileItem aFile = new FileItem("AAA", 11);
		FileItem bFile = new FileItem("BBB", 12);
		FileItem cFile = new FileItem("CCC", 13);
		FileItem dFile = new FileItem("DDD", 14);
		FileItem eFile = new FileItem("EEE", 15);
		FileItem fFile = new FileItem("FFF", 16);
		FileItem gFile = new FileItem("GGG", 17);
		FileItem hFile = new FileItem("HHH", 18);
		FileItem iFile = new FileItem("III", 19);
		FileItem jFile = new FileItem("JJJ", 20);
		FileItem kFile = new FileItem("KKK", 21);
		FileItem lFile = new FileItem("LLL", 22);
		FileItem mFile = new FileItem("MMM", 23);
		FileItem nFile = new FileItem("NNN", 24);
		FileItem oFile = new FileItem("OOO", 25);
		FileItem pFile = new FileItem("PPP", 26);
		
		Folder folder1 = new Folder("Folder1");
		Folder folder2 = new Folder("Folder2");
		Folder folder3 = new Folder("Folder3");
		Folder folder4 = new Folder("Folder4");
		Folder folder5 = new Folder("Folder5");
		Folder folder6 = new Folder("Folder6");
		Folder folder7 = new Folder("Folder7");
		Folder folder8 = new Folder("Folder8");
		Folder folder9 = new Folder("Folder9");
	
		folder1.addFolder(folder2);
		folder1.addFolder(folder3);
		folder1.addFolder(folder4);
		folder2.addFolder(folder5);
		folder2.addFolder(folder6);
		folder3.addFolder(folder7);
		folder3.addFolder(folder8);
		folder7.addFolder(folder9);
		
		folder1.addFile(aFile);
		folder1.addFile(bFile);
		folder2.addFile(cFile);
		folder2.addFile(dFile);
		folder3.addFile(eFile);
		folder4.addFile(fFile);
		folder5.addFile(gFile);
		folder5.addFile(hFile);
		folder6.addFile(iFile);
		folder6.addFile(jFile);
		folder7.addFile(kFile);
		folder7.addFile(lFile);
		folder7.addFile(mFile);
		folder9.addFile(nFile);
		folder9.addFile(oFile);
		folder9.addFile(pFile);
		
		printFolderContents(folder1);
		System.out.println(getFolderSize(folder1));
	}
	
	public static int getFolderSize(Folder topFolder) {
		int size = topFolder.getSizeOfFiles(); // small part we can solve now
		List<Folder> subfolderList = topFolder.getFolders();
		for(Folder subfolder : subfolderList) {
			size = size + getFolderSize(subfolder); // recursive call
			// combining the small part of the solution with the recursive "rest of the solution"
			// AND putting it in a local variable
		}
		// implicit base case- when a folder has no more subfolders the recursion will stop
		return size;
	}
	
	public static void printFolderContents(Folder topFolder) {
		printFolderContentsHelper(topFolder, 0);
	}
	private static void printFolderContentsHelper(Folder topFolder, int indentationIndex) {
		for(int i=0; i<indentationIndex; i++) {
			System.out.print("   ");
		}
		System.out.print(topFolder);
		System.out.println("  Files: " + topFolder.getFiles()); // small part solving now- print the files in the current folder
		List<Folder> subfolderList = topFolder.getFolders();
		for(Folder subfolder : subfolderList) { 
			printFolderContentsHelper(subfolder, indentationIndex+1); // recursive call
		}
		// implicit base case- happens when a folder has no more subfolders- the recursion will end

	}


}

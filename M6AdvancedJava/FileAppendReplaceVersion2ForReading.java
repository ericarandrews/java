import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileAppendReplaceVersion2ForReading {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the file name with the data:");
		String userFile = scan.nextLine();

		Path userInputPath = Paths.get(userFile);

		if (Files.exists(userInputPath)) {

			List<String> fileLines = Files.readAllLines(userInputPath);
			
			for(String line : fileLines) {
			
				Scanner parseScan = new Scanner(line);
				parseScan.useDelimiter(",");
				
				/* IMPORTANT: ASSUMES PERFECTLY FORMATTED DATA FILE! */
				
				String fileName = parseScan.next();
				boolean append = Boolean.parseBoolean(parseScan.next());
				List<String> newTextList = new ArrayList<String>();
				while (parseScan.hasNext()) {
					newTextList.add(parseScan.next());
				}
				
				/* OPTION 1 FOR WRITING */
				/*
				PrintWriter out = new PrintWriter(new FileOutputStream(fileName, append));

				for (String text : newTextList) {
					out.println(text);
				}
				out.close();
				*/
				
				/* OPTION 2 FOR WRITING */
				Path fileToModify = Paths.get(fileName);
				StandardOpenOption howToWrite = append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING;
				Files.write(fileToModify, newTextList, howToWrite);
			
					
		}

			System.out.println("done");
		} else {
			System.out.println("Invalid file.");
		}

	}
}
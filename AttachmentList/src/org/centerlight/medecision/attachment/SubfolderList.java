package org.centerlight.medecision.attachment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class SubfolderList {
	private final static String defaultFolder = "C:\\Users\\FGuo\\Documents\\work doucment\\attachment";
	private File dir;
	private BufferedWriter bf;
	
	private File chooseFile(String defaultFolder){
		JFileChooser fileChooser = new JFileChooser(defaultFolder);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			return fileChooser.getSelectedFile();
		}
		else {
			System.out.println("No file selected\n");
			return null;
		}
	}
	
	public SubfolderList() throws IOException{
		this(defaultFolder);
	}
	public SubfolderList(String folderPath) throws IOException{
		this.dir = chooseFile(folderPath);
		bf = new BufferedWriter(new FileWriter(new File("C:\\Users\\FGuo\\Documents\\work doucment\\attachment\\try2.txt")));
	}
	public File getFileFolder(){
		return this.dir;
	}
	
	public void listFolderName(File fileFolder) throws IOException{
		File[] subDirs = fileFolder.listFiles(new FileFilter() {
		    public boolean accept(File pathname) {
		        return true;//pathname.isDirectory();
		    }
		});
		//BufferedWriter bf = new BufferedWriter(new FileWriter(new File("C:\\Users\\FGuo\\Documents\\work doucment\\attachment\\try2.txt")));
		
		for (File subDir : subDirs) {
			if (subDir.isDirectory()) {
				listFolderName(subDir);
			} else {
				String temp = subDir.getCanonicalPath().substring(85);
				System.out.println(temp);
				for (int i = 0; i < temp.length(); i++) {
					bf.append(temp.charAt(i));
				}
				bf.append("\n");
			}
		}
	}
	
	public void closeBuffer() throws IOException{
		bf.close();
	}
}

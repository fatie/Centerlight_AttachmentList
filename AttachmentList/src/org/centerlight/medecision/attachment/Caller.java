package org.centerlight.medecision.attachment;

import java.io.IOException;

public class Caller {
	public static void main(String[] args) throws IOException{
		SubfolderList subfolderlist = new SubfolderList();
		subfolderlist.listFolderName(subfolderlist.getFileFolder());
		subfolderlist.closeBuffer();
	}
}

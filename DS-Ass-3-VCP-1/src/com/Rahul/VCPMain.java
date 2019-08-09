package com.Rahul;

public class VCPMain {
	public static void main(String args[]){
		Directory directory = new Directory();
		directory.makeDirectory("downloads");
		directory.makeDirectory("documents");
		directory.changeDirectory("downloads");
		directory.makeDirectory("com");
		directory.makeDirectory("org");
		directory.listDirectory();
		directory.back();
		directory.changeDirectory("documents");
		directory.makeDirectory("users");
		directory.makeDirectory("admin");
		directory.listDirectory();
		directory.back();
		directory.listDirectory();
		/*directory.changeDirectory("documents/users");
		directory.back();
		directory.back();*/
		directory.changeDirectory("downloads");
		directory.changeDirectory("com");
		directory.back();
		directory.listDirectory();
		directory.print();
		directory.back();
		String folders[] = directory.find("admin");
		for(int i = 1 ; i < folders.length ; i++){
			if(folders[i] == null){
				break;
			}
			if(folders[i].contains("admin")){
				System.out.println(folders[i]);
			}
		}
	}
}
 
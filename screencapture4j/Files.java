package screencapture4j;

import java.io.File;
import java.io.IOException;

public class Files {

    /**
     * All rights reserved!
     * @Author Linus Schmidt
     */

    public String mainFolderName = Strings.getName() + File.separator;

    public String fileEnd = ".txt";

    public Files() {
    	this.createMainFolder();
    }
    
    public File createMainFolder() {
        File folder = null;
        try {
            folder = new File(mainFolderName);
            if (folder.mkdirs()) {
                folder.createNewFile();
                Strings.print_Console_Information("Main-Folder[" + folder.getName() + "] created!");
            } else {
                Strings.print_Console_Error("Main-Folder[" + folder.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return folder;
    }

    public File createFileInFolder(String folderPath, String fileName) {
        File file = null;
        try {
            file = new File(getMainFolderName() + folderPath + File.separator + fileName);
            if (!file.exists()) {
                file.createNewFile();
                Strings.print_Console_Information("File[" + file.getName() + "] created!");
            } else {
                Strings.print_Console_Error("File[" + file.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return  file;
    }
    
    public File createFileInFolder(String folderPath, String fileName, String type) {
        File file = null;
        try {
            file = new File(getMainFolderName() + folderPath + File.separator + fileName + type);
            if (!file.exists()) {
                file.createNewFile();
                Strings.print_Console_Information("File[" + file.getName() + "] created!");
            } else {
                Strings.print_Console_Error("File[" + file.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return  file;
    }
    
    public File createSpecifiedFileInFolder(String folderPath, String fileName, String type) {
        File file = null;
        try {
            file = new File(folderPath + File.separator + fileName + type);
            if (!file.exists()) {
                file.createNewFile();
                Strings.print_Console_Information("File[" + file.getName() + "] created!");
            } else {
                Strings.print_Console_Error("File[" + file.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return  file;
    }

    public File createFolder(String folderName) {
        File folder = null;
        try {
            folder = new File(getMainFolderName() + folderName + File.separator);
            if (folder.mkdirs()) {
                folder.createNewFile();
                Strings.print_Console_Information("Folder[" + folder.getName() + "] created!");
            } else {
                Strings.print_Console_Error("Folder[" + folder.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return  folder;
    }

    public File createFile(String fileName) {
        File file = null;
        try {
            file = new File(getMainFolderName() + File.separator + fileName);
            if(!file.exists()) {
                file.createNewFile();
                Strings.print_Console_Information("File[" + file.getName() + "] created!");
            } else {
                Strings.print_Console_Error("File[" + file.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return file;
    }
    
    public File createFile(String fileName, String type) {
        File file = null;
        try {
            file = new File(getMainFolderName() + File.separator + fileName + type);
            if(!file.exists()) {
                file.createNewFile();
                Strings.print_Console_Information("File[" + file.getName() + "] created!");
            } else {
                Strings.print_Console_Error("File[" + file.getName() + "] cannot created or already exist!");
            }
        } catch (IOException e) {}
        return file;
    }
    
    public Files setMainFolderName(String name) {
        this.mainFolderName = name;
        return this;
    }

    public String getMainFolderName() {
        return this.mainFolderName;
    }
}

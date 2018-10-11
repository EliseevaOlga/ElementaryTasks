package ElementaryTasks.Task04;

import java.io.*;

public class FileParser {
    private File file;
    private StringBuilder text;

    public FileParser(File file){
        this.file = file;
    }

    public String readFile() {
        String s = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            text = new StringBuilder();
            while ((s = br.readLine()) != null) {
                text.append(s);
                text.append("\n");
            }
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String writeFile() {
        int strIndex = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            while (strIndex < text.length()) {
                int prevIndex = strIndex;
                strIndex = text.indexOf("\n", prevIndex);
                if (strIndex > 0) {
                    bw.write(text.substring(prevIndex, strIndex));
                    bw.newLine();
                    strIndex++;
                }
            }
            return "File was overwritten";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public int findAndReplace(String...args) {
        String srtToFind = args[0];
        String strToReplace = (args.length==2) ? args[1] : null;
        int count = 0;
        int strIndex = 0;
        do {
            strIndex = text.indexOf(srtToFind, strIndex);
            if (strIndex > 0) {
                count++;
                if (strToReplace == null) {
                    strIndex += srtToFind.length();
                } else {
                    text.replace(strIndex, strIndex + srtToFind.length(), strToReplace);
                    strIndex += strToReplace.length();
                }
            }
        } while (strIndex > 0);
        return count;
    }
}



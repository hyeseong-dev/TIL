

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static String getExtension(String fileName){
        String extension = null;
        if(!fileName.equals("")){
            extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        }
        return extension;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> extensionMap = new HashMap<>();

        String[] fileArr = new String[num];
        for (int i = 0; i < num; i++) {
            String strRaw = scanner.nextLine();
            fileArr[i] = strRaw;
        }

        Map<String, Integer> fileMap = new TreeMap<>();
        for(String filename : fileArr){
            String extension = getExtension(filename);
            if(fileMap.containsKey(extension)){
                fileMap.put(extension, fileMap.get(extension) + 1);
            }else{
                fileMap.put(extension, fileMap.getOrDefault(extension, 0)+1);
            }
        }
        for(Map.Entry<String, Integer> entry : fileMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        scanner.close();
    }
}

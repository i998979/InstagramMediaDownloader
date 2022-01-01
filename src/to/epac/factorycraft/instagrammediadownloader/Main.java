package to.epac.factorycraft.instagrammediadownloader;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        List<File> files = getAllFiles("./html");
        List<String> stringList = new ArrayList<>();

        for (File file : files) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    stringList.add(line);

                    line = br.readLine();
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            FileWriter myWriter = new FileWriter("file.txt");

            for (String u1 : stringList) {
                myWriter.write(u1 + "\n");
            }

            myWriter.close();
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();


            while (line != null) {

                String ln = line;
                while (ln.contains("url=")) {
                    int pivot = ln.indexOf("url=");

                    pivot += 4;

                    String l1 = ln.substring(pivot);
                    l1 = l1.substring(0, l1.indexOf("\""));

                    l1 = URLDecoder.decode(l1, "UTF-8");
                    hash.put(l1, 1);


                    ln = ln.substring(pivot + l1.length());
                }


                line = br.readLine();
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("filename.txt");

            for (String u1 : hash.keySet()) {
                myWriter.write(u1 + "\n");
            }

            myWriter.close();
            System.out.println("done");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getAllFiles(String directory) {
        File dir = new File(directory);
        List<File> files = new ArrayList<>();
        File[] fileList = dir.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getAllFiles(file.getAbsolutePath()));
            }
        }
        return files;
    }
}

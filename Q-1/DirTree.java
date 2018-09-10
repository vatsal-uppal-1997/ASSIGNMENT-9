import java.io.*;

public class DirTree {

    private static final File out = new File("output.txt");
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    static {
        try {
            if(out.createNewFile()) {
                System.out.println("Created");
            }
            else {
                System.out.println("Already exists at "+out.getAbsolutePath());
            }
            br = new BufferedReader(new FileReader(out));
            bw = new BufferedWriter(new FileWriter(out));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void TraverseDirRecursively(File f) throws IOException {
        /*
            Traverse only directories, skip if f does not exists or is not a directory
         */
        if (!f.exists()) {
            return;
        } else if (f.isFile()) {
            return;
        }
        File []temp = f.listFiles();
        if (temp != null) {
            bw.write(f.getAbsolutePath()+"\n");
            for (File i : temp) {
                bw.write("\t[+] " + i.getAbsolutePath() + "\n");
                TraverseDirRecursively(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        TraverseDirRecursively(new File("C:\\Users"));
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp = br.readLine()) != null)
            sb.append(temp).append("\n");
        System.out.println(sb);
    }
}

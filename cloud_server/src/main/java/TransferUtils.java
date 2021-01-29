import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TransferUtils {

    private static final String LOG = "Check.log";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {


        TransferUtils utils = new TransferUtils();
        utils.writeObject(new FileMessage(Paths.get("task.md")), "data");
        System.out.println(utils.readObject("data"));
        FileMessage fileMessage = utils.readObject("data");
        Files.write(Paths.get("task_ser_copy.md"), fileMessage.getData(), StandardOpenOption.CREATE_NEW);
    }

    public FileMessage readObject(String src) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(src));
        return (FileMessage) is.readObject();
    }

    public void writeObject(FileMessage fileMessage, String dst) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(dst));
        os.writeObject(fileMessage);
        os.close();
    }

    public void copy(String src, String dst) throws IOException {
        InputStream is = new FileInputStream(getClass().getResource(src).getPath());
        OutputStream os = new FileOutputStream(dst);
        int read;
        byte[] buffer = new byte[1024];
        while ((read = is.read(buffer)) != -1) {
            os.write(buffer, 0, read);
        }
        os.close();
        is.close();
    }
}

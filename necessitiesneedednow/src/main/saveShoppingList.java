import java.io.File;

public class saveCart {

    

    public void save(){
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/shoppingCarts";
        new File(filePath).mkdirs();
        CSVUtils utils = new CSVUtils();
        utils.setFilePath(filePath);
        utils.setFileName();

    }


}

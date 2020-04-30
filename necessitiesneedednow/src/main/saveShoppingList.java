import java.io.File;
import java.io.IOException;

public class saveShoppingList {

    private final String fileName;
    private final shoppingList list;

    saveShoppingList(shoppingList list){
        this.list = list;
        this.fileName = list.getDate() + ".csv";
    }

    public boolean save() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/shoppingCarts";
        new File(filePath).mkdirs();
        CSVUtils utils = new CSVUtils();
        utils.setFilePath(filePath);
        utils.setFileName(fileName);
        return utils.createCSV(list);
    }


}

import java.io.IOException;

public class loadShoppingCart {

    private String fileName;
    private String projectPath = System.getProperty("user.dir");
    private String filePath = projectPath + "/shoppingCarts";

    loadShoppingCart(String fileName){
        this.fileName = fileName;
    }

    public shoppingList load() throws IOException {
        String fullPath = filePath+"/"+fileName+".csv";
        CSVReadUtils reader = new CSVReadUtils();
        reader.setFullFilePath(fullPath);
        reader.setDate(fileName);
        return reader.readCSV();
    }


}

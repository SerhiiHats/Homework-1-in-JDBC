package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadRequest {
    private String pathName = "src/requestTestOptSklad.txt";

    public ReadRequest() {
    }

    public List<String> getListRequest() {
        List<String> listRequest = new ArrayList<>();
        File file = new File(pathName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                listRequest.add(request.substring(0, (request.length() - 1)));
            }
            return listRequest;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return listRequest;
    }


}

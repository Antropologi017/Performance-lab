import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Введите 3 аргумента: values.json tests.json report.json");
            return;
        }
        if ("values.json".equals(args[0]) && "tests.json".equals(args[1]) && "report.json".equals(args[2])) {
            Map<String, String> statusMap = new HashMap<>();
            Scanner valScanner = new Scanner(new File(args[0]));
            String currentId = "";

            while (valScanner.hasNextLine()) {
                String line = valScanner.nextLine().trim();

                if (line.contains("\"id\":")) {
                    currentId = line.replaceAll("[^0-9]", "");
                }
                if (line.contains("\"value\":") && !currentId.isEmpty()) {
                    String value = line.split("\"value\":")[1].replaceAll("[\", ]", "");
                    statusMap.put(currentId, value);
                    currentId = "";
                }
            }
            valScanner.close();

            Scanner testScanner = new Scanner(new File(args[1]));
            StringBuilder report = new StringBuilder();
            String lastId = "";

            while (testScanner.hasNextLine()) {
                String line = testScanner.nextLine();
                String trimmed = line.trim();

                if (trimmed.contains("\"id\":")) {
                    lastId = trimmed.replaceAll("[^0-9]", "");
                }
                if (trimmed.matches(".*\"value\":\\s*\"\"*.") && !lastId.isEmpty() && statusMap.containsKey(lastId)) {
                    line = line.replace("\"\"", "\"" + statusMap.get(lastId) + "\"");
                }
                if (trimmed.equals("}") || trimmed.equals("},") || trimmed.equals("}]")) {
                    lastId = "";
                }
                report.append(line).append("\n");
            }
            testScanner.close();

            FileWriter writer = new FileWriter(args[2]);
            writer.write(report.toString().trim());
            writer.close();
            System.out.println("Отчет " + args[2] + " готов!");
        }else {
            System.out.println("Неверный порядок аргументов, должен быть: values.json tests.json report.json");
        }
    }
}
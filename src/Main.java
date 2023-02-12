import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String pathAdmin = "/Users/ruslansharipov/";
    public static String parentDir = "";
    public static DateFormat dateFormat = new SimpleDateFormat(" EEE, d MMM yyyy, HH:mm:ss z");
    public static String date = dateFormat.format(new Date());

    public static List<String> list = new ArrayList<>();
    public static void createHomeDirectory() {
        while (true) {
            System.out.println("Введите название Родительской директории");
            String createNewHomeDirectory = scanner.nextLine();
            parentDir += createNewHomeDirectory + "/";

            File directory = new File(pathAdmin + createNewHomeDirectory);

            if (directory.mkdir()) {
                String dataDirectory = "Создание родительской директорий " + directory.getName() + " " + date + " прошло успешно!";
                list.add(dataDirectory);
                System.out.println(dataDirectory);
            } else if (directory.exists()) {
                String doesDirectory = "Директория " + directory.getName() + " существует";
                list.add(doesDirectory);
                System.out.println(doesDirectory);
            } else {
                String errorDirectory = "Произошла ошибка в коде, при создании директории";
                list.add(errorDirectory);
                System.out.println(errorDirectory);
            }
            break;
        }
    }

    public static void createSubDirectory() {
        while (true) {
            System.out.println("Введите название новой под директории");
            String input6 = scanner.nextLine();

            File directory2 = new File(pathAdmin + parentDir + "/" + input6);


            if (directory2.mkdir()) {
                String dataSubDirectory = "Создание директорий " + directory2.getName() + date + " прошло успешно!";
                list.add(dataSubDirectory);
                System.out.println(dataSubDirectory);
            } else if (directory2.exists()) {
                String doesSubDirectory = "Директория " + directory2.getName() + " существует";
                list.add(doesSubDirectory);
                System.out.println(doesSubDirectory);
            } else {
                String errorSubDirectory = "Произошла ошибка в коде, при создании директории";
                list.add(errorSubDirectory);
                System.out.println(errorSubDirectory);
                return;
            }
            break;
        }
    }

    public static void methodReturnDirectory() {
        File AllDirAndFile = new File(pathAdmin + parentDir);

        if (AllDirAndFile.isDirectory())
            for (File item : AllDirAndFile.listFiles())
                if (item.isDirectory())
                    System.out.println(item.getName() + " - каталог");
                else
                    System.out.println(item.getName() + " - файл");
    }

    public static void createFileInDirectory() {
        while (true) {
            System.out.println("Введите название директории к которую хотите создать файл и название файла через -//- имя файла.расширение ");
            methodReturnDirectory();
            String input5 = scanner.nextLine();

            File createFile = new File(pathAdmin + parentDir + input5);




            try {
                if (createFile.createNewFile()) {
                    String dataFileInDirectory = "Создание файла " + createFile.getName() + date + " прошло успешно!";
                    list.add(dataFileInDirectory);
                    System.out.println(dataFileInDirectory);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            break;
        }
    }

    public static void loger() throws IOException {
        FileWriter writer = new FileWriter(pathAdmin + parentDir + "temp//temp.txt");
        writer.write(list.toString());
        writer.flush();
        writer.close();

//        FileReader fr = new FileReader(pathAdmin + parentDir + "temp.txt");
//        char [] a = new char[200];
//        fr.read(a);
//        fr.close();
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println();
            System.out.println("Выберите действие");
            System.out.println("1 " + "Создание главной директории");
            System.out.println("2 " + "Создание поддиректории");
            System.out.println("3 " + "Создание файла");
            System.out.println("4 " + "Логирование программы");

            String question = scanner.nextLine();
            if (question.equals("1"))
                createHomeDirectory();
            else if (question.equals("2"))
                createSubDirectory();
            else if (question.equals("3"))
                createFileInDirectory();
            else if (question.equals("4"))
                loger();
        }
    }
}
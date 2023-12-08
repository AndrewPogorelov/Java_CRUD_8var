package interfaceLine;

import domain.Program;
import manager.ProgramDAO;

import java.util.Scanner;

public class CommandLineInterface {
    private ProgramDAO programDAO;
    private Scanner scanner;

    public CommandLineInterface() {
        programDAO = new ProgramDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the TV Program Manager!");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("listPrograms")) {
                System.out.println(programDAO.getAllPrograms());
            } else if (command.equals("addProgram")) {
                System.out.print("Enter program title: ");
                String title = scanner.nextLine();
                System.out.print("Enter program channel: ");
                String channel = scanner.nextLine();
                System.out.print("Enter program genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter program day of week: ");
                String dayOfWeek = scanner.nextLine();
                System.out.print("Enter program start time: ");
                String startTime = scanner.nextLine();

                Program program = new Program(title, channel, genre, dayOfWeek, startTime);
                programDAO.addProgram(program);
                System.out.println("Program added successfully!");
            } else if (command.equals("updateProgram")) {
                System.out.print("Enter program ID to update: ");
                int id = Integer.parseInt(scanner.nextLine());

                // Check if the program with the given ID exists in the database
                // If not, display an error message

                System.out.print("Enter new program title: ");
                String title = scanner.nextLine();
                System.out.print("Enter new program channel: ");
                String channel = scanner.nextLine();
                System.out.print("Enter new program genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter new program day of week: ");
                String dayOfWeek = scanner.nextLine();
                System.out.print("Enter new program start time: ");
                String startTime = scanner.nextLine();

                Program updatedProgram = new Program(title, channel, genre, dayOfWeek, startTime);
                updatedProgram.setId(id);
                programDAO.updateProgram(updatedProgram);
                System.out.println("Program updated successfully!");
            } else if (command.equals("deleteProgram")) {
                System.out.print("Enter program ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());

                // Check if the program with the given ID exists in the database
                // If not, display an error message

                programDAO.deleteProgram(id);
                System.out.println("Program deleted successfully!");
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
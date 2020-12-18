package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    public static void main(String[] args) throws SQLException{

        System.out.println("\n\t\tWelcome to Employee Management System");
        while (true){
            System.out.println("\n\t\t\t1. Add Record");
            System.out.println("\t\t\t2. Show List of the Records");
            System.out.println("\t\t\t3. Modify Records");
            System.out.println("\t\t\t4. Delete Records");
            System.out.println("\t\t\t5. Exit");

            System.out.print("\nEnter your choice: ");
            Scanner input = new Scanner(System.in);
            int myChoice = input.nextInt();

            if(myChoice==1){

                System.out.println();

                int choice = 1;

                while(choice == 1){

                    int employee_ID;
                    System.out.print("Enter Employee's ID: ");
                    employee_ID = input.nextInt();

                    String name;
                    System.out.print("Enter Employee's Name: ");
                    name = input.next();

                    System.out.print("Enter Employee's Age: ");
                    int age;
                    age = input.nextInt();

                    System.out.print("Enter Employee's Mobile Number: ");
                    String phoneNumber;
                    phoneNumber = input.next();

                    System.out.print("Enter Blood Group of Employee: ");
                    String bloodGroup;
                    bloodGroup = input.next();

                    System.out.print("Enter Employee's Monthly Salary: ");
                    int salary;
                    salary = input.nextInt();

                    //create mysql command to store information

                    try {
                        conn c = new conn();
                        String insertion = "INSERT INTO employee_management values( '" + ID + "', '" + Name + "', '"+ Age + "','" + Phone + "', '" + Blood Group + "', '" + Salary + "')";

                        c.s.executeUpdate(insertion);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //--------------------------------------------------

                    System.out.println("\nRecord has been added successfully on database!\n");

                    System.out.print("Want to add one more record? Yes(1)/No(2): ");
                    choice = input.nextInt();
                    System.out.println();

                    if(choice==2){
                        System.out.println("1. Exit Program");
                        System.out.println("2. Return Home");
                        int exitOrReturn = input.nextInt();

                        if(exitOrReturn==1){
                            System.exit(0);
                        }
                    }
                }

            }
            else if(myChoice==2){

                System.out.println();
                System.out.println("     Id\t\t\tName    Age        Phone      Blood Group\tSalary");
                System.out.println("____________\t_____   ___      _________   ____________\t_____");
                System.out.println("192-15-13139\tSiam\t 23\t\t01941162926\t\t   A+\t\t25000");

                conn con = new conn();
                String sql = "select * from employee_management";
                //Statement st = con.createStatement();
                ResultSet showMyList = con.s.executeQuery(sql);
                while (showMyList.next()) {
                    System.out.println(showMyList.getString("ID") + "      "
                            + showMyList.getString("Name") + "      "
                            + showMyList.getString("Age") + "      "
                            + showMyList.getString("Phone") + "      "
                            + showMyList.getString("Blood Group") + "      "
                            + showMyList.getString("Salary"));
                }
            }
            else if(myChoice==3){

                System.out.println();

                int yesOrNo = 1;

                while(yesOrNo == 1) {

                    System.out.print("\nEnter the Employee ID which you want to modify: ");
                    int modifyID = input.nextInt();

                    String name;
                    System.out.print("Enter New Employee's Name: ");
                    name = input.next();

                    System.out.print("Enter Age: ");
                    int age;
                    age = input.nextInt();

                    System.out.print("Enter Mobile Number: ");
                    String phoneNumber;
                    phoneNumber = input.next();

                    System.out.print("Enter Blood Group: ");
                    String bloodGroup;
                    bloodGroup = input.next();

                    System.out.print("Enter Monthly Salary: ");
                    double salary;
                    salary = input.nextDouble();

                    //create mysql code for modification on database

                    try {
                        conn con = new conn();
                        String modify = "update employee_management set Name='" + name + "', Age='" + age + "',Phone='" + phoneNumber + "',Blood Group='" + bloodGroup + "',Salary='" + salary + "'where ID ='" + modifyID + "'";
                        con.s.executeUpdate(modify);

                    } catch (Exception e) {

                    }

                    //----------------------------------------------------

                    System.out.println("\nRecord Modification Successful!\n");

                    System.out.print("Want to modify one more record? Yes(1)/No(2): ");
                    yesOrNo = input.nextInt();
                    System.out.println();

                    if (yesOrNo == 2) {

                        System.out.println("1. Exit Program");
                        System.out.println("2. Return Home");

                        int exitOrReturn = input.nextInt();
                        if (exitOrReturn == 1) {
                            System.exit(0);
                        }
                    }
                }
            }
            else if(myChoice==4){

                System.out.println();

                int yesOrNo = 1;

                while(yesOrNo == 1) {

                    System.out.print("\nEnter the Employee ID which you want to delete: ");
                    int deletingID = input.nextInt();


                    //create mysql code for deletion on database

                    try {
                        conn con = new conn();
                        String deletion = "delete from employee_management where ID = '" + deletingID + "'";
                        con.s.executeUpdate(deletion);

                    } catch (Exception ex) {
                    }

                    //----------------------------------------------------

                    System.out.println("\nRecord has been successfully deleted from database!\n");

                    System.out.print("Want to delete one more record? Yes(1)/No(2): ");
                    yesOrNo = input.nextInt();
                    System.out.println();

                    if (yesOrNo == 2) {

                        System.out.println("1. Exit Program");
                        System.out.println("2. Return Home");

                        int exitOrReturn = input.nextInt();
                        if (exitOrReturn == 1) {
                            System.exit(0);
                        }
                    }
                }

            }
            else if(myChoice==5){
                System.exit(0);  //Exit Project
            }
        }

    }
}

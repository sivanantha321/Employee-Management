/*
 * Copyright (c) 2021 Ideas2IT Technologies. All rights reserved.
 */
package com.ideas2it.employeemanagement.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import com.ideas2it.employeemanagement.controller.ProjectController;
import com.ideas2it.employeemanagement.model.EmployeeDTO;
import com.ideas2it.employeemanagement.model.ProjectDTO;
import com.ideas2it.employeemanagement.model.Status;

/**
 * The ProjectView class contains view implementations for create, update,
 * retrieve, delete employee for project management. It has validation
 * methods for project details.
 *
 * @author  Sivanantham
 * @version 1.0
 */
public class ProjectView {
    private Scanner inputReader = new Scanner(System.in);
    private ProjectController projectController = new ProjectController();
    
    /**
     * Displays the available choices for project management and gets the choice
     * from the user. Executes the selected choice.
     */
    public void showAndGetProjectChoice() {
        String userChoice;
        String errorMessage = "\n\t\t\t<<<<<< Please Enter Valid Option! "
                              + ">>>>>>\n";
        StringBuilder choices = new StringBuilder(200).append("\n\t\t\t\t\\ ")
                .append("Projects Menu /\n\t\t\t\t ~~~~~~~~~~~\n\n\t\t1 => ")
                .append("Create Project\t\t2 => Go To View Menu\n\n\t\t3 => ")
                .append("Go To Update Menu\t\t4 => Go To Delete Menu\n\n\t\t")
                .append("5 => Exit\n\n\t\tEnter The Choice : ");
        
        do {
            System.out.print(choices);
            userChoice = inputReader.nextLine().strip();
            
            switch (userChoice) {
                case "1":
                    createProject();
                    break;
                case "2":
                //    showAndGetViewChoice();
                    break;
                case "3":
                //    showAndGetUpdateChoice();
                    break;
                case "4":
                //    showAndGetDeleteChoice();
                    break;
                case "5":
                    break;
                default:
                    System.out.println(errorMessage);
                    break;
            }
        } while (!"5".equals(userChoice));
    }
    
    /**
     * Gets the project id from the user and validates the user input.
     *
     * @retrun the project id.
     */
    private int getIdInput() {
        String userInput;
        Integer id = null;
        String errorMessage = "\n\t\t\t<<<<<< Please Enter A Valid Non Negative"
                              + " Integer Value And 0 Is Not Allowed! >>>>>>\n";
                              
        while (null == id) {
            System.out.print("\n\t\t Enter Project Id : ");
            userInput = inputReader.nextLine();
            id = projectController.validateId(userInput);
            
            if (null == id) {
                System.out.println(errorMessage);
            }
        }
        return id;
    }
    
    /**
     * Gets project name from the user for create, update operations and 
     * validates name. Returns the name in lowercase if it is valid.
     *
     * @return project name as string if valid.
     */
    private String getNameInput() {
        String userInput;
        String name = null;
        String errorMessage = "\n\t\t\t<<<<<< Please Enter Valid Name! >>>>"
                              + ">>\n";
        
        while (null == name) {
            System.out.print("\n\t\t Enter Project Name : ");
            userInput = inputReader.nextLine();
            name = projectController.validateName(userInput);
            
            if (null == name) {
                System.out.println(errorMessage);
            }
        }
        return name;
    }
    
    /**
     * Gets project description from the user and validates the description.
     *
     * @return the project description.
     */
    private String getDescription() {
        String userInput;
        String description = null;
        String errorMessage = "\n\t\t\t<<<<<< Description Must Be Atleast 10 "
                              + "Characters! >>>>>>\n";
        
        while (null == description) {
            System.out.print("\n\t\t Enter Project Description : ");
            userInput = inputReader.nextLine();
            description = projectController.validateDescription(userInput);
            
            if (null == description) {
                System.out.println(errorMessage);
            }
        }
        return description;
    }
    
    /**
     * Gets the project manager name from the user and validates the name.
     *
     * @return the project manager name.
     */
    private String getManagerInput() {
        String userInput;
        String manager = null;
        String errorMessage = "\n\t\t<<<<<< Please Enter Valid Name! >>>>>>\n";
        
        while (null == manager) {
            System.out.print("\n\t\t Enter Project Manager Name : ");
            userInput = inputReader.nextLine();
            manager = projectController.validateManager(manager);
            
            if (null == manager) {
                System.out.println(errorMessage);
            }
        }
        return manager;
    }
    
    /**
     * Gets project status from the user and validates the status.
     *
     * @return the project status.
     */
    private Status getStatus() {
        String userInput;
        Status status = null;
        String errorMessage = "\n\t\t<<<<<< Please Enter Valid Status! >>>>>"
                              + ">\n";
        
        while (null == status) {
            System.out.println("\n\t\t Enter Project Status : ");
            userInput = inputReader.nextLine();
            
            if (null == status) {
                System.out.println(errorMessage);
            }
        }
        return status;
    }
    
    /**
     * Shows all employees and asks user to select employees to assign them to 
     * the project.
     *
     * @return a list containing selected employees.
     */ 
    private List<EmployeeDTO> getEmployeesInput(List<EmployeeDTO> employees) {
        String[] selectedIds;
        String userInput;
        int count = 1;
        List<EmployeeDTO> selectedEmployees = null;
        
        for (EmployeeDTO employee : employees) {
            System.out.println("\n\t\t" + count + " => " + employee.getName());
        }
        System.out.print("\n\t\tEnter Employees Numbers To Assign(seperated by"
                         + " comma) (e.g) 1, 2, 3 : ");
        
        while (null == selectedEmployees) {
            userInput = inputReader.nextLine();
            selectedIds = userInput.split(",");
            
            try {
                for (String id : selectedIds) {
                    selectedEmployees.add(employees.get(Integer.parseInt(
                            id.strip())));
                }
            } catch (NumberFormatException | IndexOutOfBoundsException 
                     exception) {
                System.out.println("\n\t\t<<<<<< Invalid Selection! >>>>>>>\n");
                selectedEmployees = null;
            }
        }
        return selectedEmployees;
    }
    
    /**
     * Gets project details from the user, validates and creates a new 
     * project.
     */
    private void createProject() {
           
    }
}
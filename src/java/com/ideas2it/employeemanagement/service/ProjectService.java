/*
 * Copyright (c) 2021 Ideas2IT Technologies. All rights reserved.
 */
package com.ideas2it.employeemanagement.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.ideas2it.employeemanagement.model.EmployeeDTO;
import com.ideas2it.employeemanagement.model.ProjectDTO;
import com.ideas2it.employeemanagement.model.Status;

/**
 * The ProjectService interface provides methods for validations and
 * create, update, retrieve, delete operations for project management system.
 *
 * @author  Sivanantham
 * @version 1.0
 */
public interface ProjectService {
    
    /**
     * Validates the project id.
     *
     * @param id the project id to be validated.
     * @return the id if it is valid, otherwise null.
     */
    Integer validateId(String id);
    
    /**
     * Checks if the specified project name is valid.
     *
     * @return true if project name is valid, otherwise false.
     */
    boolean isValidName(String name);
    
    /**
     * Validates the project name. If the name is valid removes the leading and
     * trailing spaces in the name.
     *
     * @param name the project name to be validated.
     * @return the name if it is valid, otherwise null.
     */
    String validateName(String name);
    
    /**
     * Checks if the specified description is valid. description must have 
     * atleast 10 letters. maximum of 300 characters are allowed. all special
     * characters are considered as valid.
     *
     * @return true if description is valid, otherwise false.
     */
    boolean isValidDescription(String description);
    
    /**
     * Validates the project description.
     *
     * @param description the project description to be validated.
     * @return the description if it is valid, otherwise null.
     */
    String validateDescription(String description);
    
    /**
     * Validates the project manager name.
     *
     * @param manager the project manager name to be validated.
     * @return the project manager name if it is valid, otherwise null.
     */
    String validateManager(String manager);
    
    /**
     * Validates the project status.
     *
     * @param status the project status to be validated.
     * @return the project status if it is valid, otherwise null.
     */
    Status validateStatus(String status);
    
    /**
     * Checks if the project database is empty.
     *
     * @return true if project database is empty else false.
     * @throws HibernateException if a database access error occurs.
     */
    boolean isProjectDatabaseEmpty() throws HibernateException;
    
    /**
     * Searches for the specified project id.
     * 
     * @param id the id of the project to be searched as a integer.
     * @return true if project found, otherwise false.
     * @throws HibernateException if a database access error occurs.
     */
    boolean isProjectExist(int id) throws HibernateException;
    
    /**
     * Fetches all employees from the database.
     *
     * @return a list containing all employees if database is not empty, 
               otherwise an empty list.
     * @throws HibernateException if a database access error occurs.
     */
    List<EmployeeDTO> getAllEmployees() throws HibernateException;
    
    /**
     * Creates a new project record in the database.
     *
     * @param project the project to be inserted.
     * @return the project id.
     * @throws HibernateException if database access error occurs.
     */
    int createProject(ProjectDTO projectDTO) throws HibernateException;
    
    /**
     * Retrieves the specified project from the database.
     * 
     * @param id the project id to be retrieved as a int.
     * @return the specified project if found otherwise null.
     * @throws HibernateException if a database access error occurs.
     */
     ProjectDTO getProject(int id) throws HibernateException;
    
    /** 
     * Retrieves all projects from the database.
     *
     * @return a List containing all projects.
     * @throws HibernateException if a database access error occurs.
     */
    List<ProjectDTO> getAllProjects() throws HibernateException;
    
    /**
     * Updates the specified project.
     *
     * @param projectDTO the ProjectDTO instance with updated details.
     * @return true if updated successfully, otherwise false.
     * @throws HibernateException if a database access error occurs.
     */
    boolean updateProject(ProjectDTO projectDTO) throws HibernateException;
    
    /**
     * Deletes the specified project.
     *
     * @param id the project's id to be deleted.
     * @return true if deleted successfully, otherwise false.
     * @throws HibernateException if a database access error occurs.
     */
    boolean deleteProject(int id) throws HibernateException;
    
    /**
     * Deletes all the projects.
     *
     * @return true if deleted successfully, otherwise false.
     * @throws HibernateException if a database access error occurs.
     */
    boolean deleteAllProjects() throws HibernateException;
}

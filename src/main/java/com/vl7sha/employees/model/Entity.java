package com.vl7sha.employees.model;// сущность для работы с бд

public class Entity {
    //cущности
    private int idEmployee;
    private String name;
    private String manager;
    private double salary;
    private String nameSubdivision;
    private String departmentCityLocation;
    private int categoryETS;

    public Entity() {
    }

    public Entity(int idEmployee, String name, String manager,// конструктор
                  double salary, String nameSubdivision, String departmentCityLocation, int categoryETS) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.manager = manager;
        this.salary = salary;
        this.nameSubdivision = nameSubdivision;
        this.departmentCityLocation = departmentCityLocation;
        this.categoryETS = categoryETS;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNameSubdivision() {
        return nameSubdivision;
    }

    public void setNameSubdivision(String nameSubdivision) {
        this.nameSubdivision = nameSubdivision;
    }

    public String getDepartmentCityLocation() {
        return departmentCityLocation;
    }

    public void setDepartmentCityLocation(String departmentCityLocation) {
        this.departmentCityLocation = departmentCityLocation;
    }

    public int getCategoryETS() {
        return categoryETS;
    }

    public void setCategoryETS(int categoryETS) {
        this.categoryETS = categoryETS;
    }
}

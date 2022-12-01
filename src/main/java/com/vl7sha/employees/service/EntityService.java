package com.vl7sha.employees.service;

import com.vl7sha.employees.model.Entity;
import com.vl7sha.employees.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityService extends Util {// логика с бд получ по айди, добавление, удаление

    public List<Entity> getAll() throws SQLException {
        List<Entity> entityList = new ArrayList<>();
        String sql = "SELECT * FROM \"Entity\"";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Entity entity = new Entity();
                entity.setIdEmployee(resultSet.getInt("id_employee"));
                entity.setName(resultSet.getString("name"));
                entity.setManager(resultSet.getString("manager"));
                entity.setSalary(resultSet.getDouble("salary"));
                entity.setNameSubdivision(resultSet.getString("name_subdivision"));
                entity.setDepartmentCityLocation(resultSet.getString("department_city_location"));
                entity.setCategoryETS(resultSet.getInt("category"));

                entityList.add(entity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return entityList;
    }

    public Entity getById(int id) throws SQLException {
        Entity entity = new Entity();
        String sql = "SELECT * FROM \"Entity\" WHERE id_employee = " + id + "";

        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                entity.setIdEmployee(resultSet.getInt("id_employee"));
                entity.setName(resultSet.getString("name"));
                entity.setManager(resultSet.getString("manager"));
                entity.setSalary(resultSet.getDouble("salary"));
                entity.setNameSubdivision(resultSet.getString("name_subdivision"));
                entity.setDepartmentCityLocation(resultSet.getString("department_city_location"));
                entity.setCategoryETS(resultSet.getInt("category"));
            }
        }
        return entity;
    }

    public void add(Entity entity) throws SQLException {
        String sql = "INSERT INTO \"Entity\" " +
                "(name, manager, salary, name_subdivision, department_city_location, categoryets)" +
                " VALUES (?,?,?,?,?,?) ";

        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2,entity.getManager());
            preparedStatement.setDouble(3,entity.getSalary());
            preparedStatement.setString(4,entity.getNameSubdivision());
            preparedStatement.setString(5,entity.getDepartmentCityLocation());
            preparedStatement.setInt(6,entity.getCategoryETS());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM \"Entity\" WHERE id_employee = ?";

        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

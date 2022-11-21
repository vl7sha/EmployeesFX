package main;

import com.vl7sha.employees.model.Entity;
import com.vl7sha.employees.service.EntityService;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Entity entity = new Entity();
        EntityService entityService = new EntityService();

        List<Entity> entities = entityService.getAll();

        for (Entity e:
             entities) {
            System.out.println(e);
        }
    }
}

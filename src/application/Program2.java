package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: department findById =====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll =====");
        List<Department> departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: department insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update =====");
        department = departmentDao.findById(8);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}

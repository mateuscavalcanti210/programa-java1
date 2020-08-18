package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Employee;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.printf("%nEmployee #" + (i+1) + ":%n");
			
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (true) {
				Integer result = position(list, id);
				if (result == null) {
					break;
				}
				else {
					System.out.print("Id already taken! Try again: ");
					id = sc.nextInt();
				}
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.printf("%nEnter the employee id that will have salary increase: ");
		Integer idsalary = sc.nextInt();
		Integer pos = position(list, idsalary);
		
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			list.get(pos).increaseSalary(percentage);
		}
		
		System.out.printf("%nList of Employee:%n");
		for (Employee x : list) {
			System.out.println(x);
		}

		sc.close();
	}
	
	public static Integer position(List<Employee> list, int id) {
		for (Employee x : list) {
			if (x.getId() == id) {
				return list.indexOf(x);
			}
		}
		return null;
		
	}
	
}
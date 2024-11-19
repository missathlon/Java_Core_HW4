package hw4;
/* 1. В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол» со значением
созданного перечисления. Добавить геттеры, сеттеры.
2. Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля),
написать метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта,
а мужчин с 23 февраля, если сегодня соответствующий день.
 **/

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee maria = new Employee("Maria", "Ivanovna",
                "Petrova", "8(495)123-45-67",
                "developer", 60000, 1992, Employee.Gender.FEMALE);
        Employee oleg = new Employee("Oleg", "Sergeevich",
                "Ivanov", "8(495)234-56-78",
                "tester", 55000, 1988, Employee.Gender.MALE);
        Employee svetlana = new Employee("Svetlana", "Alexandrovna",
                "Kozlova", "8(495)345-67-89",
                "project manager", 75000, 1975, Employee.Gender.FEMALE);
        Employee anton = new Employee("Anton", "Pavlovich",
                "Smirnov", "8(495)456-78-90",
                "senior developer", 95000, 1990, Employee.Gender.MALE);
        Employee elena = new Employee("Elena", "Mikhailovna",
                "Romanova", "8(495)567-89-01",
                "accountant", 65000, 1985, Employee.Gender.FEMALE);
        Employee dmitry = new Manager("Dmitry", "Andreevich",
                "Zhukov", "8(495)678-90-12", "team lead", 300000, 1983, 7,
                40, Employee.Gender.MALE);

        Employee[] employees = new Employee[6];
        employees[0] = maria;
        employees[1] = oleg;
        employees[2] = svetlana;
        employees[3] = anton;
        employees[4] = elena;
        employees[5] = dmitry;

        int[] salBeforeIncrease = {maria.getSalary(), oleg.getSalary(), svetlana.getSalary(), anton.getSalary(),
                elena.getSalary(), dmitry.getSalary()};
// System.out.println("Зарплаты до повышения: " + Arrays.toString(salBeforeIncrease));

        Manager.increaser(employees, 45, 7000);

        int[] salAfterIncrease = {maria.getSalary(), oleg.getSalary(), svetlana.getSalary(), anton.getSalary(),
                elena.getSalary(), dmitry.getSalary()};
// System.out.println("Зарплаты после повышения: " + Arrays.toString(salAfterIncrease));

        Employee emp1 = new Employee("Victoria", "Dmitrievna",
                "Fedorova", "8(495)111-22-33",
                "developer", 85000, 1994, 5, 28, Employee.Gender.FEMALE);
        Employee emp2 = new Employee("Maxim", "Yurievich",
                "Petrov", "8(495)444-55-66",
                "team lead", 210000, 1987, 10, 20, Employee.Gender.MALE);
// System.out.println(emp1.compareAge(emp2));
// System.out.println(emp2.compareAge(emp1));


        celebrate(employees);


    }
    enum Holidays{NONE, NEW_YEAR, WOMEN_DAY, DEFENDER_DAY}
    static Holidays today = declareHoliday();
    private static void celebrate (Employee[] employees){
        for (int i = 0; i < employees.length; i++){
            switch (today) {
                case NEW_YEAR:
                    System.out.println("Поздравляем с Новым годом, " + employees[i].getName());
                    break;
                case WOMEN_DAY:
                    if (employees[i].getGender().equals(Employee.Gender.FEMALE)){
                        System.out.println("Поздравляем с 8 марта, " + employees[i].getName());
                    }
                    break;
                case DEFENDER_DAY:
                    if (employees[i].getGender().equals(Employee.Gender.MALE)) {
                        System.out.println("Поздравляем с Днем защитника Отечества, " + employees[i].getName());
                    }
                    break;
                default:
                    System.out.println("Какой чудесный день, " + employees[i].getName());
            }
        }
    }

    private static Holidays declareHoliday(){
        Date dateNow = new Date();
        if(dateNow.getDate() == 1 && dateNow.getMonth() == 1){
            today = Holidays.NEW_YEAR;
        } else if (dateNow.getDate() == 23 && dateNow.getMonth() == 2) {
            today = Holidays.DEFENDER_DAY;
        } else if (dateNow.getDate() == 8 && dateNow.getMonth() == 3) {
            today = Holidays.WOMEN_DAY;
        } else {
            today = Holidays.NONE;
        }
        return today;
    }
}
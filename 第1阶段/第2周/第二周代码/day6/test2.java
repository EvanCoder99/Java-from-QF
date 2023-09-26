package week2.day6;

public class test2 {
    public static void main(String[] args) {
        worker wg = new worker("王工", 3000);
        manager zjl = new manager("赵经理", 50000, 500);
        test2 test2 = new test2();
        test2.showEmpAnnal(wg);
        test2.showEmpAnnal(zjl);
        test2.testWork(wg);
        test2.testWork(zjl);

    }
    public void showEmpAnnal(Employee e){   //向上转型
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e){   //向上转型
        if (e instanceof worker){
            ((worker) e).work();
        } else if (e instanceof manager) {
            ((manager)e).manage();
        }
    }

}

class Employee {
    private String name;
    private double salary;
    public double getAnnual(){
        return getSalary()*12;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class worker extends Employee{
    public worker(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println("工人正在努力工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
class manager extends Employee{
    double bonus;

    public manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public void manage(){
        System.out.println("经理正在管理员工");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
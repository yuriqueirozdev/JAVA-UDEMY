package EnumAndComposicao;

import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private final List<HourContract> contracts = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String name, Double baseSalary, WorkerLevel level, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double soma = baseSalary;

        for(HourContract c : contracts){
            int c_year = c.getDate().getYear();
            int c_month = c.getDate().getMonthValue();

            if(c_year == year && c_month == month){
                soma += c.totalValue();
            }
        }

        return soma;
    }
}

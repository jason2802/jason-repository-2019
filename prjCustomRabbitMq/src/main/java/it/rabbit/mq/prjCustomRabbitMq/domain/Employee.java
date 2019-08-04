package it.rabbit.mq.prjCustomRabbitMq.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@JsonIdentityInfo ( generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class )
public class Employee {

    private String empName;
    private String empId;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName( String empName ) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId( String empId ) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empId=" + empId + "]";
    }

}
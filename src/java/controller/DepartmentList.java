/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Department;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BadzBadtz
 */
@XmlRootElement (name = "DeptDataSet")
public class DepartmentList {
    @XmlElement (name = "DeptTable")
    private List<Department> depts;
    
    public List<Department> getDepartments(){
        return depts;
    }
    
    public Department getDepartment(int index){
        return depts.get(index);
    }
}

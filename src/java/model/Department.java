/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BadzBadtz
 */
public class Department {
    private String DepartmentCode;
    private String DepartmentName;

    public void setDepartmentCode(String DepartmentCode) {
        this.DepartmentCode = DepartmentCode;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }
}

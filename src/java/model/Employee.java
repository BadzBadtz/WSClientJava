/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author BadzBadtz
 */
public class Employee {
    private String EmployeeID;
    private String TitleShort;
    private String FirstName;
    private String LastName;
    private String EmployeeTypeName;
    private String PositionName;
    private String DepartmentName;
    private String Email;
    private String LoginName;
    private String CardNumber;
    private Date CreateDate;
    private Date ExpireDate;

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getTitleShort() {
        return TitleShort;
    }

    public void setTitleShort(String TitleShort) {
        this.TitleShort = TitleShort;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmployeeTypeName() {
        return EmployeeTypeName;
    }

    public void setEmployeeTypeName(String EmployeeTypeName) {
        this.EmployeeTypeName = EmployeeTypeName;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String PositionName) {
        this.PositionName = PositionName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String LoginName) {
        this.LoginName = LoginName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }
    
    
}

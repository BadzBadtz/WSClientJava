/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import is.ws.webservices.EmployeeWS;
import is.ws.webservices.EmployeeModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import model.Employee;

/**
 *
 * @author BadzBadtz
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/Employee"})
public class EmployeeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        URL url = new URL("http://localhost:8080/ISWebServices/EmployeeWSService?WSDL");
        QName qname = new QName("http://webservices.ws.is/","EmployeeWSService");
        String empData = request.getParameter("empInfo");
        String msg = "";
        
        Service service = Service.create(url,qname);
        EmployeeWS deptws = service.getPort(EmployeeWS.class);
        
        try{
            List<EmployeeModel> result = deptws.getEmployeeData(empData);
            List<Employee> empList = new ArrayList<>();
            Employee employee = null;
            
            for (EmployeeModel emp : result){
                employee = new Employee();
                employee.setEmployeeID(emp.getEmployeeID());
                employee.setTitleShort(emp.getTitleShort());
                employee.setFirstName(emp.getFirstName());
                employee.setLastName(emp.getLastName());
                employee.setEmployeeTypeName(emp.getEmployeeType());
                employee.setPositionName(emp.getPosition());
                employee.setDepartmentName(emp.getDepartment());
                employee.setEmail(emp.getEmail());
                employee.setLoginName(emp.getLoginName());
                employee.setCardNumber(emp.getCardNumber());
                employee.setCreateDate(emp.getExpireDate().toGregorianCalendar().getTime());
                employee.setExpireDate(emp.getExpireDate().toGregorianCalendar().getTime());
                
                empList.add(employee);
            }
            request.setAttribute("empList", empList);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        request.getRequestDispatcher("/EmpResultPages.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

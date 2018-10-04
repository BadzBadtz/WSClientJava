/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import is.ws.webservices.NamingModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import is.ws.webservices.EmployeeWS;
import is.ws.webservices.Exception_Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import model.Naming;
/**
 *
 * @author BadzBadtz
 */
@WebServlet(name = "PeopleServlet", urlPatterns = {"/People"})
public class PeopleServlet extends HttpServlet {

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
        String empString = request.getParameter("peopleInfo");
        String deptString = request.getParameter("deptInfo");
        String msg = "";
        
        Service service = Service.create(url,qname);
        EmployeeWS deptws = service.getPort(EmployeeWS.class);
        
        
//        JAXBContext jaxbContext;
        try {
            List<NamingModel> result = deptws.getEmployeeName(deptString, empString);
            List<Naming> empData = new ArrayList<Naming>();
            Naming employee = null;
            
            for(NamingModel emp : result)
            {
                employee = new Naming();
                employee.setEmployeeID(emp.getEmployeeID());
                employee.setFullName(emp.getFullName());
                
                empData.add(employee);
            }
            
        
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//            for (String line : result){
//                baos.write(line.getBytes());
//            }
//
//            byte[] bytes = baos.toByteArray();
//            InputStream in = new ByteArrayInputStream(bytes);
//        
//            jaxbContext = JAXBContext.newInstance(DepartmentList.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            DepartmentList deptList = (DepartmentList) jaxbUnmarshaller.unmarshal(in);
//            
//            List<Department> departments = new ArrayList<>();
//            Department depts = new Department();
//            for(Department dept : deptList.getDepartments())
//            {
//                depts.DepartmentCode = dept.getDepartmentCode();
//                depts.DepartmentName = dept.getDepartmentName();
//                departments.add(depts);
//            }
            
                request.setAttribute("empData", empData);
            
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
        } catch (Exception ex) { 
            ex.printStackTrace();
        }
        
        
        
//        List<String> result;
//        try{
//            result = hpbws.getPeopleByEmpID(empString);
//            if (result != null){
//                request.setAttribute("result",result);
//            }else{
//                msg = "Employee not found!!!";
//            }
//        }catch(Exception ex){
//            System.err.println(ex);
//        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/PeoplePages.jsp").forward(request, response);
        
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

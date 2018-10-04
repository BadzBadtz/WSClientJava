/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import is.ws.webservices.DepartmentModel;
import is.ws.webservices.EmployeeWS;
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
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import model.Department;

/**
 *
 * @author BadzBadtz
 */
@WebServlet(name = "DeptServlet", urlPatterns = {"/Dept"})
public class DeptServlet extends HttpServlet {

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
        String deptData = request.getParameter("deptInfo");
        
        Service service = Service.create(url,qname);
        EmployeeWS deptWS = service.getPort(EmployeeWS.class);
        
        if (deptData.equals("")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("dCode", "");
        session.setAttribute("dName", "");
            request.getRequestDispatcher("/PeoplePages.jsp").forward(request, response);
        }else{
            try{
                List<DepartmentModel> result = deptWS.getDepartmentByDeptID(deptData);
                List<Department> deptList = new ArrayList<>();
                Department department = null;

                for(DepartmentModel dept : result){
                    department = new Department();
                    department.setDepartmentCode(dept.getDepartmentCode());
                    department.setDepartmentName(dept.getDepartmentName());

                    deptList.add(department);
                }

                request.setAttribute("deptList", deptList);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            request.getRequestDispatcher("/DeptNamePages.jsp").forward(request, response);
        }
        
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

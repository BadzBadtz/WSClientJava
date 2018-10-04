/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webclient;

import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservices.HPBWebServices;

import webservices.HPBWebServicesService;
import webservices.DepartmentWebServices;

/**
 *
 * @author BadzBadtz
 */
public class TestClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/MyWebServices/HPBWebServicesService?WSDL");
        URL url2 = new URL("http://localhost:8080/MyWebServices/DepartmentWebServices?WSDL");
        
        QName qname = new QName("http://WebServices/","HPBWebServicesService");
        QName qname2 = new QName("http://WebServices/","DepartmentWebServices");
        
        Service service = Service.create(url,qname);
        Service service2 = Service.create(url2,qname2);
        
        HPBWebServices hpbws = service.getPort(HPBWebServices.class);
        List<String> result = hpbws.getPeopleByEmpID("2554181");
        
        DepartmentWebServices deptws = service2.getPort(DepartmentWebServices.class);
        List<String> result2 = deptws.getDepartmentByDeptCode("103");
        
        System.out.println(result);
        System.out.println(result2);
    }
    
}

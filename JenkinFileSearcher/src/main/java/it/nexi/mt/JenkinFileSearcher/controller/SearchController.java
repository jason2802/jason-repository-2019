package it.nexi.mt.JenkinFileSearcher.controller;

import it.nexi.mt.JenkinFileSearcher.domain.Employee;
import it.nexi.mt.JenkinFileSearcher.service.SearchFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping ( value = "/jenkins/1" )
public class SearchController {

    @Autowired
    SearchFilesService searchFilesService;

    @RequestMapping ( method = RequestMethod.GET, produces = "application/json", value = "/search" )
    public ResponseEntity<String> search( @RequestBody Employee emp, HttpServletRequest httpServletRequest ) {

        String msg =  searchFilesService.searchJenkinFile();
        return new ResponseEntity<>( msg, HttpStatus.OK );
    }

    @GetMapping ( value = "/producer" )
    public ResponseEntity<String> producer( @RequestParam ( "empName" ) String empName, @RequestParam ( "empId" ) String empId ) {
        Employee emp = new Employee();
        emp.setEmpId( empId );
        emp.setEmpName( empName );

        String myMsg = " +++++++++++++++ Message sent to the RabbitMQ JavaInUse Successfully";
        return new ResponseEntity<>( myMsg, HttpStatus.OK );
    }

}

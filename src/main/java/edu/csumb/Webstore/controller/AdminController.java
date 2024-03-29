//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.Admin;
import edu.csumb.Webstore.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class AdminController
{

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    AdminService AdminService;

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!

    //EXAMPLE()
    //We are returning an Iterable, which means a List! Use Iterable<Datatype> when you want to return many.
    //For example Iterable<Product>

    //NETWORKING QUICK REFERENCE
    //IF @RequestMapping(method = RequestMethod.GET, value = "/example/{var}")
    //Then you should use @RequestParam to get the variable, like so
    // public returnType getVar(@RequestParam DataType var)

    //IF  @RequestMapping(method = RequestMethod.POST, value = "/example")
    //Then you should use @RequestBody to get the variable, like so.
    //public returnType foo(@RequestBody dataType var)

    //Put and Delete will use either. They can also be compiled.
    // So IF @RequestMapping(value = "/{pathVar}", method = RequestMethod.PUT)
    //public void foo(@RequestParam dataType pathVar, @RequestBody dataType postVar)

    @RequestMapping(method = RequestMethod.GET, value = "/admin/auth")
    @ApiOperation(value = "Authenticates a admin with username and password" )
    public Boolean authenticate(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
        //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
        //So we are calling the service function we want.
        return AdminService.authenticate(username, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/addUser")
    @ApiOperation(value = "Creates an admin with username and password" )
    public Boolean addUser(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
        //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
        //So we are calling the service function we want.
        return AdminService.addUser(username, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/getAllAdmins")
    @ApiOperation(value = "Gets all admins from the database." )
    public Iterable<Admin> getAll()
    {
        //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
        //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
        //So we are calling the service function we want.
        return AdminService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/deleteAllAdmins")
    @ApiOperation(value = "Deletes all admins in the repo." )
    public void removeAll()
    {
        //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
        //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
        //So we are calling the service function we want.
        AdminService.removeAll();
    }
}
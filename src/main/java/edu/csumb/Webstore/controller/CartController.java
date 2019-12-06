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
import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
// import edu.csumb.Webstore.model.Product;
// import edu.csumb.Webstore.service.ProductService;

@RestController
public class CartController
{

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/cart/addProduct")
    @ApiOperation(value = "Adds a product in cart")
    public Boolean addProduct(@RequestParam("username") String username, @RequestParam("productId") String productId, @RequestParam("quantity") Integer quantity) {
        return userService.addProduct(username, productId, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart/updateProduct")
    @ApiOperation(value = "Updates product in cart")
    public Boolean updateProduct(@RequestParam("username") String username, @RequestParam("productId") String productId, @RequestParam("quantity") Integer quantity) {
        return userService.updateProduct(username, productId, quantity);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/cart/checkoutProduct")
    @ApiOperation(value = "Checkouts item in users cart")
    public Boolean checkoutProduct(@RequestParam("username") String username) {
        return userService.checkoutProduct(username);
    }
}
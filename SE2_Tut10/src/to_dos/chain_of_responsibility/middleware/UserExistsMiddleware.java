package to_dos.chain_of_responsibility.middleware;

import to_dos.chain_of_responsibility.server.Server;

/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    //TO-DO: Implement the UserExistsMiddleWare() method
    public UserExistsMiddleware(Server server) {
    	this.server = server;
         
    }

    public boolean check(String email, String password) {
    	//TO-DO: Check for invalid email => show error message then return false
         if (!server.hasEmail(email)) { 
        	 System.out.println("Email is not existed");
        	 return false;
         }
        //TO-DO: Check for invalid password for an email => show error message then return false
        if (!server.isValidPassword(email, password)) {
        	System.out.println("Invalid Password");
        	return false;
        }
        return checkNext(email, password);
    }
}
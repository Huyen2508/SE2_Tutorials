package to_dos.chain_of_responsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import to_dos.chain_of_responsibility.middleware.Middleware;
import to_dos.chain_of_responsibility.middleware.RoleCheckMiddleware;
import to_dos.chain_of_responsibility.middleware.ThrottlingMiddleware;
import to_dos.chain_of_responsibility.middleware.UserExistsMiddleware;
import to_dos.chain_of_responsibility.server.Server;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        //TO-DO: Register email & pass for 2 account types: admin & user
         server.register("admin@example.com", "123456");
         server.register("user", "1234");

        // All checks are linked. Client can build various chains using the same components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();
        Scanner sc = new Scanner(System.in);
        boolean success;
        do {
        	//TO-DO: Ask for email & password then save to suitable variables
            System.out.println("----Login----");
            System.out.print("Username: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            System.out.println(email + " - "  +password);
        	//TO-DO: Try to login to server with given email & password
        	//then store the result to variable 'success'
            success = false;
        } while (!success);
        sc.close();
    }
}

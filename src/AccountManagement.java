import java.util.*;
class Login
{
    private String username, password;
    public boolean login() throws InvalidUsernameException, InvalidPasswordException, UserExistsException{
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Enter email address: ");
            username = sc.nextLine();
            if(!username.equals("admin"))
            {
                if(!EmailCheck.isValid(username)) throw new InvalidUsernameException("Email address not valid. Please try again...");
            }
            if(!UserList.users.containsKey(username)) throw new InvalidUsernameException("This user does not exist!");
            System.out.println("Enter Password: ");
            password = sc.nextLine();
            if(!password.equals(UserList.users.get(username))) throw new InvalidPasswordException("Incorrect Password!");
        }
        catch (InvalidUsernameException iUex)
        {
            System.out.println(iUex.getMessage());
            if(iUex.getMessage().equals("This user does not exist!"))
            {
                System.out.println("Would you like to register instead? [Y/N]");
                if(sc.nextLine().equalsIgnoreCase("Y")) new Register().register();
                System.out.println("Returning to login page...");
                login();
            }
            else login();
        }
        catch (InvalidPasswordException iPex)
        {
            System.out.println(iPex.getMessage());
            login();
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong...");
        }
        return (password.equals(UserList.users.get(username)));
    }
}
class Register extends UserList
{
    public void register() throws InvalidUsernameException, InvalidPasswordException, UserExistsException
    {
        String user,pass;
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Enter your email:");
            user = sc.nextLine();
            if(users.containsKey(user)) throw new UserExistsException("User already exists.");
            if(!EmailCheck.isValid(user)) throw new InvalidUsernameException("Email address not valid. Please try again...");
            System.out.println("Enter password: ");
            pass = sc.nextLine();
            if(pass.isEmpty()) throw new InvalidPasswordException("Password cannot be blank! Please try again...");
            users.put(user,pass);
            System.out.println("User created successfully!");
        }
        catch (InvalidUsernameException iEex)
        {
            System.out.println(iEex.getMessage());
            register();
        }
        catch (InvalidPasswordException bPex)
        {
            System.out.println(bPex.getMessage());
            register();
        }
        catch (UserExistsException uEex)
        {
            System.out.println(uEex.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong...");
        }
    }
}
class UserList
{
    protected static HashMap<String, String> users = new HashMap<>();
}
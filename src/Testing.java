public class Testing {
    public static void main(String[] args) throws InvalidPasswordException, InvalidUsernameException, UserExistsException {
        UserList.users.put("admin","pass123");
        if(new Login().login()) System.out.println("Login Successful!");
    }
}

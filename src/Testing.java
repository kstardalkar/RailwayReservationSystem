public class Testing {
    public static void main(String[] args) throws InvalidPasswordException, InvalidUsernameException, UserExistsException {
        UserList.users.put("admin","pass123");
        User user = WelcomePage.Welcome();
        while(true)
        {
            if(user.getUsername().equals("admin")) User.AdminMode();
        }
    }
}

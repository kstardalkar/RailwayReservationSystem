
class InvalidUsernameException extends Exception
{
    public InvalidUsernameException(String msg)
    {
        super(msg);
    }
}

class InvalidPasswordException extends Exception
{
    public InvalidPasswordException(String msg)
    {
        super(msg);
    }
}
class UserExistsException extends Exception
{
    public UserExistsException(String msg)
    {
        super(msg);
    }
}



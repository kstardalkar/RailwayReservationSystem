import java.util.Scanner;

class User extends Login
{
    public static void AdminMode() throws UserExistsException, InvalidPasswordException, InvalidUsernameException {
        TrainManager tm = new TrainManager();
        System.out.println("What would you like to do? \n1. Add a train\n2. Get train details\n3.Logout");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case (1) -> {
                tm.addTrain();
                AdminMode();
            }
            case (2) -> {
                System.out.println("Enter PNR number of train: ");
                Train.getTrainInfo(tm.searchByPNR(sc.nextInt()));
                AdminMode();
            }
            case (3) -> WelcomePage.Welcome();
        }
    }
}
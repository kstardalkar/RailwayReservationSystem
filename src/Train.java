import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Train {
    private final int pnr;
    private final String name;
    private final List<String> stations;

    public Train(int pnr, String name) {
        this.pnr = pnr;
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public int getPNR() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return stations;
    }

    public void addStations() {
        System.out.println("Enter number of stations: ");
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= j; i++)
        {
            System.out.println("Enter station " + i);
            stations.add(sc.nextLine());
        }
    }

    public static void getTrainInfo(Train obj) {

        System.out.println("PNR: "+ obj.pnr +"\nName: "+ obj.name + "\nStations: "+ obj.stations.toString());
    }
}

class TrainManager {
    private final List<Train> trains;

    public TrainManager() {
        trains = new ArrayList<>();
    }

    public Train searchByPNR(int pnr) {
        for (Train train : trains) {
            if (train.getPNR() == pnr) {
                return train;
            }
        }
        return null;
    }

    public List<Train> searchByStations(String startStation, String endStation) {
        List<Train> matchingTrains = new ArrayList<>();
        for (Train train : trains) {
            List<String> trainStations = train.getStations();
            if (trainStations.contains(startStation) && trainStations.contains(endStation)) {
                matchingTrains.add(train);
            }
        }
        return matchingTrains;
    }
    public Train addTrain()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PNR number: ");
        int PNR = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter train name: ");
        String name = sc.nextLine();
        Train t = new Train(PNR, name);
        t.addStations();
        trains.add(t);
        return t;
    }
    public List<Train> getTrainList() {return trains;}
}


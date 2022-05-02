package aufgabe6.taetigkeit;

public class ParalleleTaetigkeit extends ZusammengesetzteTaetigkeit {

    @Override
    public double getTime() {
        double ges = 0;
        for(var x: meineTaetigkeit) {
            if (x.getTime() > ges)
                ges = x.getTime();
        }
        return ges;
    }
}
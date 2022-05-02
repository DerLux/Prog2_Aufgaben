package aufgabe6.taetigkeit;


public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit {

    @Override
    public double getTime() {
        double ges = 0;
        for(var x: meineTaetigkeit) {
            ges += x.getTime();
        }
        return ges;
    }
}

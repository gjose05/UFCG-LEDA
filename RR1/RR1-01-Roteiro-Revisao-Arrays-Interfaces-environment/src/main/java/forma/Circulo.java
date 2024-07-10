package forma;

public class Circulo implements Area {

    private double pi;
    private double raio;

    public Circulo(double pi, double raio){
        this.pi = pi;
        this.raio = raio;
    }

    public double calcularArea(){
        return pi * (raio * raio);
    }
}

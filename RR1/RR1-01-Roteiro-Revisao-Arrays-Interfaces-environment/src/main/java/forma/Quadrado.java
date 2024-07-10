package forma;

public class Quadrado implements Area{

    private double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    public double calcularArea(){
        return lado * lado;
    }
}

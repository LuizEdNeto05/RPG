public class Inimigo {
    private String inimigoNome;
    private double inimigoVida;
    private int inimigoForca;
    private int inimigoDefesa;
    private int inimigoAgilidade;

    public Inimigo(String inimigoNome, double inimigoVida, int inimigoForca, int inimigoDefesa, int inimigoAgilidade){
        setinimigoNome(inimigoNome);
        this.inimigoVida = inimigoVida;
        setinimigoForca(inimigoForca);
        this.inimigoDefesa= inimigoDefesa;
        this.inimigoAgilidade=inimigoAgilidade;
    }


    public void setinimigoNome(String inimigoNome)
    {
        if(inimigoNome.length()>0) {
            this.inimigoNome = inimigoNome;
        } 

    }

    public void setinimigoVida(double inimigoVida)
    {
        if(inimigoVida>0){
            this.inimigoVida=inimigoVida;
        }

    }
    public void setinimigoDefesa(int inimigoDefesa)
    {
        if(inimigoDefesa>0){
            this.inimigoDefesa=inimigoDefesa;
        }

    }
    public void setinimigoForca(int inimigoForca)
    {
        if(inimigoForca>0){
            this.inimigoForca=inimigoForca;
        }

    }
    public void setinimigoAgilidade(int inimigoAgilidade)
    {
        if(inimigoAgilidade>0){
            this.inimigoAgilidade=inimigoAgilidade;
        }

    }


    public String getinimigoNome(){
        return inimigoNome;
    }
    public double getinimigoVida(){
        return inimigoVida;
    }
    public int getinimigoForca(){
        return inimigoForca;
    }

    public int getinimigoDefesa(){
        return inimigoDefesa;
    }
    public int getinimigoAgilidade(){
        return inimigoAgilidade;
    }
}

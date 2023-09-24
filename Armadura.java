public class Armadura {
    int defesa;

    public Armadura()
    {
        this.defesa = 0;

    }

    public Armadura(int defesa)
    {
        this.defesa = defesa;
    }

    public void setdefesa(int defesa)
    {
        if(defesa>0)
        {
            this.defesa=defesa;
        }
    }

    public int getdanoConstante()
    {
        return defesa;
    }

    public static double ArmaduraSimples(int constituicao){
        double ArmaduraLeve = 5 + (1.5*constituicao);
        return ArmaduraLeve;
    }

    /*public static double ArmaduraMedia(int constituicao){
        double ArmaduraMedia = 30 + (1.5*constituicao);
        return ArmaduraMedia;
    }

    public static double ArmaduraPesada(int constituicao){
        double ArmaduraPesada = 40 + (1.5*constituicao);
        return ArmaduraPesada;
    }*/
}

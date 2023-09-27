public class Armadura {
    private int defesa;

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

    public int getdefesaConstante()
    {
        return defesa;
    }

    public static double ArmaduraSimples(int constituicao, int defesaConstante){
        double ArmaduraLeve = defesaConstante + (1.5*constituicao);
        return ArmaduraLeve;
    }

    public static double ArmaduraMedia(int constituicao, int defesaConstante){
        double ArmaduraMedia = defesaConstante + (1.5*constituicao);
        return ArmaduraMedia;
    }

    public static double ArmaduraPesada(int constituicao, int defesaConstante){
        double ArmaduraPesada = defesaConstante + (1.5*constituicao);
        return ArmaduraPesada;
    }
}

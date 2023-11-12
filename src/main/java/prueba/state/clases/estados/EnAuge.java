package prueba.state.clases.estados;
import prueba.state.clases.Icono;
import prueba.state.clases.TendenciaMusical;

public class EnAuge implements State {
    TendenciaMusical tendenciaMusical;
    public EnAuge(TendenciaMusical tendenciaMusical) {
        this.tendenciaMusical = tendenciaMusical;
    }
    @Override
    public void determinarEstado() {

        switch (cumpleCondicionParaCambiarDeEstado(tendenciaMusical)){
            case 0:
                tendenciaMusical.setEstadoCorrecto(true);
                break;
            case 1:
                tendenciaMusical.cambiarEstado(new EnTendencia(tendenciaMusical));
                break;
            case -2:
            case -1:
                tendenciaMusical.cambiarEstado(new Normal(tendenciaMusical));
                break;
        }
    }
    @Override
    public String getEstado() {
        return "En Auge";
    }
    @Override
    public void imprimir (){
        System.out.println(Icono.ROCKET.texto() + " " +
                tendenciaMusical.getArtista() +" - "+
                tendenciaMusical.getCancion() +" - ("+
                tendenciaMusical.getAlbum() +" - "+
                tendenciaMusical.getAnnio() + ")"
        );
    }
    private int cumpleCondicionParaCambiarDeEstado (TendenciaMusical tendenciaMusical){
        int conclusion = (tendenciaMusical.getReproducciones() > 50000 &&
                          tendenciaMusical.getLikes() > 20000)?1:0;
// Para determinar si se debe pasar a un estado o a otro (Si es < 0 baja, si es > 0 sube)
        conclusion -= (tendenciaMusical.getDislikes() >= 5000)?2:0;
        return conclusion;
    }
}

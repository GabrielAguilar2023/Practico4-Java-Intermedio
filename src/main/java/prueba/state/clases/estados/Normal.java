package prueba.state.clases.estados;
import prueba.state.clases.Icono;
import prueba.state.clases.TendenciaMusical;

public class Normal implements State{
    TendenciaMusical tendenciaMusical;
    public Normal(TendenciaMusical tendenciaMusical) {
        this.tendenciaMusical = tendenciaMusical;
    }
    @Override
    public void determinarEstado() {

        if (cumpleCondicionParaCambiarDeEstado(tendenciaMusical)) {
            tendenciaMusical.cambiarEstado(new EnAuge(tendenciaMusical));
        }else{
            tendenciaMusical.setEstadoCorrecto(true);
        }
    }
    @Override
    public String getEstado() {
        return "Normal";
    }
    @Override
    public void imprimir (){
        System.out.println(Icono.MUSICAL_NOTE.texto() + " " +
                tendenciaMusical.getArtista() +" - "+
                tendenciaMusical.getAlbum() + " - "+
                tendenciaMusical.getCancion()
        );
    }
    private boolean cumpleCondicionParaCambiarDeEstado (TendenciaMusical tendenciaMusical){
        return ((tendenciaMusical.getReproducciones() > 1000) &&
                (tendenciaMusical.getDislikes()< 5000) &&
                (!tendenciaMusical.isUltimas24HsSinReproduccion())
        );
    }
}

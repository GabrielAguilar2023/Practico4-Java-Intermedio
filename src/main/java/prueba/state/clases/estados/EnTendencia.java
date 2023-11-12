package prueba.state.clases.estados;
import prueba.state.clases.Icono;
import prueba.state.clases.TendenciaMusical;

public class EnTendencia implements State {
    TendenciaMusical tendenciaMusical;
    public EnTendencia(TendenciaMusical tendenciaMusical) {
        this.tendenciaMusical = tendenciaMusical;
    }
    @Override
    public void determinarEstado() {
        if (cumpleCondicionParaCambiarDeEstado(tendenciaMusical))
            tendenciaMusical.cambiarEstado(new Normal(tendenciaMusical));
            tendenciaMusical.setEstadoCorrecto(true);
    }
    @Override
    public String getEstado() {
        return "En Tendencia";
    }
    @Override
    public void imprimir (){
        System.out.println(Icono.FIRE.texto() + " " +
                tendenciaMusical.getCancion() +" - "+
                tendenciaMusical.getArtista() +" - ("+
                tendenciaMusical.getAlbum() +" - "+
                tendenciaMusical.getAnnio() + ")"
        );
    }
    private boolean cumpleCondicionParaCambiarDeEstado (TendenciaMusical tendenciaMusical){
        return tendenciaMusical.isUltimas24HsSinReproduccion();
    }
}

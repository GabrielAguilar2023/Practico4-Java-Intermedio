package prueba.state.clases;

import lombok.Getter;
import lombok.Setter;
import prueba.state.clases.estados.Normal;
import prueba.state.clases.estados.State;

@Setter @Getter
public class TendenciaMusical implements State{
	private State state;
	private boolean estadoCorrecto = false;
	private String artista;
	private String album;
	private String cancion;
	private String annio;
// condiciones para cambiar de estado
	private int reproducciones;
	private int likes;
	private int dislikes;
	private boolean ultimas24HsSinReproduccion;

// Constructores
	public TendenciaMusical() {
		this.state = new Normal(this);
	}
	public TendenciaMusical(String artista, String album, String cancion, String annio) {
		this.state = new Normal(this);
		this.artista = artista;
		this.album = album;
		this.cancion = cancion;
		this.annio = annio;
	}
	@Override
	public void determinarEstado() {
		this.state.determinarEstado();
	}
	@Override
	public String getEstado() {
		return getState().getEstado();
	}
	public void cambiarEstado (State state){
		this.state = state;
	}
	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
		while (estadoCorrecto == false)
		this.state.determinarEstado();
		imprimir();
	}
	@Override
	public void imprimir(){
		this.state.imprimir();
	}
}
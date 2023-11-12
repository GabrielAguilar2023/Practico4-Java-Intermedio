package prueba.state.clases.estados;

import prueba.state.clases.TendenciaMusical;

public interface State {
    void determinarEstado();
    String getEstado();
    void imprimir();
}

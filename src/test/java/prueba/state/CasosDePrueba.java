package prueba.state;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prueba.state.clases.TendenciaMusical;

@DisplayName("Test de la clase Tendencia Musical")
public class CasosDePrueba {

    TendenciaMusical unaCancion = new TendenciaMusical("Coldplay","A Rush of Blood to the head",
            "The Scientist","2002");

    @DisplayName("'The Scientist' recién se lanza")
    @Test
    public void pruebaNormal() {
        unaCancion.setReproducciones(300);
        Assertions.assertEquals(unaCancion.getEstado(),"Normal");
    }

    @DisplayName("'The Scientist' está en auge por superar el mínimo de reproducciones esperadas.")
    @Test
    public void pruebaEnAuge() {
        unaCancion.setReproducciones(3000);
        Assertions.assertEquals(unaCancion.getEstado(),"En Auge");
    }

    @DisplayName("'The Scientist' baja del auge por tener muchos dislikes")
    @Test
    public void BajarANormal() {
        unaCancion.setDislikes(6000);
        unaCancion.setReproducciones(3000);
        Assertions.assertEquals(unaCancion.getEstado(),"Normal");
    }

    @DisplayName("'The Scientist' es tendencia por récord de reproducciones y cantidad de personas que le gusta el tema")
    @Test
    public void PruebaEnTendencia() {
        unaCancion.setLikes(21000);
        unaCancion.setReproducciones(60000);
        Assertions.assertEquals(unaCancion.getEstado(),"En Tendencia");
    }

    @DisplayName("'The Scientist' era tendencia pero vuelve a ser normal por no ser escuchada en las últimas horas.")
    @Test
    public void TendenciaANormal() {
        unaCancion.setUltimas24HsSinReproduccion(true);
        unaCancion.setLikes(21000);
        unaCancion.setReproducciones(60000);
        Assertions.assertEquals(unaCancion.getEstado(),"Normal");
    }
}

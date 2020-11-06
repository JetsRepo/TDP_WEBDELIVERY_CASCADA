package com.tsoft.bot.frontend.steps.WebDelivery;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.pages.P_Corporate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class CrearPedidoCorporativo {

    public WebDriver driver;
    P_Corporate createCorPed = new P_Corporate(driver);

    public CrearPedidoCorporativo() {
        this.driver = Hook.getDriver();
    }

    @Given("^INGRESAMOS A LA URL DE WEB DELIVERY \"([^\"]*)\"$")
    public void ingresamosALAURLDEWEBDELIVERY(String casoPrueba) throws Throwable {
        createCorPed.ingresoALaUrlDeWEBDELIVERY(casoPrueba);
    }

    @When("^INGRESAMOS USUARIO A WEB DELIVERY\"([^\"]*)\"$")
    public void ingresamosUSUARIOAWEBDELIVERY(String casoPrueba) throws Throwable {
        createCorPed.ingresoElUsuarioDeWEBDELIVERY(casoPrueba);
    }

    @And("^INGRESAMOS PASSWORD WEB DELIVER\"([^\"]*)\"$")
    public void ingresamosPASSWORDAWEBDELIVER(String casoPrueba) throws Throwable {
        createCorPed.laContraseñaDeWEBDELIVERY(casoPrueba);
    }

    @Then("^CLICK BOTON LOGIN INGRESANDO CORRECTAMENTE A LA PAGINA$")
    public void clickBOTONLOGININGRESANDOCORRECTAMENTEALAPAGINA() throws Throwable {
        createCorPed.seDaClicEnElBotonLoginDeWEBDELIVERYIngresandoCorrectamente();
    }


    @Given("^click en crear pedido$")
    public void clickEnCrearPedido() throws Throwable {
        createCorPed.clickEnCrearPedido();
    }

    @When("^Ingresar y buscar el numero de RUC \"([^\"]*)\"$")
    public void ingresarYBuscarElNumeroDeRUC(String casoPrueba) throws Throwable {
        createCorPed.ingresarYBuscarElNúmeroDeRUC(casoPrueba);
    }

    @And("^Ingresar el tipo de pedido y almacen \"([^\"]*)\"$")
    public void ingresarElTipoDePedidoYAlmacen(String casoPrueba) throws Throwable {
        createCorPed.ingresarElTipoDePedidoYAlmacén(casoPrueba);
    }

    @And("^Infromación del solicitante\"([^\"]*)\"$")
    public void infromaciónDelSolicitante(String casoPrueba) throws Throwable {
        createCorPed.infromaciónDelSolicitante(casoPrueba);
    }

    @And("^Dirección de entrega$")
    public void direcciónDeEntrega() throws Throwable {
        createCorPed.direcciónDeEntrega();

    }

    @And("^Información del receptor \"([^\"]*)\"$")
    public void informaciónDelReceptor(String casoPrueba) throws Throwable {
        createCorPed.informaciónDelReceptor(casoPrueba);
    }

    @Then("^click en botón continuar$")
    public void clickEnBotónContinuar() throws Throwable {
        createCorPed.clickEnBotónContinuar();

    }

    @Given("^Click botón fila nueva$")
    public void clickBotónFilaNueva() throws Throwable {
        createCorPed.clickBotónFilaNueva();

    }

    @When("^Linea de detalle de solicitud \\(Alta\\)\"([^\"]*)\"$")
    public void lineaDeDetalleDeSolicitudAlta(String casoPrueba) throws Throwable {
        createCorPed.lineaDeDetalleDeSolicitudAlta(casoPrueba);
    }

    @And("^Click botón consultar disponibilidad$")
    public void clickBotónConsultarDisponibilidad() throws Throwable {
        createCorPed.clickBotónConsultarDisponibilidad();

    }

    @And("^Click botón realizar reserva$")
    public void clickBotónRealizarReserva() throws Throwable {
        createCorPed.clickBotónRealizarReserva();
    }

    @And("^Click botón generar detalles del pedido$")
    public void clickBotónGenerarDetallesDelPedido() throws Throwable {
        createCorPed.clickBotónGenerarDetallesDelPedido();
    }

    @And("^Click botón continuar$")
    public void clickBotónContinuar() throws Throwable {
        createCorPed.clickBotónContinuar();

    }

    @And("^Click botón continuar siguiente$")
    public void clickBotónContinuarSiguiente() throws Throwable {
        createCorPed.clickBotónContinuarPaso();
    }

    @And("^Click botón enviar \"([^\"]*)\"$")
    public void clickBotónEnviar(String casoDePrueba) throws Throwable {
        createCorPed.clickBotónEnviar(casoDePrueba);
    }

    @Then("^Guardar el código de pedido \"([^\"]*)\"$")
    public void guardarElCódigoDePedido(String casoPrueba) throws Throwable {
        createCorPed.guardarElCódigoDePedido(casoPrueba);
    }
}




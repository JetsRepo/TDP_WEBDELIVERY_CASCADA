package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.Base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.O_Corporate;
import com.tsoft.bot.frontend.pages.objects.ExcelWebDelivery;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class P_Corporate extends BaseClass {

    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    public P_Corporate(WebDriver driver) {
        super(driver);
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN);
    }

    String PEDIDO;
    public void ingresoALaUrlDeWEBDELIVERY(String casoDePrueba) throws Throwable {
        try {

            int LoginWD = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(LoginWD).get(ExcelWebDelivery.COLUMNA_URL);
            driver.get(url);
            stepPass(driver,"Se cargó correctamente la página");
            generateWord.sendText("Carga correcta de la página");
            generateWord.addImageToWord(driver);
            println("Se cargó correctamente la página");
            generateWord.sendBreak();
        }catch (Exception e){
            ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    public void ingresoElUsuarioDeWEBDELIVERY(String casoDePrueba) throws Throwable {

        try {
            int user = Integer.parseInt(casoDePrueba) - 1;
            String usuario = getData().get(user).get(ExcelWebDelivery.COLUMNA_USUARIO);
            wait(driver, O_Corporate.TXT_USER,60);
            if (isDisplayed(driver, O_Corporate.TXT_USER)){
                clear(driver, O_Corporate.TXT_USER);
                sendKeys(driver, O_Corporate.TXT_USER,usuario);
            }
            stepPass(driver,"Ingresamos el usuario");
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);
            println("Ingresamos el usuario");

        }catch (Exception e){
            ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }


    public void laContraseñaDeWEBDELIVERY(String casoDePrueba) throws Throwable {

        try {
            int PASS = Integer.parseInt(casoDePrueba) - 1;
            wait(driver, O_Corporate.TXT_PASSWORD,60);
            clear(driver, O_Corporate.TXT_PASSWORD);
            String contra = getData().get(PASS).get(ExcelWebDelivery.COLUMNA_CONTRASENIA);
            sendKeys(driver, O_Corporate.TXT_PASSWORD,contra);
            stepPass(driver,"Ingresamos la contraseña");
            generateWord.sendText("Ingresamos la contraseña");
            generateWord.addImageToWord(driver);
            println("Ingresamos la contraseña");
        }catch (Exception e){
            ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void seDaClicEnElBotonLoginDeWEBDELIVERYIngresandoCorrectamente() throws Throwable {
        try {
            click(driver, O_Corporate.BTN_LOGIN);
            sleep(2000);
            wait(driver,O_Corporate.LNK_CREAR_PEDIDO,60);
            stepPass(driver,"Se ingresa correctamente a la pagina");
            generateWord.sendText("Se ingresa correctamente a la pagina");
            generateWord.addImageToWord(driver);
            println("Se ingresa correctamente a la pagina");
        }catch (Exception e){
            ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickEnCrearPedido() throws Throwable {
        try {
            stepPass(driver,"Seleccionamos crear pedido");
            generateWord.sendText("Seleccionamos crear pedido");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.LNK_CREAR_PEDIDO);
            println("Seleccionamos crear pedido");
            wait(driver,O_Corporate.BTN_LUPA,60);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void ingresarYBuscarElNúmeroDeRUC(String casoDePrueba) throws Throwable {

        try {
            sleep(2000);
            click(driver, O_Corporate.BTN_LUPA);
            wait(driver, O_Corporate.TXT_RUC,60);
            int user = Integer.parseInt(casoDePrueba) - 1;
            String usuario = getData().get(user).get(ExcelWebDelivery.NUM_RUC);
            sendKeys(driver, O_Corporate.TXT_RUC,usuario);
            sendKeysRobot(driver, O_Corporate.TXT_RUC,Keys.ENTER);
            String f ;
            f = driver.findElement(O_Corporate.LNK_RUC).getText();
            while (!f.equals(usuario)) {
                sleep(1000);
                String g;
                g = driver.findElement(O_Corporate.TXT_VACIO2).getText();
                if (g.equals("0 - 0 de 0")){
                    stepFail(driver,"RUC no encontrado");
                    generateWord.sendText("RUC no encontrado");
                    generateWord.addImageToWord(driver);
                    println("RUC no encontrado");
                    driver.quit();
                }else{
                    f = driver.findElement(O_Corporate.LNK_RUC).getText();
                }
            }
            stepPass(driver,"Se obtiene la descripción de la empresa");
            generateWord.sendText("Se obtiene la descripción de la empresa");
            generateWord.addImageToWord(driver);
            println("Se obtiene la descripción de la empresa");
           click(driver, O_Corporate.LNK_RUC);
            sleep(5000);
            stepPass(driver,"Datos del RUC");
            generateWord.sendText("Datos del RUC");
            generateWord.addImageToWord(driver);
            println("Datos del RUC");

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void ingresarElTipoDePedidoYAlmacén(String casoDePrueba) throws Throwable {

        try {
            sleep(3000);
            click(driver, O_Corporate.BTN_LUPA2);
            wait(driver, O_Corporate.TXT_TIPO_ALMACEN,60);
            int pedido = Integer.parseInt(casoDePrueba) - 1;
            String tipo = getData().get(pedido).get(ExcelWebDelivery.TIPO);
            if (tipo.equals("CAMBIO")){
                sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"CAMBIO");
                sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
                sleep(3000);
            }
            if (tipo.equals("ALTA COMBO")|| tipo.equals("ALTA SOLO SIM")){
                sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"ALTA");
                sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
                sleep(3000);
            }
            stepPass(driver,"Seleccionamos tipo de pedido");
            generateWord.sendText("Seleccionamos tipo de pedido");
            generateWord.addImageToWord(driver);
            println("Seleccionamos tipo de pedido");
            click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
            sleep(3000);
            int SAL_ANT = Integer.parseInt(casoDePrueba) - 1;
            String SALANT = getData().get(SAL_ANT).get(ExcelWebDelivery.SALIDA_ANTICIPADA);
            if (SALANT.equals("SI")){
                click(driver, O_Corporate.CHECK_SALIDA_ANTICIPADA);
            }
            click(driver, O_Corporate.BTN_LUPA3);
            wait(driver, O_Corporate.TXT_TIPO_ALMACEN,60);
            sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"PE10API7");
            sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
            sleep(5000);
            stepPass(driver,"Almacén");
            generateWord.sendText("Almacén");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.LNK_TIPO_ALMACEN);
            sleep(3000);
            click(driver, O_Corporate.BTN_LUPA8);
            wait(driver, O_Corporate.TXT_TIPO_ALMACEN,60);
            int pedido2 = Integer.parseInt(casoDePrueba) - 1;
            String tipo2 = getData().get(pedido2).get(ExcelWebDelivery.TIPO_PAGO);
            if (tipo2.equals("PAGO EFECTIVO")){
                sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"PAGO EFECTIVO");
                sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
            }
            if (tipo2.equals("FINANCIADO")){
                sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"FINANCIADO");
                sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
            }
            if (tipo2.equals("OTROS")){
                sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,"OTROS");
                sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
            }
            if (tipo2.equals("NO")){
                sleep(1000);
            }
           sleep(5000);
            stepPass(driver,"Tipo de pago");
            generateWord.sendText("Tipo de pago");
            sleep(2000);
            click(driver, O_Corporate.LNK_PAGO_EFECTIVO);
           sleep(3000);
           stepPass(driver,"Datos del pedido completos");
            generateWord.sendText("Datos del pedido completos");
            generateWord.addImageToWord(driver);
            println("Datos del pedido ingresados correctamente");
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }

    }
    public void infromaciónDelSolicitante(String casoDePrueba) throws Throwable {

        try {
            sleep(2000);
            click(driver, O_Corporate.TXT_N_DOCUMENTO);
            sleep(1000);
            click(driver, O_Corporate.BTN_LUPA4);
            wait(driver, O_Corporate.TXT_TIPO_ALMACEN,60);
            int user = Integer.parseInt(casoDePrueba) - 1;
            String usuario = getData().get(user).get(ExcelWebDelivery.N_DOCUMENTO);
            sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,usuario);
            sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
           sleep(3000);
           stepPass(driver,"Datos del solicitante");
            generateWord.sendText("Datos del solicitante");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
           sleep(3000);
           stepPass(driver,"Información del solicitante completo");
            generateWord.sendText("Información del solicitante completo");
            generateWord.addImageToWord(driver);
            println("Información del solicitante ingresada correctamente");
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void direcciónDeEntrega() throws Throwable {
        try {
            sleep(2000);
            click(driver, O_Corporate.BTN_LUPA5);
            wait(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO,60);
            stepPass(driver,"Descripción de dirección");
            generateWord.sendText("Descripción de dirección");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
            sleep(3000);
            stepPass(driver,"Dirección de entrega completo");
            generateWord.sendText("Dirección de entrega completo");
            generateWord.addImageToWord(driver);
            println("Se ingreso correctamente la dirección");

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void informaciónDelReceptor(String casoDePrueba) throws Throwable {

        try {
           sleep(2000);
           click(driver, O_Corporate.TXT_N_DOCUMENTO2);
            click(driver, O_Corporate.BTN_LUPA9);
            wait(driver, O_Corporate.TXT_TIPO_ALMACEN,60);
            int user = Integer.parseInt(casoDePrueba) - 1;
            String usuario = getData().get(user).get(ExcelWebDelivery.N_DOCUMENTO_RECEP);
            sendKeys(driver, O_Corporate.TXT_TIPO_ALMACEN,usuario);
            sendKeysRobot(driver, O_Corporate.TXT_TIPO_ALMACEN,Keys.ENTER);
            sleep(3000);
            stepPass(driver,"Información del contacto");
            generateWord.sendText("Información del contacto");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
            sleep(3000);
            stepPass(driver,"Información del receptor completo");
            generateWord.sendText("Información del receptor completo");
            generateWord.addImageToWord(driver);
            println("Se ingreso la información del receptor");
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void clickEnBotónContinuar() throws Throwable {

        try {
           sleep(2000);
           click(driver, O_Corporate.BTN_CONTINUAR);
            wait(driver, O_Corporate.BTN_FILA_NUEVA,60 );
            stepPass(driver,"Datos del agendamiento");
            generateWord.sendText("Datos del agendamiento");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void clickBotónFilaNueva() throws Throwable {
        try {
            click(driver, O_Corporate.BTN_FILA_NUEVA);
            wait(driver, O_Corporate.BTN_LUPA7,60);
            stepPass(driver,"Linea de detalle de solicitud");
            generateWord.sendText("Linea de detalle de solicitud");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void lineaDeDetalleDeSolicitudAlta(String casoDePrueba) throws Throwable {

        try {
            int pedido = Integer.parseInt(casoDePrueba) - 1;
            String tipo = getData().get(pedido).get(ExcelWebDelivery.TIPO);
            if (tipo.equals("CAMBIO")){
                String cambio_2 = getData().get(0).get(ExcelWebDelivery.TIPO_CAMBIO);
                if (cambio_2.equals("SOLO SIM")  ){
                    click(driver, O_Corporate.BTN_LUPA7);
                    wait(driver, O_Corporate.TXT_RUC,60);
                    int user3 = Integer.parseInt(casoDePrueba) - 1;
                    String usuario3 = getData().get(user3).get(ExcelWebDelivery.COD_SAP);
                    sendKeys(driver, O_Corporate.TXT_RUC,usuario3);
                    sendKeysRobot(driver, O_Corporate.TXT_RUC,Keys.ENTER);
                    sleep(3000);
                    stepPass(driver,"Descripción del código SAP del SimCard");
                    generateWord.sendText("Descripción del código SAP del SimCard");
                    generateWord.addImageToWord(driver);
                    click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
                    sleep(3000);
                    int pedido3 = Integer.parseInt(casoDePrueba) - 1;
                    String tipo3 = getData().get(pedido3).get(ExcelWebDelivery.CANT_LINEAS);
                    sendKeys(driver, O_Corporate.TXT_CANTIDAD_SOLICITADA,tipo3);
                    sleep(2000);
                    stepPass(driver,"Linea de detalle de solicitud completa");
                    generateWord.sendText("Linea de detalle de solicitud completa");
                    generateWord.addImageToWord(driver);
                    println("Se relleno solicitud");
                }

            }
            if (tipo.equals("ALTA COMBO")){
                sleep(2000);
                click(driver, O_Corporate.BTN_LUPA10);
                wait(driver, O_Corporate.TXT_RUC,60);
                int user2 = Integer.parseInt(casoDePrueba) - 1;
                String usuario2 = getData().get(user2).get(ExcelWebDelivery.COD_SAP_EQUIPO);
                sendKeys(driver, O_Corporate.TXT_RUC,usuario2);
                sendKeysRobot(driver, O_Corporate.TXT_RUC,Keys.ENTER);
                sleep(3000);
                stepPass(driver,"Descripción del código SAP del equipo");
                generateWord.sendText("Descripción del código SAP del equipo");
                generateWord.addImageToWord(driver);
                click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
                sleep(3000);
                click(driver, O_Corporate.BTN_LUPA7);
                sleep(3000);
                int user3 = Integer.parseInt(casoDePrueba) - 1;
                String usuario3 = getData().get(user3).get(ExcelWebDelivery.COD_SAP);
                sendKeys(driver, O_Corporate.TXT_RUC,usuario3);
                sendKeysRobot(driver, O_Corporate.TXT_RUC,Keys.ENTER);
                sleep(3000);
                stepPass(driver,"Descripción del código SAP del SimCard");
                generateWord.sendText("Descripción del código SAP del SimCard");
                generateWord.addImageToWord(driver);
                click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
                sleep(3000);
                int pedido3 = Integer.parseInt(casoDePrueba) - 1;
                String tipo3 = getData().get(pedido3).get(ExcelWebDelivery.CANT_LINEAS);
                sendKeys(driver, O_Corporate.TXT_CANTIDAD_SOLICITADA,tipo3);
                sleep(2000);
                stepPass(driver,"Linea de detalle de solicitud completa");
                generateWord.sendText("Linea de detalle de solicitud completa");
                generateWord.addImageToWord(driver);
                println("Linea de detalle de solicitud completa");
            }
            if (tipo.equals("ALTA SOLO SIM")){
                click(driver, O_Corporate.BTN_LUPA7);
                wait(driver, O_Corporate.TXT_RUC,60);
                int user3 = Integer.parseInt(casoDePrueba) - 1;
                String usuario3 = getData().get(user3).get(ExcelWebDelivery.COD_SAP);
                sendKeys(driver, O_Corporate.TXT_RUC,usuario3);
                sendKeysRobot(driver, O_Corporate.TXT_RUC,Keys.ENTER);
                sleep(3000);
                stepPass(driver,"Descripción del código SAP del SimCard");
                generateWord.sendText("Descripción del código SAP del SimCard");
                generateWord.addImageToWord(driver);
                click(driver, O_Corporate.LNK_TIPO_PEDIDO_CAMBIO);
                sleep(3000);
                int pedido3 = Integer.parseInt(casoDePrueba) - 1;
                String tipo3 = getData().get(pedido3).get(ExcelWebDelivery.CANT_LINEAS);
                sendKeys(driver, O_Corporate.TXT_CANTIDAD_SOLICITADA,tipo3);
                sleep(2000);
                stepPass(driver,"Linea de detalle de solicitud completa");
                generateWord.sendText("Linea de detalle de solicitud completa");
                generateWord.addImageToWord(driver);
                println("Linea de detalle de solicitud completa");
            }
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickBotónConsultarDisponibilidad() throws Throwable {
        try {
            sleep(2000);
            click(driver, O_Corporate.BTN_SONSULTAR_DISPON);
            wait(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST,60);
            stepPass(driver,"Mensaje del sistema");
            generateWord.sendText("Mensaje del sistema");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickBotónRealizarReserva() throws Throwable {
        try {
            sleep(3000);
            click(driver, O_Corporate.BTN_REALIZAR_RESERVA);
            wait(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST,60);
            stepPass(driver,"Mensaje del sistema");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Mensaje del sistema");
            generateWord.sendText("Mensaje del sistema");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST);
            sleep(3000);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickBotónGenerarDetallesDelPedido() throws Throwable {
        try {
            sleep(2000);
            click(driver, O_Corporate.BTN_GENERAR_DET_PEDIDO);
            wait(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST,60);
            stepPass(driver,"Mensaje del sistema");
            generateWord.sendText("Mensaje del sistema");
            generateWord.addImageToWord(driver);
            click(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST);
            sleep(3000);
            stepPass(driver,"Lineas de detalle de solicitud completa");
            generateWord.sendText("Lineas de detalle de solicitud completa");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }
    public void clickBotónContinuar() throws Throwable {
        click(driver, O_Corporate.BTN_CONTINUAR2);
        wait(driver, O_Corporate.BTN_CONTINUAR3,60);
        stepPass(driver,"Lineas Amdocs");
        generateWord.sendText("Lineas Amdocs");
        generateWord.addImageToWord(driver);
    }
    public void clickBotónContinuarPaso() throws Throwable {
        click(driver, O_Corporate.BTN_CONTINUAR3);
        wait(driver, O_Corporate.BTN_ENVIAR_SALIDA_ANTICIPADA,60);
        stepPass(driver,"Datos del pedido");
        generateWord.sendText("Datos del pedido");
        generateWord.addImageToWord(driver);
    }
    public void clickBotónEnviar(String casoDePrueba) throws Throwable {

        int pedido = Integer.parseInt(casoDePrueba) - 1;
        String SALANT = getData().get(pedido).get(ExcelWebDelivery.SALIDA_ANTICIPADA);
        if (SALANT.equals("SI")) {
            click(driver, O_Corporate.BTN_ENVIAR_SALIDA_ANTICIPADA);
        }else{
            click(driver, O_Corporate.BTN_ENVIAR);
        }
        wait(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST,60);
        stepPass(driver,"Mensaje del sistema");
        generateWord.sendText("Datos del pedido");
        generateWord.addImageToWord(driver);
        click(driver, O_Corporate.BTN_ACEPTAR_MENS_SIST);
        sleep(2000);
        stepPass(driver,"Solicitud enviada");
        generateWord.sendText("Solicitud enviada");
        generateWord.addImageToWord(driver);
        click(driver, O_Corporate.BTN_VER_DETALLES);
        sleep(4000);
    }
    public void guardarElCódigoDePedido(String casoDePrueba) throws Throwable {

        try {
            int pedido = Integer.parseInt(casoDePrueba);
            wait(driver, O_Corporate.TXT_COD_PEDIDO, 60);

            PEDIDO = driver.findElement(O_Corporate.TXT_COD_PEDIDO).getAttribute("value");
            if (!PEDIDO.equals("")) {
                stepPass(driver, "Código de pedido");
                generateWord.sendText("Código de pedido");
                generateWord.addImageToWord(driver);
                System.out.println("Se genero el siguiente número de pedido: " + PEDIDO);
                ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, pedido, 14, PEDIDO);
            } else {
                stepFail(driver, "No existe código de pedido");
                generateWord.sendText("No existe código de pedido");
                generateWord.addImageToWord(driver);
            }
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    /*public void seDaClickEnElBotonIRAEnWEBDELIVERY() throws Throwable {

        try {
            driver.findElement(CargaMateriales.LST_IR_A).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "IR A lista de pedidos");
        }catch (Exception e){
            ExcelReader.writeCellValue(ExcelWebDelivery.EXCEL_WEB, ExcelWebDelivery.ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void seleccionarAjusteDeInventario() throws Exception {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(CargaMateriales.LNK_GESTION_PEDIDOS)).build().perform();
            Actions act2 = new Actions(driver);
            act2.moveToElement(driver.findElement(CargaMateriales.LNK_GESTION_INVENTARIOS)).build().perform();
            driver.findElement(CargaMateriales.LNK_AJUSTE_INVENTARIO).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ajuste de inventarios");
            generateWord.sendText("Ajuste de inventarios");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickEnElBotonNuevoRegistro() throws Exception {
        try {
            driver.findElement(CargaMateriales.BTN_NUEVO_REGISTRO).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Nuevo registro");
            generateWord.sendText("Nuevo registro");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void seleccionamosElTipoABASTECIMIENTO(String arg0) throws Throwable {

        try {
            driver.findElement(CargaMateriales.BTN_TIPO).click();
            Thread.sleep(1000);
            generateWord.sendText("Click ABASTECIMIENTO");
            generateWord.addImageToWord(driver);
            driver.findElement(CargaMateriales.LNK_ABASTECIMIENTO).click();
            Thread.sleep(2000);
            String estado = driver.findElement(CargaMateriales.TXT_TIPO).getAttribute("value");
            if (estado.equals("ABASTECIMIENTO")){
                ExtentReportUtil.INSTANCE.stepPass(driver, "Tipo: ABASTECIMIENTO");
                generateWord.sendText("Tipo: ABASTECIMIENTO");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "No seleccionó ABASTECIMIENTO");
                generateWord.sendText("No seleccionó ABASTECIMIENTO");
                generateWord.addImageToWord(driver);
            }

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void ingresamosUnComentario(String casoDePrueba) throws Throwable {

        try {
            int coment = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(CargaMateriales.TXT_COMENTARIO).clear();
            driver.findElement(CargaMateriales.TXT_COMENTARIO).sendKeys("PRUEBAS-QA");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos comentario");
            generateWord.sendText("Ingresamos comentario");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void ingresamosGuiaDeRemision(String casoDePrueba) throws Throwable {

        try {
            int guiarem = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(CargaMateriales.TXT_GUIA_REMISION).clear();
            int random = ThreadLocalRandom.current().nextInt(10, 99);
            int random2 = ThreadLocalRandom.current().nextInt(10, 99);
            int random3 = ThreadLocalRandom.current().nextInt(10, 99);
            int random4 = ThreadLocalRandom.current().nextInt(1, 9);
            int random5 = ThreadLocalRandom.current().nextInt(1, 9);
            int random6 = ThreadLocalRandom.current().nextInt(1, 9);
            String numero = "12"+random6+random5+"-"+ random + random2 + random3+random4;
            driver.findElement(CargaMateriales.TXT_GUIA_REMISION).clear();
            driver.findElement(CargaMateriales.TXT_GUIA_REMISION).sendKeys(numero);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos guia de remision");
            generateWord.sendText("Ingresamos guia de remision");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void ingresamosElArchivo() throws Throwable {

        try {
            driver.findElement(CargaMateriales.BTN_ADJUNTAR_ARCHIVOS).click();
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(CargaMateriales.LNK_ADJUNTAR_NUEVO_ARCHIVO)).build().perform();
            driver.findElement(CargaMateriales.LNK_ARCHIVO_NUEVO).click();
            Thread.sleep(2000);
            System.out.println("passs");
            Thread.sleep(2000);
            generateWord.sendText("Agregamos nuevo archivo");
            generateWord.addImageToWord(driver);
            driver.switchTo().frame(0);
            driver.findElement(CargaMateriales.BTN_SELECCIONAR_ARCHIVO).click();
            Thread.sleep(1000);
            Robot robot = new Robot();
            String ruta = "F:\\CargaDeMateriales\\AsignacionSeries_3.csv";
            String text = ruta;
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            Screen screen = new Screen();
            screen.wait(CargaMateriales.BTN_ACEPTAR_ARCHIVO);
            Region valBtn = screen.find(CargaMateriales.BTN_ACEPTAR_ARCHIVO).highlight(1,"green");
            screen.click(CargaMateriales.BTN_ACEPTAR_ARCHIVO);


        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void clickEnEjecutarAjusteYAceptarMensaje() throws Exception {
        try {
            Thread.sleep(5000);
            driver.findElement(CargaMateriales.BTN_EJECUTAR_AJUSTE).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ejecutar ajuste");
            generateWord.sendText("Ejecutar ajuste");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            driver.findElement(CargaMateriales.BTN_ACEPTAR_AJUSTE).click();
            Thread.sleep(7000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Mensaje del sistema");
            generateWord.sendText("Mensaje del sistema");
            generateWord.addImageToWord(driver);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CargaMateriales.BTN_ACEPTAR_SISTEMA));
            String text;
            text = driver.findElement(CargaMateriales.TXT_IMAGEN).getText();
            text = text.substring(13);
            if (text.equals("Error en el proceso, verificar el campo de error")){
                ExtentReportUtil.INSTANCE.stepFail(driver, "Error al cargar materiales");
                generateWord.sendText("Error al cargar materiales");
                generateWord.addImageToWord(driver);
            }
            if (text.equals("Ajuste ejecutado con éxito") || text.equals(" Ajuste ejecutado con éxito") ){
                ExtentReportUtil.INSTANCE.stepPass(driver, "Carga de materiales exitoso");
                generateWord.sendText("Carga de materiales exitoso");
                generateWord.addImageToWord(driver);
            }
            driver.findElement(CargaMateriales.BTN_ACEPTAR_SISTEMA).click();
            Thread.sleep(4000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    public void validarQueLosArchivosHayanCargado() throws Exception {
        try {

            String filas;
            filas = driver.findElement(CargaMateriales.TABLE).getAttribute("displayrows");
            int num = Integer.parseInt(filas);
            for (int  i =0; (i<num); i++){
                String valor = driver.findElement(By.id("me7037f0c_tdrow_[C:10]-c[R:"+i+"]")).getText();
                String material = driver.findElement(By.id("me7037f0c_tdrow_[C:7]-c[R:"+i+"]")).getText();
                System.out.println(material + "  ->  " + valor);

            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Detalle de carga");
            generateWord.sendText("Detalle de carga");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }*/
}

package com.tsoft.bot.frontend.pages.objects;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;

public class CargaMateriales {
    public static By LST_IR_A = By.id("titlebar-tb_gotoButton");
    public static By LNK_GESTION_PEDIDOS = By.id("menu0_GP_MODULE_a_tnode");
    public static By LNK_GESTION_INVENTARIOS = By.id("menu0_GP_MODULE_sub_CUST1003_HEADER_a_tnode");
    public static By LNK_AJUSTE_INVENTARIO = By.id("menu0_GP_MODULE_sub_CUST1003_HEADER_sub_changeapp_WD_AJUSTE_a");
    public static By BTN_NUEVO_REGISTRO = By.id("toolactions_INSERT-tbb_image");
    public static By BTN_TIPO = By.id("mf03a4671-img");
    public static By LNK_ABASTECIMIENTO = By.id("lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]");
    public static By TXT_TIPO = By.id("mf03a4671-tb");
    public static By TXT_COMENTARIO = By.id("m8050b2fe-tb");
    public static By TXT_GUIA_REMISION = By.id("m1ab585d9-tb");
    public static By BTN_ADJUNTAR_ARCHIVOS = By.id("m3c111cf3-ti_img");
    public static By LNK_ADJUNTAR_NUEVO_ARCHIVO = By.id("ATTACHMENTS_addnew_a_tnode");
    public static By LNK_ARCHIVO_NUEVO = By.id("ATTACHMENTS_addnew_sub_addnewfile_a");
    public static By BTN_SELECCIONAR_ARCHIVO = By.id("IMPORT");
    public static By BTN_ACEPTAR = By.id("m781c76a7-pb");
    public static By BTN_EJECUTAR_AJUSTE = By.id("toolactions_EJECUTAR-tbb_image");
    public static By BTN_ACEPTAR_AJUSTE = By.id("mac443a9-pb");
    public static By BTN_ACEPTAR_SISTEMA = By.id("m88dbf6ce-pb");
    public static By TXT_IMEI_EXIST = By.id("me7037f0c_tdrow_[C:3]-c[R:1]");
    public static By TXT_SIMCARD_EXIST = By.id("me7037f0c_tdrow_[C:3]-c[R:0]");
    public static final Pattern BTN_ACEPTAR_ARCHIVO = new Pattern("F:\\flujos prueba dalma\\web-automation-framework\\src\\main\\resources\\img_Sikuli\\BTN_ACEPTAR.PNG");
    public static By TXT_IMAGEN = By.id("mb_msg");
    public static By TABLE = By.id("me7037f0c_tbod-tbd");

}

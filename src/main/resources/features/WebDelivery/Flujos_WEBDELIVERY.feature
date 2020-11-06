Feature: FlujoWEB_DELIVERY


  @CREAR_PEDIDO
  Scenario Outline: Crear Pedido_ALTA_MASIVA_CAEQ_MASIVO
    Given INGRESAMOS A LA URL DE WEB DELIVERY "<caso_prueba>"
    When INGRESAMOS USUARIO A WEB DELIVERY"<caso_prueba>"
    And INGRESAMOS PASSWORD WEB DELIVER"<caso_prueba>"
    Then CLICK BOTON LOGIN INGRESANDO CORRECTAMENTE A LA PAGINA
    Given click en crear pedido
    When Ingresar y buscar el numero de RUC "<caso_prueba>"
    And Ingresar el tipo de pedido y almacen "<caso_prueba>"
    And Infromación del solicitante"<caso_prueba>"
    And Dirección de entrega
    And Información del receptor "<caso_prueba>"
    Then click en botón continuar
    Given Click botón fila nueva
    When Linea de detalle de solicitud (Alta)"<caso_prueba>"
    And Click botón consultar disponibilidad
    And Click botón realizar reserva
    And Click botón generar detalles del pedido
    And Click botón continuar
    And Click botón continuar siguiente
    And Click botón enviar "<caso_prueba>"
    Then Guardar el código de pedido "<caso_prueba>"

    Examples:
      | caso_prueba |
      |           1 |

  @CARGA_MATERIALES @FlujoCompleto
  Scenario Outline: Carga de Materiales

    Given INGRESAMOS A LA URL DE WEB DELIVERY "<caso_prueba>"
    When INGRESAMOS USUARIO A WEB DELIVERY"<caso_prueba>"
    And INGRESAMOS PASSWORD WEB DELIVER"<caso_prueba>"
    Then CLICK BOTON LOGIN INGRESANDO CORRECTAMENTE A LA PAGINA
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When seleccionar ajuste de inventario
    And click en el boton nuevo registro
    And seleccionamos el tipo ABASTECIMIENTO "<caso_prueba>"
    And ingresamos un comentario "<caso_prueba>"
    And ingresamos guia de remision "<caso_prueba>"
    And ingresamos el archivo
    And click en ejecutar ajuste y aceptar mensaje
    And validar que los archivos hayan cargado


    Examples:
      | caso_prueba |
      |           1 |


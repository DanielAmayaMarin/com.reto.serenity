@seleccionarProducto
Feature: Flujo Seleccionar artículo

  Como usuario de falabella
  Quero agregar ciertos productos
  para realizar una compra

  @smokeTest @smokTestAgregaProduto
  Scenario: Usuario agregar productos al asar al carrito de compras
    Given Que "Daniel" navego en la página de Falabella
    When Navega aleatoriamente por el menú
    And Selecciona los 3 productos aleatorios
    Then Válido la cantidad de productos en el carrito de compras
    Then Válido el subtotal de los productos

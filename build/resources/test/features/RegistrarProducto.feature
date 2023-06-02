
#language:es

Característica: Creacion de Producto
  Como usuario logeado, quiero poder crear un producto correctamente para gestionar mi inventario.

  @CreacionProducto
  Escenario: Creacion de producto exitosa
    Dado que el usuario ha iniciado sesion y que el usuario hace clic en Product Types
    Cuando el usuario da clic en el boton New Product y agerga el nombre juntco con los campos obligatorios y guarde el producto
    Entonces el usuario puede visualizar el nombre del nuevo producto en la tabla de productos.

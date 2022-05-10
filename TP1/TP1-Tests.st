TestCase subclass: #AlgoPedidosCatedraTests
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Pablo'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Pablo'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Pablo'.
	
	self assert: (algoPedidos precioPedidoDe: 'Pablo') closeTo: 450.0 precision: 0.1.! !
	| algoPedidos |
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Eugenio'.
	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2 para: 'Eugenio'.
	algoPedidos agregarProductoConNombre: 'Gelatina' precio: 100.0 yCantidad: 1 para: 'Eugenio'.
	
	self assert: (algoPedidos precioPedidoDe: 'Eugenio') equals: 600.0.! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Diego'.

	algoPedidos agregarCuponAPedidoDe: 'Diego' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1 para: 'Diego'.
	
	self assert: (algoPedidos precioPedidoDe: 'Diego') closeTo: 335.0 precision: 0.01. "-15"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Tomás'.
	
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 1 para: 'Tomás'.
	algoPedidos agregarCuponAPedidoDe: 'Tomás' conPorcentaje: 10. 
	
	self assert: (algoPedidos precioPedidoDe: 'Tomás') closeTo: (200*0.9) precision: 0.01. "-10%"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Martin'.

	algoPedidos agregarCuponAPedidoDe: 'Martin' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Pizza' precio: 350.0 yCantidad: 1 para: 'Martin'.
	
	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 335.0 precision: 0.01.  "-15"
	
	algoPedidos removerCuponDePedidoDe: 'Martin'.

	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 350.0 precision: 0.01.! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Julian'.

	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 1 para: 'Julian'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Julian'.

	algoPedidos agregarCuponAPedidoDe: 'Julian' conValor: 15.
	
	self assert: (algoPedidos precioPedidoDe: 'Julian') equals: 600.0.! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Carlos'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Carlos'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 2.
	
	algoPedidos actualizarProductoConNombre: 'Gaseosa' conCantidad: 3 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 4.! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Santiago'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Santiago'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Santiago'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Santiago') equals: (750*1.2). "20% extra"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Sebas'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarMenuConNombre: 'Menú Lunes' precio: 200.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Sebas'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (950*1.2). "20% extra"
	
	algoPedidos removerProductoConNombre: 'vino' para: 'Sebas'.
	algoPedidos removerMenuConNombre: 'Menú Lunes' para: 'Sebas'.
	
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (500*1.2). "20% extra"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Raul'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2 para: 'Raul'.
	algoPedidos agregarProductoConNombre: 'fernet' precio: 500.0 yCantidad: 1 para: 'Raul'.
	algoPedidos agregarProductoConNombre: 'coca cola' precio: 250.0 yCantidad: 2 para: 'Raul'. 
	self assert: (algoPedidos precioPedidoDe: 'Raul') equals: (2000*1.2). "20% extra"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'El Chino Luna'.
	algoPedidos agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 10 para: 'El Chino Luna'.

	algoPedidos agregarCuponAPedidoDe: 'El Chino Luna' conValor: 500.
	
	self assert: (algoPedidos precioPedidoDe: 'El Chino Luna') equals: 2500.0.
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Donato'.

	algoPedidos agregarProductoConNombre: 'Ñoquis' precio: 350.0 yCantidad: 2 para: 'Donato'.
	algoPedidos agregarProductoConNombre: 'Vinito' precio: 200.0 yCantidad: 5 para: 'Donato'.

	algoPedidos agregarCuponAPedidoDe: 'Donato' conValor: 350.
	
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Martina'.

	algoPedidos agregarCuponAPedidoDe: 'Martina' conValor: 150. 	
	algoPedidos agregarProductoConNombre: 'Pizza' precio: 450.0 yCantidad: 1 para: 'Martina'.
	
	self assert: (algoPedidos precioPedidoDe: 'Martina') closeTo: 300.0 precision: 0.01.  "-150"
	
	algoPedidos removerCuponDePedidoDe: 'Martina'.

	self assert: (algoPedidos precioPedidoDe: 'Martina') closeTo: 450.0 precision: 0.01.! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Gonzalo'.

	algoPedidos agregarCuponAPedidoDe: 'Gonzalo' conValor: 100. 	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1 para: 'Gonzalo'.
	
	self assert: (algoPedidos precioPedidoDe: 'Gonzalo') closeTo: 250.0 precision: 0.01. "-15"! !
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Pilar'.

	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2 para: 'Pilar'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Pilar'.

	algoPedidos agregarCuponAPedidoDe: 'Pilar' conValor: 50.
	
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Julia'.

	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2 para: 'Julia'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Julia'.

	algoPedidos agregarCuponAPedidoDe: 'Julia' conValor: 15.
	
	self assert: (algoPedidos precioPedidoDe: 'Julia') equals: 800.0.! !
	| unPedido | 

	unPedido agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2.

	unPedido agregarDescuentoConValor: 15.
	
	self assert: (unPedido calcularPrecioPedido) equals: 800.0.! !
	| unPedido | 

	unPedido agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2.

	unPedido agregarDescuentoConValor: 50.
	
	| unPedido | 

	unPedido agregarDescuentoConValor: 150. 	
	unPedido agregarProductoConNombre: 'Pizza' precio: 450.0 yCantidad: 1.
	
	self assert: (unPedido calcularPrecioPedido) closeTo: 300.0 precision: 0.01.  "-150"
	
	unPedido removerCupon.

	self assert: (unPedido calcularPrecioPedido) closeTo: 450.0 precision: 0.01.
	| unPedido | 
	unPedido agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 10.

	unPedido agregarDescuentoConValor: 500.
	
	self assert: (unPedido calcularPrecioPedido) equals: 2500.0.
	| unPedido | 
	
	unPedido := Pedido inicializarParaDeliveryConNombre: 'Raul'.
	
	unPedido agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'fernet' precio: 500.0 yCantidad: 1.
	unPedido agregarProductoConNombre: 'coca cola' precio: 250.0 yCantidad: 2.
	self assert: (unPedido calcularPrecioPedido ) equals: (2000*1.2). "20% extra"! !
	| unPedido | 

	unPedido agregarDescuentoConValor:  100. 	
	unPedido agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1.
	
	self assert: (unPedido calcularPrecioPedido) closeTo: (350*1.2 - 100) precision: 0.01. "-100"! !
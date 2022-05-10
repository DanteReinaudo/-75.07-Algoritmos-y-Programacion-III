TestCase subclass: #AlgoPedidosCatedraTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/3/2020 00:02'!test03SeAgregaMenuAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Pablo'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Pablo'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Pablo'.
	
	self assert: (algoPedidos precioPedidoDe: 'Pablo') closeTo: 450.0 precision: 0.1.! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Tabareski 10/24/2020 16:09'!test01SeAgreganProductosAPedidoParaRetirar
	| algoPedidos |
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Eugenio'.
	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2 para: 'Eugenio'.
	algoPedidos agregarProductoConNombre: 'Gelatina' precio: 100.0 yCantidad: 1 para: 'Eugenio'.
	
	self assert: (algoPedidos precioPedidoDe: 'Eugenio') equals: 600.0.! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test06AplicarCuponDeDescuentoFijoAPedidoConProductos
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Diego'.

	algoPedidos agregarCuponAPedidoDe: 'Diego' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1 para: 'Diego'.
	
	self assert: (algoPedidos precioPedidoDe: 'Diego') closeTo: 335.0 precision: 0.01. "-15"! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 19:05'!test04AplicarCuponDeDescuentoPorcentualAPedidoConProductos
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Tomás'.
	
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 1 para: 'Tomás'.
	algoPedidos agregarCuponAPedidoDe: 'Tomás' conPorcentaje: 10. 
	
	self assert: (algoPedidos precioPedidoDe: 'Tomás') closeTo: (200*0.9) precision: 0.01. "-10%"! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test08RemoverCuponDeDescuentoAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Martin'.

	algoPedidos agregarCuponAPedidoDe: 'Martin' conValor: 15. 	
	algoPedidos agregarProductoConNombre: 'Pizza' precio: 350.0 yCantidad: 1 para: 'Martin'.
	
	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 335.0 precision: 0.01.  "-15"
	
	algoPedidos removerCuponDePedidoDe: 'Martin'.

	self assert: (algoPedidos precioPedidoDe: 'Martin') closeTo: 350.0 precision: 0.01.! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:11'!test07AgregarCuponAPedidoConMenuNoRealizaDescuento
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Julian'.

	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 1 para: 'Julian'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Julian'.

	algoPedidos agregarCuponAPedidoDe: 'Julian' conValor: 15.
	
	self assert: (algoPedidos precioPedidoDe: 'Julian') equals: 600.0.! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Edson 10/20/2020 20:10'!test05SeCambiaCantidadDeProductosEnPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Carlos'.
	
	algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 1 para: 'Carlos'.
	algoPedidos agregarProductoConNombre: 'Gaseosa' precio: 250.0 yCantidad: 1 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 2.
	
	algoPedidos actualizarProductoConNombre: 'Gaseosa' conCantidad: 3 para: 'Carlos'.
	
	self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos') equals: 4.! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Tabareski 10/24/2020 16:09'!test02SeAgreganProductosAPedidoConDelivery
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Santiago'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Santiago'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Santiago'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Santiago') equals: (750*1.2). "20% extra"! !!AlgoPedidosCatedraTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:55'!test09RemoverProductosAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Sebas'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarMenuConNombre: 'Menú Lunes' precio: 200.0 yCantidad: 1 para: 'Sebas'.
	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 1 para: 'Sebas'.
	 
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (950*1.2). "20% extra"
	
	algoPedidos removerProductoConNombre: 'vino' para: 'Sebas'.
	algoPedidos removerMenuConNombre: 'Menú Lunes' para: 'Sebas'.
	
	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (500*1.2). "20% extra"! !TestCase subclass: #AlgoPedidosTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:00'!test02SeAgreganProductosAPedidoConDelivery
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoConDeliveryPara: 'Raul'.
	
	algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2 para: 'Raul'.
	algoPedidos agregarProductoConNombre: 'fernet' precio: 500.0 yCantidad: 1 para: 'Raul'.
	algoPedidos agregarProductoConNombre: 'coca cola' precio: 250.0 yCantidad: 2 para: 'Raul'. 	
	self assert: (algoPedidos precioPedidoDe: 'Raul') equals: (2000*1.2). "20% extra"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:35'!test11SeAplicaDescuentoAPedidoConMenuLuegoSeQuitaElMenuYPuedeAplicarseElDescuento
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'El Chino Luna'.	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2 para: 'El Chino Luna'.	algoPedidos agregarMenuConNombre: 'Menu especial' precio: 300.0 yCantidad: 2 para: 'El Chino Luna'.
	algoPedidos agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 10 para: 'El Chino Luna'.

	algoPedidos agregarCuponAPedidoDe: 'El Chino Luna' conValor: 500.
	
	self assert: (algoPedidos precioPedidoDe: 'El Chino Luna') equals: 2500.0.		algoPedidos removerMenuConNombre: 'Menu especial' para: 'El Chino Luna'.		self assert: (algoPedidos precioPedidoDe: 'El Chino Luna') equals: 1900.0.		algoPedidos removerMenuConNombre: 'Menu jueves' para: 'El Chino Luna'.		self assert: (algoPedidos precioPedidoDe: 'El Chino Luna') equals: 1000.0.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:05'!test04AplicarCuponDeDescuentoPorcentualAPedidoConProductos	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoParaRetirarPara: 'Fernando'.		algoPedidos agregarProductoConNombre: 'Hamburguesa' precio: 400.0 yCantidad: 1 para: 'Fernando'.	algoPedidos agregarCuponAPedidoDe: 'Fernando' conPorcentaje: 30. 		self assert: (algoPedidos precioPedidoDe: 'Fernando') closeTo: (400*0.7) precision: 0.01. "-10%"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:42'!test12SeAgreganVariosCuponesAPedidoSeRetiraUnoYNoHayDescuento
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Donato'.

	algoPedidos agregarProductoConNombre: 'Ñoquis' precio: 350.0 yCantidad: 2 para: 'Donato'.
	algoPedidos agregarProductoConNombre: 'Vinito' precio: 200.0 yCantidad: 5 para: 'Donato'.

	algoPedidos agregarCuponAPedidoDe: 'Donato' conValor: 350.
		self assert: (algoPedidos precioPedidoDe: 'Donato') closeTo: 1350.0 precision: 0.01.  "-350"				algoPedidos agregarCuponAPedidoDe: 'Donato' conValor: 1.		self assert: (algoPedidos precioPedidoDe: 'Donato') closeTo: 1699.0 precision: 0.01.  "-1"				algoPedidos agregarCuponAPedidoDe: 'Donato' conPorcentaje: 50.		self assert: (algoPedidos precioPedidoDe: 'Donato') closeTo: (1700.0 * 0.5) precision: 0.01.  "-%50"			algoPedidos removerCuponDePedidoDe: 'Donato'.		self assert: (algoPedidos precioPedidoDe: 'Donato') equals: 1700.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:12'!test20NoPuedoIngresarPorcentajessInvalidosAPedido	| algoPedidos| 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self should: [ algoPedidos agregarCuponAPedidoDe: 'Edwin' conPorcentaje: 'Cuarenta'] 	raise: ParametroNoEsUnNumeroError.		self should: [ algoPedidos agregarCuponAPedidoDe: 'Edwin' conPorcentaje: 200 ] 	raise: PorcentajeInvalidoError.		self should: [ algoPedidos agregarCuponAPedidoDe: 'Edwin' conPorcentaje: -10 ] 	raise: PorcentajeInvalidoError.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 13:18'!test16NoPuedoAgregarProductosAPedidoQueNoExiste	| algoPedidos| 		algoPedidos := AlgoPedidos new.		self should: [ algoPedidos agregarProductoConNombre: 'Pancho' precio: 100 yCantidad: 1 para: 'Jesus']	 	raise: PedidoNoEncontradoError.		self should: [ algoPedidos agregarMenuConNombre: 'Menu Pancho' precio: 100 yCantidad: 1 para: 'Jesus']	 	raise: PedidoNoEncontradoError.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 13:04'!test15PedidoSinProductosTieneCantidadCero	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Edwin') equals: 0.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:46'!test13SeAgreganDecuentoConValorMayorAlPrecioDelPedidoEsteSaleGratarola	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoParaRetirarPara: 'Cardona'.	algoPedidos agregarProductoConNombre: 'Bondiola con papas' precio: 400.0 yCantidad: 1 para: 'Cardona'.	algoPedidos agregarCuponAPedidoDe: 'Cardona' conValor: 500.		self assert: (algoPedidos precioPedidoDe: 'Cardona') equals: 0.  "-500"		! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:13'!test08RemoverCuponDeDescuentoAPedido
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Martina'.

	algoPedidos agregarCuponAPedidoDe: 'Martina' conValor: 150. 	
	algoPedidos agregarProductoConNombre: 'Pizza' precio: 450.0 yCantidad: 1 para: 'Martina'.
	
	self assert: (algoPedidos precioPedidoDe: 'Martina') closeTo: 300.0 precision: 0.01.  "-150"
	
	algoPedidos removerCuponDePedidoDe: 'Martina'.

	self assert: (algoPedidos precioPedidoDe: 'Martina') closeTo: 450.0 precision: 0.01.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:55'!test09RemoverProductosAPedido	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Sebas'.		algoPedidos agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2 para: 'Sebas'.	algoPedidos agregarMenuConNombre: 'Menú Lunes' precio: 200.0 yCantidad: 1 para: 'Sebas'.	algoPedidos agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 4 para: 'Sebas'.	 	self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (2200*1.2). "20% extra"		algoPedidos removerProductoConNombre: 'vino' para: 'Sebas'.	algoPedidos removerMenuConNombre: 'Menú Lunes' para: 'Sebas'.		self assert: (algoPedidos precioPedidoDe: 'Sebas') equals: (1000*1.2). "20% extra"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 13:24'!test17NoPuedoRemoverOActualizarProductoQueNoExiste	| algoPedidos| 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self should: [ algoPedidos actualizarProductoConNombre: 'Lechon' conCantidad: 4 para: 'Edwin' ]		raise: ProductoNoEncontradoError.		self should: [ algoPedidos removerProductoConNombre: 'Knishe' para: 'Edwin'] 	raise: ProductoNoEncontradoError.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:12'!test19NoPuedoIngresarPreciosInvalidosAPedido	| algoPedidos| 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 'diez' yCantidad: 2 	para:  'Edwin' ] raise: ParametroNoEsUnNumeroError.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: -250.0 yCantidad: 2	para:  'Edwin' ] raise: PrecioInvalidoError.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 0 yCantidad: 2 	para:  'Edwin' ] raise: PrecioInvalidoError.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:11'!test06AplicarCuponDeDescuentoFijoAPedidoConProductos
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Gonzalo'.

	algoPedidos agregarCuponAPedidoDe: 'Gonzalo' conValor: 100. 	
	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1 para: 'Gonzalo'.
	
	self assert: (algoPedidos precioPedidoDe: 'Gonzalo') closeTo: 250.0 precision: 0.01. "-15"! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:24'!test10SeAgreganVariosCuponesAPedidoYNoSeAcumulan
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Pilar'.

	algoPedidos agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2 para: 'Pilar'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Pilar'.

	algoPedidos agregarCuponAPedidoDe: 'Pilar' conValor: 50.
		self assert: (algoPedidos precioPedidoDe: 'Pilar') closeTo: 850.0 precision: 0.01.  "-50"				algoPedidos agregarCuponAPedidoDe: 'Pilar' conValor: 250.		self assert: (algoPedidos precioPedidoDe: 'Pilar') closeTo: 650.0 precision: 0.01.  "-250"				algoPedidos agregarCuponAPedidoDe: 'Pilar' conPorcentaje: 25.		self assert: (algoPedidos precioPedidoDe: 'Pilar') closeTo: (900.0 * 0.75) precision: 0.01.  "-%25"	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:11'!test07AgregarCuponAPedidoConMenuNoRealizaDescuento
	| algoPedidos | 
	
	algoPedidos := AlgoPedidos new.
	algoPedidos crearPedidoParaRetirarPara: 'Julia'.

	algoPedidos agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2 para: 'Julia'.
	algoPedidos agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2 para: 'Julia'.

	algoPedidos agregarCuponAPedidoDe: 'Julia' conValor: 15.
	
	self assert: (algoPedidos precioPedidoDe: 'Julia') equals: 800.0.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 11:57'!test01SeAgreganProductosAPedidoParaRetirar	| algoPedidos |		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoParaRetirarPara: 'Tabare'.		algoPedidos agregarProductoConNombre: 'Milangas' precio: 300.0 yCantidad: 2 para: 'Tabare'.	algoPedidos agregarProductoConNombre: 'Flan' precio: 150.0 yCantidad: 1 para: 'Tabare'.		self assert: (algoPedidos precioPedidoDe: 'Tabare') equals: 750.0.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 13:03'!test14PedidoSinProductosTienePrecioCero	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self assert: (algoPedidos precioPedidoDe: 'Edwin') equals: 0.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:12'!test18NoPuedoIngresarCantidadesInvalidasAPedido	| algoPedidos| 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 'Cuatro' 	para:  'Edwin' ] raise: ParametroNoEsUnNumeroError.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 0 	para:  'Edwin' ] raise: CantidadInvalidaError.		self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 1.75 	para:  'Edwin' ] raise: CantidadInvalidaError.	self should: [ algoPedidos agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: -10	para:  'Edwin' ] raise: CantidadInvalidaError.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:13'!test21NoPuedoIngresarValoresDeDescuentoInvalidosAPedido	| algoPedidos| 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoConDeliveryPara: 'Edwin'.		self should: [ algoPedidos agregarCuponAPedidoDe: 'Edwin' conValor: 'Cien'] 	raise: ParametroNoEsUnNumeroError.		self should: [ algoPedidos agregarCuponAPedidoDe: 'Edwin' conValor: -50 ] 	raise: ValorInvalidoError.	! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:07'!test05SeCambiaCantidadDeProductosEnPedido	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoParaRetirarPara: 'Carlos Saul'.		algoPedidos agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 2 para: 'Carlos Saul'.	algoPedidos agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 1 para: 'Carlos Saul'.		self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos Saul') equals: 3.		algoPedidos actualizarProductoConNombre: 'Cerveza' conCantidad: 10 para: 'Carlos Saul'.		self assert: (algoPedidos cantidadProductosEnPedidoDe: 'Carlos Saul') equals: 12.! !!AlgoPedidosTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 12:03'!test03SeAgregaMenuAPedido	| algoPedidos | 		algoPedidos := AlgoPedidos new.	algoPedidos crearPedidoParaRetirarPara: 'Diego'.		algoPedidos agregarMenuConNombre: 'Menú lunes' precio: 200.0 yCantidad: 1 para: 'Diego'.	algoPedidos agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 1 para: 'Diego'.		self assert: (algoPedidos precioPedidoDe: 'Diego') closeTo: 350.0 precision: 0.1.! !TestCase subclass: #DescuentoTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:58'!test09SeAgreganVariosDescuentosSeQuitaUnoyNoHayDescuento	| unDescuento |		unDescuento := Descuento new.		unDescuento agregarValorDeDescuento: 150.	self assert:(unDescuento calcularDescuento:300) equals: 150.		unDescuento agregarValorDeDescuento: 50.	self assert:(unDescuento calcularDescuento:300) equals: 250.		unDescuento agregarPorcentajeDeDescuento: 50.	self assert:(unDescuento calcularDescuento:300) equals: 150.		unDescuento quitarCupon.	self assert:(unDescuento calcularDescuento:300) equals: 300.		! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:45'!test01CreoDescuentoPorValorYloCalculo	| unDescuento |		unDescuento := Descuento new.	unDescuento agregarValorDeDescuento: 100.	self assert:(unDescuento calcularDescuento:500) equals: 400.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:05'!test11NoPuedoAgregarValoresDeDescuentosInvalidos	| unDescuento |		unDescuento := Descuento new.		self should: [ unDescuento agregarValorDeDescuento: 'Doscientos'.] 	raise: ParametroNoEsUnNumeroError.		self should: [ unDescuento agregarValorDeDescuento: -50.] 	raise: ValorInvalidoError.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:47'!test04CalculoDescuentoPorPorcentajeConMenu	| unDescuento |		unDescuento := Descuento new.	unDescuento agregarPorcentajeDeDescuento: 50.	unDescuento agregarMenu.		self assert:(unDescuento calcularDescuento:500) equals: 500.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:51'!test06AgregoVariosDescuentosNoSeAcumulan	| unDescuento |		unDescuento := Descuento new.		unDescuento agregarValorDeDescuento: 50.	self assert:(unDescuento calcularDescuento:1000) equals: 950.		unDescuento agregarPorcentajeDeDescuento: 50.	self assert:(unDescuento calcularDescuento:1000) equals: 500.		unDescuento agregarValorDeDescuento: 250.	self assert:(unDescuento calcularDescuento:1000) equals: 750.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:49'!test05CalculoDescuentoPorValorConMenu	| unDescuento |		unDescuento := Descuento new.	unDescuento agregarValorDeDescuento: 50.	unDescuento agregarMenu.		self assert:(unDescuento calcularDescuento:500) equals: 500.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:07'!test12NoPuedoAgregarPorcentajesDeDescuentosInvalidos	| unDescuento |		unDescuento := Descuento new.		self should: [ unDescuento agregarPorcentajeDeDescuento: 'Cincuenta'.] 	raise: ParametroNoEsUnNumeroError.		self should: [ unDescuento agregarPorcentajeDeDescuento: 150.] 	raise: PorcentajeInvalidoError.		self should: [ unDescuento agregarPorcentajeDeDescuento: -10 ] 	raise: PorcentajeInvalidoError.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:45'!test02CreoDescuentoPorPorcentajeYloCalculo	| unDescuento |		unDescuento := Descuento new.	unDescuento agregarPorcentajeDeDescuento: 50.		self assert:(unDescuento calcularDescuento:500) equals: 250.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:46'!test03CreoDescuentoYloCalculo	"Al crearse el descuento que se realiza es 0"	| unDescuento |		unDescuento := Descuento new.		self assert:(unDescuento calcularDescuento:500) equals: 500.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:55'!test07SeAgregaMenuYSeLoQuitaSeRealizaDescuentoPorValor	| unDescuento |		unDescuento := Descuento new.		unDescuento agregarValorDeDescuento: 50.	unDescuento agregarMenu.	unDescuento agregarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 150.		unDescuento quitarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 150.		unDescuento quitarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 100.	! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 16:56'!test08SeAgregaMenuYSeLoQuitaSeRealizaDescuentoPorPorcentaje	| unDescuento |		unDescuento := Descuento new.		unDescuento agregarPorcentajeDeDescuento: 25.	unDescuento agregarMenu.	unDescuento agregarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 150.		unDescuento quitarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 150.		unDescuento quitarMenu.	self assert:(unDescuento calcularDescuento:150) equals: 112.5.! !!DescuentoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:03'!test10SeAgregaDescuentoPorValorMayorAlPrecioDevuelveCero	| unDescuento |		unDescuento := Descuento new.		unDescuento agregarValorDeDescuento: 200.	self assert:(unDescuento calcularDescuento:100) equals: 0.! !TestCase subclass: #PedidoTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:38'!test03SeAgregaMenuAPedidoYSeCalculaPrecio	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Diego'.		unPedido agregarMenuConNombre: 'Menú lunes' precio: 200.0 yCantidad: 1.	unPedido agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 1.		self assert: (unPedido calcularPrecioPedido) closeTo: 350.0 precision: 0.1.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:15'!test16NoPuedoIngresarCantidadesInvalidas	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 'Cuatro' ] 	raise: ParametroNoEsUnNumeroError.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 0 ] 	raise: CantidadInvalidaError.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: 1.50 ] 	raise: CantidadInvalidaError.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 10 yCantidad: -100] 	raise: CantidadInvalidaError.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:57'!test09RemoverProductos	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Sebas'.		unPedido agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2.	unPedido agregarMenuConNombre: 'Menú Lunes' precio: 200.0 yCantidad: 1. 	unPedido agregarProductoConNombre: 'vino' precio: 250.0 yCantidad: 4.	 	self assert: (unPedido calcularPrecioPedido ) equals: (2200*1.2). "20% extra"		unPedido removerProducto: 'vino'.	unPedido removerMenu: 'Menú Lunes'.		self assert: (unPedido calcularPrecioPedido) equals: (1000*1.2). "20% extra"! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:51'!test07AgregarCuponConMenuNoRealizaDescuento
	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Julia'.

	unPedido agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2.

	unPedido agregarDescuentoConValor: 15.
	
	self assert: (unPedido calcularPrecioPedido) equals: 800.0.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:00'!test10SeAgreganVariosCuponesYNoSeAcumulan
	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Pilar'.

	unPedido agregarProductoConNombre: 'Milanesa' precio: 250.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'Ensalada' precio: 200.0 yCantidad: 2.

	unPedido agregarDescuentoConValor: 50.
		self assert: (unPedido calcularPrecioPedido) closeTo: 850.0 precision: 0.01.  "-50"			 	unPedido agregarDescuentoConValor: 250.		self assert: (unPedido calcularPrecioPedido) closeTo: 650.0 precision: 0.01.  "-250"				unPedido agregarDescuentoConPorcentaje: 25.		self assert: (unPedido calcularPrecioPedido) closeTo: (900.0 * 0.75) precision: 0.01.  "-%25"	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:06'!test12SeAgreganVariosCuponesLuegoSeRetiraUnoYNoHayDescuento	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Donato'.	unPedido agregarProductoConNombre: 'Ñoquis' precio: 350.0 yCantidad: 2.	unPedido agregarProductoConNombre: 'Vinito' precio: 200.0 yCantidad: 5.	unPedido agregarDescuentoConValor: 350.		self assert: (unPedido calcularPrecioPedido) closeTo: 1350.0 precision: 0.01.  "-350"				unPedido agregarDescuentoConValor: 1.		self assert: (unPedido calcularPrecioPedido) closeTo: 1699.0 precision: 0.01.  "-1"				unPedido agregarDescuentoConPorcentaje: 50.		self assert: (unPedido calcularPrecioPedido) closeTo: (1700.0 * 0.5) precision: 0.01.  "-%50"			unPedido removerCupon.		self assert: (unPedido calcularPrecioPedido) equals: 1700.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:18'!test18NoPuedoIngresarPorcentajessInvalidos	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self should: [ unPedido agregarDescuentoConPorcentaje: 'Cuarenta'] 	raise: ParametroNoEsUnNumeroError.		self should: [ unPedido  agregarDescuentoConPorcentaje: 200 ] 	raise: PorcentajeInvalidoError.		self should: [ unPedido  agregarDescuentoConPorcentaje: -10 ] 	raise: PorcentajeInvalidoError.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:53'!test08RemoverCuponDeDescuento
	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Martina'.

	unPedido agregarDescuentoConValor: 150. 	
	unPedido agregarProductoConNombre: 'Pizza' precio: 450.0 yCantidad: 1.
	
	self assert: (unPedido calcularPrecioPedido) closeTo: 300.0 precision: 0.01.  "-150"
	
	unPedido removerCupon.

	self assert: (unPedido calcularPrecioPedido) closeTo: 450.0 precision: 0.01.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:09'!test14PedidoSinProductosTienePrecioNulo	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self assert: (unPedido calcularPrecioPedido) equals: 0.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:19'!test19NoPuedoIngresarValoresDeDescuentoInvalidos	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self should: [ unPedido agregarDescuentoConValor: 'Cien'] 	raise: ParametroNoEsUnNumeroError.		self should: [ unPedido agregarDescuentoConValor: -50 ] 	raise: ValorInvalidoError.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:34'!test01SeAgreganProductosAPedidoParaRetirarYSeCalculaElPrecio	| unPedido |		unPedido := Pedido inicializarParaRetirarConNombre: 'Tabare'.		unPedido agregarProductoConNombre: 'Milangas' precio: 300.0 yCantidad: 2.	unPedido agregarProductoConNombre: 'Flan' precio: 150.0 yCantidad: 1.		self assert: (unPedido calcularPrecioPedido) equals: 750.0.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:44'!test05SeActualizaCantidadDeProductos	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Carlos Saul'.		unPedido agregarMenuConNombre: 'Menú viernes' precio: 200.0 yCantidad: 2.	unPedido agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 1.		self assert: (unPedido cantidadProductos) equals: 3.		unPedido actualizarCantidadProducto: 'Cerveza' conCantidad: 10.		self assert: (unPedido cantidadProductos) equals: 12.! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:11'!test15PedidoSinProductosTieneCantidadNula	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self assert: (unPedido cantidadProductos) equals: 0.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:03'!test11SeAplicaDescuentoConMenuLuegoSeQuitaElMenuYPuedeAplicarseElDescuento
	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'El Chino Luna'.	unPedido agregarMenuConNombre: 'Menu jueves' precio: 200.0 yCantidad: 2.	unPedido agregarMenuConNombre: 'Menu especial' precio: 300.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'Cerveza' precio: 150.0 yCantidad: 10.

	unPedido agregarDescuentoConValor: 500.
	
	self assert: (unPedido calcularPrecioPedido) equals: 2500.0.		unPedido removerMenu: 'Menu especial'.		self assert: (unPedido calcularPrecioPedido) equals: 1900.0.		unPedido removerMenu: 'Menu jueves'.		self assert: (unPedido calcularPrecioPedido) equals: 1000.0.	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:36'!test02SeAgreganProductosAPedidoConDeliveryYSeCalculaPrecio
	| unPedido | 
	
	unPedido := Pedido inicializarParaDeliveryConNombre: 'Raul'.
	
	unPedido agregarProductoConNombre: 'Asado' precio: 500.0 yCantidad: 2.
	unPedido agregarProductoConNombre: 'fernet' precio: 500.0 yCantidad: 1.
	unPedido agregarProductoConNombre: 'coca cola' precio: 250.0 yCantidad: 2.	
	self assert: (unPedido calcularPrecioPedido ) equals: (2000*1.2). "20% extra"! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:08'!test13SeAgreganDecuentoConValorMayorAlPrecioEsteSaleGratis	| unPedido | 		unPedido := Pedido inicializarParaRetirarConNombre: 'Cardona'.	unPedido agregarProductoConNombre: 'Bondiola con papas' precio: 400.0 yCantidad: 1.	unPedido agregarDescuentoConValor: 500.		self assert: (unPedido calcularPrecioPedido) equals: 0.  "-500"	! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:48'!test06AplicarCuponDeDescuentoAPedido
	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Gonzalo'.

	unPedido agregarDescuentoConValor:  100. 	
	unPedido agregarProductoConNombre: 'Milanesa' precio: 350.0 yCantidad: 1.
	
	self assert: (unPedido calcularPrecioPedido) closeTo: (350*1.2 - 100) precision: 0.01. "-100"! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:41'!test04AplicarCuponDeDescuentoPorPorcentajeAPedido	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Diego'.		unPedido agregarProductoConNombre: 'Hamburguesa' precio: 400.0 yCantidad: 1.	unPedido agregarDescuentoConPorcentaje: 30. 		self assert: (unPedido calcularPrecioPedido ) closeTo: (400*0.7*1.2) precision: 0.01. "-10%"! !!PedidoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 18:16'!test17NoPuedoIngresarPreciosInvalidos	| unPedido | 		unPedido := Pedido inicializarParaDeliveryConNombre: 'Edwin'.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 'diez' yCantidad: 2 ] 	raise: ParametroNoEsUnNumeroError.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: -250.0 yCantidad: 2 ] 	raise: PrecioInvalidoError.		self should: [ unPedido agregarProductoConNombre: 'Lechon' precio: 0 yCantidad: 2 ] 	raise: PrecioInvalidoError.! !TestCase subclass: #ProductoTests	instanceVariableNames: ''	classVariableNames: ''	package: 'TP1-Tests'!!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:28'!test07NoPuedoActualizarConCantidadesInvalidas	| unProducto |	unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 250  yCantidad: 1.		self should: [ unProducto actualizarCantidad:  'Uno'.] 	raise: ParametroNoEsUnNumeroError.		self should: [ unProducto actualizarCantidad: 4.20.]	raise: CantidadInvalidaError.		self should: [ unProducto actualizarCantidad: 0.]	raise: CantidadInvalidaError.		self should: [ unProducto actualizarCantidad: -20.]	raise: CantidadInvalidaError.! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:29'!test06NoPuedoInicializarConCantidadInvalida	| unProducto |		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 50  yCantidad: 'Uno'.] 	raise: ParametroNoEsUnNumeroError.		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 50 yCantidad: 4.20.]	raise: CantidadInvalidaError.		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 50 yCantidad: 0.]	raise: CantidadInvalidaError.		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 50 yCantidad: -250.]	raise: CantidadInvalidaError.! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:20'!test04ActualizoCantidadYComparoSuCantidad	| unProducto |	unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 250 yCantidad: 4.	self assert:(unProducto darCantidad) equals: 4.	unProducto actualizarCantidad: 10.	self assert:(unProducto darCantidad) equals: 10.! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:17'!test01CreoProductoyCalculoSuPrecio	| unProducto |	unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 250 yCantidad: 2.	self assert:(unProducto calcularPrecioProducto) equals: 500.! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:17'!test02CreoProductoyCalculoSuCantidad	| unProducto |	unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 250 yCantidad: 38.	self assert:(unProducto darCantidad) equals: 38.! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:19'!test03ActualizoCantidadYComparoSuPrecio	| unProducto |	unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 250 yCantidad: 4.	self assert:(unProducto calcularPrecioProducto) equals: 1000.	unProducto actualizarCantidad: 10.	self assert:(unProducto calcularPrecioProducto) equals: 2500.	! !!ProductoTests methodsFor: 'tests' stamp: 'Tabareski 11/5/2020 17:28'!test05NoPuedoInicalizarConPrecioInvalido	| unProducto |		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 'Tres' yCantidad: 4.] 	raise: ParametroNoEsUnNumeroError.		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: -420 yCantidad: 4.]	raise: PrecioInvalidoError.		self should: [ unProducto := Producto incializarConNombre: 'Salchipapa' ConPrecio: 0 yCantidad: 4.]	raise: PrecioInvalidoError.	! !
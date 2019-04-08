var listarFabricante = new Vue({
	el:"#listarFabricante",
	data: {
		listarFabricantes: [],

	},
	created: function(){
        let vm =  this;
        vm.buscaFabricante();
    },
    methods:{
    	buscaFabricante: function(){
    		const vm = this;
			axios.get("/mercado/rs/fabricantes/listar")
			.then(response => {
				console.log("sucess fabricante->"+response.data);
				vm.listarFabricantes = response.data;
			
			}).catch(function (error) {
				console.log("error fabricante->"+error.response);
			}).finally(function() {
			});
    	},
}
});
var adicionar = new Vue({
	el: '#adicionar',
	data: {
		msg: 'Salvando novo produto',
		salvar:[nome:"", volume:"",unidade:"",estoque:""]
	},
	methods:{
		adicionarProduto(){
			axion.post('/produtos/salvar', {content: this.salvar}).
			then(function (response){
				console.log(response);
			}).catch(function (error){
				console.log(error);
			})
		}
	}
});


var inicio = new Vue({
	el:"#inicio",
    data: {
        listaProdutos: [],
        listaProdutosHeader: [
			{sortable: false, key: "nome", label:"Nome"},
			{sortable: false, key: "fabricante.nome", label:"Fabricante"},
			{sortable: false, key: "volume", label:"Volume"},
			{sortable: false, key: "unidade", label:"Unidade"},
			{sortable: false, key: "estoque", label:"Estoque"}
		]
    },
    created: function(){
        let vm =  this;
        vm.buscaProdutos();
    },
    methods:{
        buscaProdutos: function(){
			const vm = this;
			axios.get("/mercado/rs/produtos")
			.then(response => {
				console.log("sucess->"+response.data);
				vm.listaProdutos = response.data;
			}).catch(function (error) {
				console.log("error->"+error.response);
				//vm.mostraAlertaErro("Erro interno", "Não foi listar natureza de serviços");
			}).finally(function() {
			});
		},
		
		
		salvarProduto: function(){
			console.log("Salvar produto"+inicio);
			console.log("Salvar produto"+inicio.listaProdutosHeader.nome);
			var memForm = inicio.toFormData(inicio.listaProdutosHeader);
			console.log("Salvar produto"+memForm);
			
//			let params = new URLSearchParams(uri);
//		    console.log(params.get("nome"));
			axios.post("/mercado/rs/produtos/salvar", )
			.then(response => {
				console.log("sucess->"+response.data);
			}).catch(function (error) {
				console.log("error-salvar>"+error.response);
				//vm.mostraAlertaErro("Erro interno", "Não foi listar natureza de serviços");
			}).finally(function() {
			});
		},
		
		toFormData: function(obj){
			var form_data = new FormData();
			for(var key in obj){
				form_data.append(key, obj[key]);
			}
			return form_data;
		},
    }
});
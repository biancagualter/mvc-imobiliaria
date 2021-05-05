var modal = document.getElementById('imoveisModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idImovel = button.getAttribute('data-id')
	var nomeImovel = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idImovel)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o imóvel <strong>' + idImovel + '</strong>?')
	
})
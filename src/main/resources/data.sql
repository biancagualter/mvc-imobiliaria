insert into permissao (id, nome) values 
	(1, 'IMOVEIS'),
	(2, 'IMOVEIS_NOVO'),
	(3, 'CATEGORIAS'),
	(4, 'CATEGORIAS_NOVO'),
	(5, 'NEGOCIOS'),
	(6, 'NEGOCIOS_NOVO'),
	(7, 'ESTADOS_NOVO'),
	(8, 'ESTADOS_NOVO'),
	(9, 'MUNICIPIOS'),
	(10, 'MUNICIPIOS_NOVO'),
	(11, 'BAIRROS'),
	(12, 'BAIRROS_NOVO'),
	(13, 'HOME')
;
	
insert into usuario (id, nome, login, senha, ativo) values 
	(1, 'adm', 'adm', '$2a$10$vCSgnSgsbB6pcr4v7UVEaebvo6KARHqsbWhzOLgMz4cSpKosmiiiy', true),
	(2, 'user', 'user', '$2a$10$iyIENEiTP58bXKnfULXQQ.XfEkKLLTQ4zbqPjkwNKt089dPQaIWtq', true)
;
	
insert into usuario_permissao (usuario_id, permissao_id) values 
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(1, 9),
	(1, 10),
	(1, 11),
	(1, 12),
	(1, 13),
	(2, 13)
;

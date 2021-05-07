insert into categorias (categoria) values ("Casa");
insert into categorias (categoria) values ("Apartamento")
insert into categorias (categoria) values ("Sítio")

insert into negocios (negocio) values ("Aluguel")
insert into negocios (negocio) values ("Compra")

insert into estados (estado, uf) values ("São Paulo", "SP")
insert into estados (estado, uf) values ("Rio de Janeiro", "RJ")
insert into estados (estado, uf) values ("Minas Gerais", "MG")

insert into municipios (municipio, estado_id) values ("São Paulo", 1) 
insert into municipios (municipio, estado_id) values ("Rio de Janeiro", 2)
insert into municipios (municipio, estado_id) values ("Belo Horizonte", 3)
insert into municipios (municipio, estado_id) values ("Embu-Guaçu", 1)

insert into bairros (bairro, estado_id, municipio_id) values ("Santo Amaro", 1, 1)
insert into bairros (bairro, estado_id, municipio_id) values ("Recreio dos Bandeirantes", 2, 2)
insert into bairros (bairro, estado_id, municipio_id) values ("Buritis", 3, 3)
insert into bairros (bairro, estado_id, municipio_id) values ("Cipó", 1, 4)

insert into imoveis (data, quartos, valor, categoria_id, estado_id, negocio_id) values ("2021-05-02", 2, "1100", 1, 1, 1)
insert into imoveis (data, quartos, valor, categoria_id, estado_id, negocio_id) values ("2021-03-01", 2, "360000", 2, 3, 2)
insert into imoveis (data, quartos, valor, categoria_id, estado_id, negocio_id) values ("2021-04-05", 3, "2000", 1, 2, 1)
insert into imoveis (data, quartos, valor, categoria_id, estado_id, negocio_id) values ("2021-01-08", 5, "450000", 3, 1, 2)
	
insert into usuario (login, nome, senha) values ("adm", "Adm", "$2a$10$7TSdKZmr7UacMJMN3BqlJuDNy5CUo4rgLp3rHJ0gA29i0ITAxHfIq")
insert into usuario (login, nome, senha) values ("user", "User", "$2a$10$WY.F0EwRMt5bgVSPsp0ku.AP4bdvz4WEDn5y0Vk7bVxYusKOPO78u")

insert into role(role) values ("ROLE_ADMIN")
insert into role(role) values ("ROLE_USER")

insert into usuarios_roles(usuario_id, role_id) values ("adm", "ROLE_ADMIN")
insert into usuarios_roles(usuario_id, role_id) values ("user", "ROLE_USER")


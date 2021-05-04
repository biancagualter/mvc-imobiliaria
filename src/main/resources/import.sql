insert into categorias (categoria) values ("Casa");
insert into categorias (categoria) values ("Apartamento")

insert into negocios (negocio) values ("Aluguel");
insert into negocios (negocio) values ("Aluguel")

insert into estados (estado, uf) values ("São Paulo", "SP")
insert into estados (estado, uf) values ("Rio de Janeiro", "RJ")

insert into municipios (municipio, estado_id) values ("São Paulo", 1) 
insert into municipios (municipio, estado_id) values ("Rio de Janeiro", 2)

insert into bairros (bairro, estado_id, municipio_id) values ("Santo Amaro", 1, 1)
insert into bairros (bairro, estado_id, municipio_id) values ("Recreio dos Bandeirantes", 2, 2)

insert into imoveis (data, quartos, valor, categoria_id, estado_id, negocio_id) values ("2021-05-02", 2, "1100", 1, 1, 1)
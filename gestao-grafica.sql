CREATE DATABASE gestaografica;

USE gestaografica;

CREATE TABLE usuario(
id bigint primary key auto_increment,
nome varchar(80) not null,
usuariousuario varchar(50) not null unique,
senha  varchar(100) not null,
perfil varchar(10) not null default 'PADRAO',
estado boolean  not null default true,
data_hora_criacao datetime default current_timestamp,
aultimo_login datetime default '001-01-01 00:00'
);

CREATE TABLE categoria(
id int primary key auto_increment,
nome varchar(50) not null unique,
descricao varchar(200)
);

CREATE TABLE produto(
id bigint primary key auto_increment,
nome varchar(50) not null unique,
descricao varchar(200),
preco decimal(10,2) not null, 
quantidade int not null,
categoria_id int not null,
usuario_id bigint not null,
data_hora_criacao datetime default current_timestamp,
constraint fk_produto_categoria foreign key(categoria_id) references categoria(id),
constraint fk_produto_usuario foreign key(usuario_id) references usuario(id)
);

CREATE TABLE cliente(
id int primary key auto_increment,
nome varchar(60),
telefone varchar(15),
morada varchar(100)
);

CREATE TABLE venda(
id int primary key auto_increment,
total_venda decimal(10,2) not null, 
valor_pago decimal(10,2) not null, 
troco decimal(10,2) not null, 
desconto decimal(10,2) not null, 
cliente_id int,
usuario_id bigint not null,
datat_hora_ceriacao datetime default current_timestamp,
ultima_actualizacao datetime default current_timestamp,
constraint fk_venda_cliente foreign key(cliente_id) references cliente(id),
constraint fk_venda_usuario foreign key(usuario_id) references usuario(id)
);

CREATE TABLE venda_intem(
venda_id int not null,
produto_id bigint not null,
quantidade int not null,
total decimal(10,2) not null, 
desconto decimal(10,2) not null, 
constraint fk_venda_intem_venda foreign key(venda_id) references venda(id),
constraint fk_venda_intem_produto foreign key(produto_id) references produto(id)
);











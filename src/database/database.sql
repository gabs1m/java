create database if not exists papelaria;
use papelaria;

create table material(
    codigo_material int not null auto_increment,
    tipo varchar not null,
    descricao text not null,
    categoria varchar not null,
    lote varchar not null,
    data_fabricacao date not null,
    valor_unitario float not null,
    quantidade int not null,
    primary key(codigo_material)
);

create table funcionario(
    codigo_funcionario int not null auto_increment,
    cpf varchar not null unique,
    nome varchar not null,
    idade int not null,
    sexo char(1) not null,
    endereco text not null,
    telefone varchar not null,
    numero_conta varchar not null,
    permissao_admin boolean not null,
    senha_gerencial varchar null,
    primary key(codigo_funcionario)
);

create table cliente(
    codigo_cliente int not null auto_increment,
    cpf varchar not null unique,
    nome varchar not null,
    idade int not null,
    sexo char(1) not null,
    endereco text not null,
    telefone varchar not null,
    primary key(codigo_cliente)
);

create table pedido(
    codigo_pedido int not null auto_increment,
    codigo_rastreio int not null auto_increment,
    data_pedido date not null,
    data_entrega date not null,
    valor_pedido float not null,
    codigo_cliente int not null,
    primary key(codigo_pedido),
    foreign key(codigo_cliente) references cliente(codigo_cliente)
);

create table materiais_pedido(
    codigo_pedido int not null,
    codigo_material int not null,
    tipo_material varchar not null,
    quantidade_material int not null,
    valor_unitario_material float not null
    primary key(codigo_material),
    foreign key(codigo_material) references material(codigo_material),
    foreign key(codigo_pedido) references pedido(codigo_pedido)
);
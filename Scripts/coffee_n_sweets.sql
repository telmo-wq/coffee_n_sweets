create database coffee_n_sweets;

use coffee_n_sweets;

create table Cliente (
	ID_cliente int auto_increment primary key,
	Nome varchar(40) not null,
	Email varchar(40) not null,
	Data_cadastro date not null default (curdate()),
	constraint unique_email_cliente unique (Email)
);

create table Telefone_cliente (
	ID_telefone_cliente int auto_increment primary key,
	Telefone varchar(40) not null,
	ID_cliente int not null,
	constraint FK_telefone_cliente foreign key (ID_cliente) references Cliente (ID_cliente) on update cascade on delete cascade,
	constraint unique_telefone_cliente unique (ID_cliente, Telefone)
);

create table Produto (
	ID_produto int auto_increment primary key,
	Nome varchar(40) not null,
	Preco decimal(10, 2) not null,
	Descricao text not null,
	constraint unique_produto unique (Nome),
  constraint check_preco_positivo check (Preco > 0.0)
);

create table Lanche (
	Tipo varchar(40) not null check (Tipo in ('Doce', 'Salgado')),
	ID_produto int not null,
	primary key (ID_produto),
	constraint FK_lanche_produto foreign key (ID_produto) references Produto (ID_produto) on update cascade on delete cascade
);

create table Bebida (
	Tamanho varchar(40) not null default 'Médio' check (Tamanho in ('Pequeno', 'Médio', 'Grande')),
	Gelo bool not null default true,
	ID_produto int not null,
	primary key (ID_produto),
	constraint FK_bebida_produto foreign key (ID_produto) references Produto (ID_produto) on update cascade on delete cascade
);

create table Grao (
	ID_grao int auto_increment primary key,
	Nome varchar(40) not null,
	Origem varchar(40) not null,
	constraint unique_grao unique (Nome, Origem)
);

create table Cafe (
	Temperatura varchar(40) not null check (Temperatura in ('Quente', 'Gelado')),
	Tecnica_moagem varchar(40) not null check (Tecnica_moagem in ('Fina', 'Média', 'Grossa')),
	Tipo varchar(40),
	ID_grao int not null,
	ID_produto int not null,
	primary key (ID_produto),
	constraint FK_cafe_grao foreign key (ID_grao) references Grao (ID_grao) on update cascade,
	constraint FK_cafe_produto foreign key (ID_produto) references Produto (ID_produto) on update cascade on delete cascade
);

create table Mesa (
	Numero_mesa int primary key,
	Capacidade int not null,
	Localizacao varchar(40) not null check (Localizacao in ('Salão interno', 'Área externa')),
  constraint capacidade_positiva check (Capacidade >= 2)
);

create table Funcionario (
	ID_funcionario int auto_increment primary key,
	Nome varchar(40) not null,
	Cargo varchar(40) not null check (Cargo in ('Atendente', 'Barista', 'Gerente')),
	Data_admissao date not null default (curdate()),
	ID_funcionario_supervisor int,
	constraint FK_funcionario_supervisor foreign key (ID_funcionario_supervisor) references Funcionario (ID_funcionario) on update cascade on delete set null
);

create table Telefone_funcionario (
	ID_telefone_funcionario int auto_increment primary key,
	Telefone varchar(40) not null,
	ID_funcionario int not null,
	constraint FK_telefone_funcionario foreign key (ID_funcionario) references Funcionario (ID_funcionario) on update cascade,
	constraint unique_telefone_funcionario unique (ID_funcionario, Telefone)
);

create table Fornecedor (
	ID_fornecedor int auto_increment primary key,
	Razao_social varchar(40) not null,
	Rua varchar(40) not null,
	Numero int not null,
	Bairro varchar(40) not null,
	Cidade varchar(40) not null,
	CEP varchar(40) not null
);

create table Telefone_fornecedor (
	ID_telefone_fornecedor int auto_increment primary key,
	Telefone varchar(40) not null,
	ID_fornecedor int not null,
	constraint FK_telefone_fornecedor foreign key (ID_fornecedor) references Fornecedor (ID_fornecedor) on update cascade,
	constraint unique_telefone_fornecedor unique (ID_fornecedor, Telefone)
);

create table Fornece (
	ID_fornecedor int not null,
	ID_grao int not null,
	Preco_kg decimal(10, 2) not null,
	Data_ultima_entrega date not null default (curdate()),
	Quantidade_solicitada float not null default 0.0,
	primary key (ID_fornecedor, ID_grao),
	constraint FK_fornece_fornecedor foreign key (ID_fornecedor) references Fornecedor (ID_fornecedor) on update cascade,
	constraint FK_fornece_grao foreign key (ID_grao) references Grao (ID_grao) on update cascade,
  constraint preco_kg_positivo check (Preco_kg >= 0.0)
);

create table Equipamento (
	ID_equipamento int auto_increment primary key,
	Nome varchar(40) not null,
	Data_aquisicao date not null
);

create table Pedido_pagamento (
	ID_pagamento int auto_increment primary key,
	Data date not null default (curdate()),
	Horario time not null default (curtime()),
	Tipo_consumo varchar(40) not null default 'Aqui' check (Tipo_consumo in ('Aqui', 'Para viagem')),
	Status varchar(40) not null default 'Pendente' check (Status in ('Pendente', 'Em preparo', 'Pronto')),
	ID_cliente int not null,
	ID_funcionario int not null,
	Numero_mesa int,
	Forma_pagamento varchar(40) not null check (Forma_pagamento in ('Débito', 'Crédito', 'Dinheiro')),
	Valor_total decimal(10, 2) not null default 0.0,
	constraint FK_pagamento_cliente foreign key (ID_cliente) references Cliente (ID_cliente) on update cascade,
	constraint FK_pagamento_funcionario foreign key (ID_funcionario) references Funcionario (ID_funcionario) on update cascade,
	constraint FK_pagamento_mesa foreign key (Numero_mesa) references Mesa (Numero_mesa) on update cascade on delete set null
);

create table Item_pedido (
	Numero_item int,
	Quantidade int not null,
	Preco_unitario decimal(10, 2) not null,
	Observacao text,
	ID_pagamento int not null,
	ID_produto int not null,
	primary key (Numero_item, ID_pagamento),
	constraint FK_pagamento foreign key (ID_pagamento) references Pedido_pagamento (ID_pagamento) on update cascade on delete cascade,
	constraint FK_item_pedido_produto foreign key (ID_produto) references Produto (ID_produto) on update cascade,
  constraint quantidade_positiva check (Quantidade > 0)
);

create table Prepara (
	Numero_item int not null,
	ID_pagamento int not null,
	ID_funcionario int not null,
	ID_equipamento int not null,
	primary key (Numero_item, ID_pagamento, ID_funcionario, ID_equipamento),
	constraint FK_item_pedido foreign key (Numero_item, ID_pagamento) references Item_pedido (Numero_item, ID_pagamento) on update cascade on delete cascade,
	constraint FK_funcionario foreign key (ID_funcionario) references Funcionario (ID_funcionario) on update cascade,
	constraint FK_equipamento foreign key (ID_equipamento) references Equipamento (ID_equipamento) on update cascade
);
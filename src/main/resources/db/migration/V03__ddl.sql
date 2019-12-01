
   

insert into pessoa (pes_id, pes_cpf, pes_nome) values (nextval('pessoa_seq'),null,'administrador');
insert into usuario (usu_id, usu_login,usu_perfil,usu_senha,usu_status,pes_id) 
  values (nextval('usuario_seq'),'adm','ADMINISTRADOR',123,'ATIVO',1);
--update usuario set pes_id=(1);

--------------------------------------------------------------------------------------------



--Query Pessoa

INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '11111111111', 'robson@gmail.com', 'Robson', '123456789', '1980-01-08', 'Masculino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '22222222222', 'debora@gmail.com', 'Debora', '987654321', '1986-08-26', 'Feminino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '33333333333', 'joao@gmail.com', 'João', '831645297', '1987-07-12', 'Masculino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '44444444444', 'katia@gmail.com', 'Katia', '168423597', '1990-03-20', 'Feminino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '55555555555', 'lucas@gmail.com', 'Lucas', '9513574682', '1979-01-08', 'Masculino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '66666666666', 'vanessa@gmail.com', 'Vanessa', '467913258', '1980-08-19', 'Feminino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '77777777777', 'junior@gmail.com', 'Junior', '64938217', '1976-12-31', 'Masculino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '88888888888', 'angelica@gmail.com', 'Angelica', '168423597', '1997-09-11', 'Feminino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '99999999999', 'carlos@gmail.com', 'Carlos', '147258369', '1982-01-30', 'Masculino');
	
	INSERT INTO public.pessoa(
	pes_id, pes_cpf, pes_email, pes_nome, pes_rg, pes_data_aniversario, pes_genero)
	VALUES (nextval('pessoa_seq'), '01234567891', 'marcia@gmail.com', 'Marcia', '123789456', '1964-11-17', 'Feminino');
-----------------------------------------------------------------------------------------
--Query Usuario

INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '11111111111', 'CLIENTE', '12345', 'ATIVO', 2);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '22222222222', 'CLIENTE', '12345', 'ATIVO', 3);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '33333333333', 'CLIENTE', '12345', 'ATIVO', 4);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '44444444444', 'CLIENTE', '12345', 'ATIVO', 5);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '55555555555', 'CLIENTE', '12345', 'ATIVO', 6);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '66666666666', 'CLIENTE', '12345', 'ATIVO', 7);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '77777777777', 'ADMINISTRADOR', '12345', 'ATIVO', 8);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '88888888888', 'CLIENTE', '12345', 'ATIVO', 9);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '99999999999', 'CLIENTE', '12345', 'ATIVO', 10);
	
	INSERT INTO public.usuario(
	usu_id, usu_hashcode, usu_login, usu_perfil, usu_senha, usu_status, pes_id)
	VALUES (nextval('usuario_seq'), null, '01234567891', 'ADMINISTRADOR', '12345', 'ATIVO', 11);
-----------------------------------------------------------------------------------------
--Query Telefone

INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '953892533', 'ATIVO', 2);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '986754013', 'ATIVO', 2);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '21', '980765408', 'ATIVO', 3);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '21', '984025817', 'ATIVO', 3);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '472846375', 'ATIVO', 4);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '490367480', 'ATIVO', 4);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '981634570', 'ATIVO', 5);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '972345180', 'ATIVO', 5);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '14', '935674831', 'ATIVO', 6);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '14', '48723451', 'ATIVO', 6);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '17', '490367480', 'ATIVO', 7);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '17', '981230456', 'ATIVO', 7);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '998970823', 'ATIVO', 8);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '972893451', 'ATIVO', 8);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '71', '953467128', 'ATIVO', 9);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '71', '90873451', 'ATIVO', 9);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '47255521', 'ATIVO', 10);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '965347081', 'ATIVO', 10);
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '970643008', 'ATIVO', 11);
	
	INSERT INTO public.telefone(
	tel_id, tel_ddd, tel_numero, tel_status, pes_id)
	VALUES (nextval('telefone_seq'), '11', '90876539', 'ATIVO', 11);
-----------------------------------------------------------------------------------------
--Query Endereco

INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Casa Mae', 'fatec', '09654320', 'Mogi das Cruzes', 'Casa 432', 'SP', 'Rua Carlos Gabriel', 100, 'ATIVO', 'Cobrança', 2);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Trabalho', 'Vila Brasileira', '09654320', 'Mogi das Cruzes', 'Apos escola objetivo', 'SP', 'Rua Junior frança', 100, 'ATIVO', 'Cobrança', 3);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Chácara', 'Orego', '09654320', 'Mogi das Cruzes', 'Condominio Vila Olimpia', 'SP', 'Rua Hash map', 100, 'ATIVO', 'Cobrança', 4);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Casa irmã', 'Oscar Filho', '09654320', 'Mogi das Cruzes', 'Depois da padaria', 'SP', 'Rua Hersheys ', 100, 'ATIVO', 'Cobrança', 5);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Casa Vó', 'Vila moraes', '09654320', 'Mogi das Cruzes', 'Proximo a praça', 'SP', 'Rua Ana Maria', 100, 'ATIVO', 'Cobrança', 6);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Escola', 'Vila Lavinia', '09654320', 'Mogi das Cruzes', 'Perto da casa de construção', 'SP', 'Rua Eldorado ', 100, 'ATIVO', 'Cobrança', 7);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Ap Gabriel', 'Obelisco', '09654320', 'Mogi das Cruzes', 'Perto da farmacia', 'SP', 'Rua Nova Caminhada', 100, 'ATIVO', 'Cobrança', 8);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Casa irmão', 'Epílogo', '09654320', 'Mogi das Cruzes', 'Ao lado do hospital', 'SP', 'Rua Mauricio de Souza', 100, 'ATIVO', 'Cobrança', 9);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Condominio', 'Vila Velha', '09654320', 'Mogi das Cruzes', 'Perto do shopping', 'SP', 'Rua Jhenifer Santos', 100, 'ATIVO', 'Cobrança', 10);
	
	INSERT INTO public.endereco(
	end_id, end_apelido, end_bairro, end_cep, end_cidade, end_complemento, end_estado, end_logradouro, end_numero, tel_status, end_tipo, pes_id)
	VALUES (nextval('endereco_seq'), 'Serviço', 'Vila Nova', '09654320', 'Mogi das Cruzes', 'Loja de roupas', 'SP', 'Rua Joao Guilherme', 100, 'ATIVO', 'Cobrança', 11);

-----------------------------------------------------------------------------------------
--Query Tipo Pagamento

INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
	
	INSERT INTO public.tipo_pagamento(
	tpp_id)
	VALUES (nextval('tipo_pagamento_pagamento_seq'));
-----------------------------------------------------------------------------------------
--Query cartao
INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (123, 'ROBSON SILVA', '0817352789453098', true, 'ATIVO', 11/2025, 1, 2, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (091, 'DEBORA ALCANTARA', '1729045627834018', true, 'ATIVO', 10/2024, 2, 3, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (761, 'JOAO GUILHERME SILVA', '0195892610298432', true, 'ATIVO', 06/2024, 3, 4, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (245, 'KATIA MARIA', '0144094673982743', true, 'ATIVO', 12/2020, 4, 5, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (205, 'LUCAS MORAES', '1034591873029126', true, 'ATIVO', 02/2023, 5, 6, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (401, 'VANESSA REIS', '105348298510', true, 'ATIVO', 12/2025, 6, 7, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (142, 'JUNIOR MASSARO', '154185613091273', true, 'ATIVO', 01/2020, 7, 8, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (287, 'ANGELICA CRISTINA', '1019101810171016', true, 'ATIVO', 08/2021, 8, 9, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (367, 'CARLOS RODRUIGUES JUNIOR', '1456145614561456', true, 'ATIVO', 05/2026, 9, 10, 'VISA');
	
	INSERT INTO public.cartao(
	car_cod_seguranca, car_nome_cartao, car_numero_cartao, car_preferencial, car_status, car_validade, tpp_id, pes_id, car_bandeira)
	VALUES (321, 'MARCIA GONCALVES', '4321432143214321', true, 'ATIVO', 06/2025, 10, 11, 'VISA');

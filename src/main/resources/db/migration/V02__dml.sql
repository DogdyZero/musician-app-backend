--DDL banco

    create table carrinho_compra (
		crc_id integer not null PRIMARY KEY,
		crc_total_carrinho float
    );
    
    create table cartao (
        tpp_id integer not null PRIMARY KEY,
   		car_bandeira varchar(255),
        car_cod_seguranca integer,
        car_nome_cartao varchar(255),
        car_numero_cartao varchar(255),
        car_preferencial boolean,
        car_status varchar(255),
        car_validade varchar(255),
        pes_id integer
    );
    
    create table categoria (
       cat_id int4 not null,
        cat_nome varchar(255),
        primary key (cat_id)
    );
 
    
    create table cupom (
       cpm_codigo varchar(255),
        cpm_origem_cupom varchar(255),
        cpm_status varchar(255),
        cpm_valor float8,
        tpp_id int4 not null,
        pes_id int4,
        primary key (tpp_id)
    );
 
    
    create table endereco (
       end_id int4 not null,
        end_apelido varchar(255),
        end_bairro varchar(255),
        end_cep varchar(255),
        end_cidade varchar(255),
        end_complemento varchar(255),
        end_estado varchar(255),
        end_logradouro varchar(255),
        end_numero int4,
        tel_status varchar(255),
        end_tipo varchar(255),
        pes_id int4,
        primary key (end_id)
    );
 
    
    create table estoque (
       est_id int4 not null,
        est_data_entrada date,
        est_data_venda date,
        est_fornecedor varchar(255),
        est_qtd_produto int4,
        pro_id int4,
        primary key (est_id)
    );
 
    
    create table forma_pagamento (
       fmp_id int4 not null,
        fmp_pago boolean,
        fmp_saldo float8,
        pag_id int4,
        primary key (fmp_id)
    );
 
    
    create table frete (
       fre_id int4 not null,
        fre_calculo_frete float8,
        fre_prazo timestamp,
        end_id int4,
        primary key (fre_id)
    );
 
    
    create table grupo_precificacao (
       gpr_id int4 not null,
        gpr_custo_compra float8,
        gpr_margem_lucro float8,
        gpr_valor_final float8,
        primary key (gpr_id)
    );
 
    
    create table historico_produto (
       hpr_id int4 not null,
        hpr_descricao varchar(255),
        hpr_tipo_mudanca varchar(255),
        primary key (hpr_id)
    );
 
    
    create table item_produto (
       ipr_id int4 not null,
        prod_cod_barras varchar(255),
        ipd_quantidade int4,
        ipd_valor_produto float8,
        prod_id int4,
        tro_id int4,
        crc_id int4,
        primary key (ipr_id)
    );
 
    
    create table pagamento (
       pag_id int4 not null,
        pag_pagamento_efetivado boolean,
        pag_total float8,
        primary key (pag_id)
    );
 
    
    create table pedido (
       ped_id int4 not null,
        ped_data date,
        ped_status varchar(255),
        ped_valor float8,
        crc_id int4,
        fre_id int4,
        pag_id int4,
        pes_id int4,
        primary key (ped_id)
    );
 
    
    create table pessoa (
       pes_id int4 not null,
        pes_cpf varchar(255),
        pes_data_aniversario date,
        pes_email varchar(255),
        pes_genero varchar(255),
        pes_nome varchar(255),
        pes_rg varchar(255),
        primary key (pes_id)
    );
 
    
    create table produto (
       prod_id int4 not null,
        prod_ano timestamp,
        prod_data_cadastro date,
        prod_desc varchar(255),
        prod_dimensao varchar(255),
        prod_ean varchar(255),
        prod_foto_imagem bytea,
        prod_marca varchar(255),
        prod_modelo varchar(255),
        prod_nome varchar(255),
        prod_imagem varchar(255),
        prod_status varchar(255),
        prod_categoria_id int4,
        grp_id int4,
        primary key (prod_id)
    );
 
    
    create table telefone (
       tel_id int4 not null,
        tel_ddd varchar(255),
        tel_numero varchar(255),
        tel_status varchar(255),
        pes_id int4,
        primary key (tel_id)
    );
 
    
    create table tipo_pagamento (
       tpp_id int4 not null,
        primary key (tpp_id)
    );
 
    
    create table troca (
       tro_id int4 not null,
        tro_data_solicitacao date,
        tro_data_resposta date,
        tro_descricao_problema varchar(255),
        tro_resposta varchar(255),
        ipd_status_troca varchar(255),
        cpm_id int4,
        primary key (tro_id)
    );
 
    
    create table usuario (
       usu_id int4 not null,
        usu_hashcode varchar(255),
        usu_login varchar(255),
        usu_perfil varchar(255),
        usu_senha varchar(255),
        usu_status varchar(255),
        pes_id int4,
        primary key (usu_id)
    );
	
    create sequence carrinho_produto_seq start 1 increment 1;
 	create sequence categoria_seq start 1 increment 1;
	create sequence compra_seq start 1 increment 1;
	create sequence endereco_seq start 1 increment 1;
	create sequence estoque_seq start 1 increment 1;
	create sequence form_pagamento_seq start 1 increment 1;
	create sequence frete_seq start 1 increment 1;
	create sequence historico_produto_seq start 1 increment 1;
	create sequence item_produto_seq start 1 increment 1;
	create sequence pedido_seq start 1 increment 1;
	create sequence pessoa_seq start 1 increment 1;
	create sequence precificacao_seq start 1 increment 1;
	create sequence produto_seq start 1 increment 1;
	create sequence telefone_seq start 1 increment 1;
	create sequence tipo_pagamento_pagamento_seq start 1 increment 1;
	create sequence troca_seq start 1 increment 1;
	create sequence usuario_seq start 1 increment 1;
	 
 alter table cartao 
       add constraint FKbq60c8babfph2alkjug91b9kf 
       foreign key (tpp_id) 
       references tipo_pagamento;
 
    
    alter table cartao 
       add constraint FKianxmcscmwc0j4vebkmowqn3d 
       foreign key (pes_id) 
       references pessoa;
 
    
    alter table cupom 
       add constraint FK4u2uqajkc7a5gqysbakhm7d6n 
       foreign key (tpp_id) 
       references tipo_pagamento;
 
    
    alter table cupom 
       add constraint FKfwws9128k1by08b41a9wffvfp 
       foreign key (pes_id) 
       references pessoa;
 
    
    alter table endereco 
       add constraint FKsoltaode1eeuabrryn2ys6bxg 
       foreign key (pes_id) 
       references pessoa;
 
    
    alter table estoque 
       add constraint FKiwm76ki8k9e19wsvnp82h3ldm 
       foreign key (pro_id) 
       references produto;
 
    
    alter table forma_pagamento 
       add constraint FKc93e8mx50j5bgjx18tuy82fdf 
       foreign key (pag_id) 
       references pagamento;
 
    
    alter table frete 
       add constraint FKh811nxfhuw79idcsupbxigoft 
       foreign key (end_id) 
       references endereco;
 
    
    alter table item_produto 
       add constraint FKmian22g9xuhv3l2028eaoekei 
       foreign key (prod_id) 
       references produto;
 
    
    alter table item_produto
       add constraint FK1fj2iyapbawwly7m1ahwtms3i 
       foreign key (tro_id) 
       references troca;
 
    
    alter table item_produto
       add constraint FKf24mnu36pm6sb7lswrnpth2ta 
       foreign key (crc_id) 
       references carrinho_compra;
 
    
    alter table pedido 
       add constraint FKrq4k57mkt7stvnfbsayecv2x 
       foreign key (crc_id) 
       references carrinho_compra;
 
    
    alter table pedido 
       add constraint FKshbbmdjq9wlvdtfb69xykbjtf 
       foreign key (fre_id) 
       references frete;
 
    
    alter table pedido 
       add constraint FK65jf5o87qrwjd3ehl7wv7s68v 
       foreign key (pag_id) 
       references pagamento;
 
    
    alter table pedido 
       add constraint FKev706mmtoai84nsx30abnxw0l 
       foreign key (pes_id) 
       references pessoa;
 
    
    alter table produto 
       add constraint FKrbjtfen8ngfbs1e8qrb0x9fec 
       foreign key (prod_categoria_id) 
       references categoria;
 
    
    alter table produto 
       add constraint FKn9csobivooi5gq3k6oj79j416 
       foreign key (grp_id) 
       references grupo_precificacao;
 
    
    alter table telefone 
       add constraint FK6u09n8xvy2idhbv7imhejx537 
       foreign key (pes_id) 
       references pessoa;
 
    
    alter table troca 
       add constraint FK1tto5xjcjypgjjoegidqlot40 
       foreign key (cpm_id) 
       references cupom;
 
    
    alter table usuario 
       add constraint FKbvjdxsk7rynddh7eo25kdwqdy 
       foreign key (pes_id) 
       references pessoa;
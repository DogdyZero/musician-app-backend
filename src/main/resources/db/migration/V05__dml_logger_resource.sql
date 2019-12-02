create table logger_resource(
	log_id integer NOT NULL PRIMARY KEY,
	log_data date,
	log_id_requisitado integer,
	log_ocorrencia VARCHAR(200) NOT NULL,
	log_nome_objeto VARCHAR(50) NOT NULL,
	log_nome_classe VARCHAR(50) NOT NULL
);

create sequence logger_resource_seq start 1 increment by 1;
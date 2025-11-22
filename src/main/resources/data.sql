INSERT INTO skills_futuras (id, nome, categoria, descricao) VALUES
(1,'IA Generativa Aplicada','Tecnica','Uso prático de modelos generativos'),
(2,'Analise de Dados','Tecnica','Manipulação e interpretação de dados'),
(3,'Sustentabilidade','Transversal','Conceitos de economia verde'),
(4,'Saude Digital','Tecnica','Solucoes digitais para a saude'),
(5,'Impressao 3D','Tecnica','Fabricacao aditiva');

INSERT INTO programas_transicao (id, nome, descricao, setor_destino, carga_horaria, nivel, modalidade) VALUES
(1,'Do Administrativo para Analista de Dados Júnior','Programa para formar analistas de dados iniciais','Tecnologia',120,'INICIANTE','ONLINE'),
(2,'De Tecnico Industrial para Especialista em Impressao 3D','Transicao para fabricacao aditiva','Indústria',160,'INTERMEDIARIO','HÍBRIDO'),
(3,'Do Enfermeiro para Operador de Sistemas de Saúde Digital','Formação em sistemas de saude digital','Saúde',100,'INICIANTE','PRESENCIAL');

-- ligações programa_skill
INSERT INTO programa_skill (programa_id, skill_id) VALUES (1,2),(1,1),(2,5),(3,4);

INSERT INTO profissionais (id,nome,email,carreira_atual,carreira_desejada,experiencia,data_registro) VALUES
(1,'Joao Silva','joao.silva@example.com','Administrativo','Analise de Dados',3,CURRENT_DATE),
(2,'Maria Pereira','maria.pereira@example.com','Tecnico Industrial','Especialista Impressao 3D',7,CURRENT_DATE);

INSERT INTO inscricoes (id,profissional_id,programa_id,data_inscricao,status) VALUES
(1,1,1,CURRENT_DATE,'INSCRITO'),
(2,2,2,CURRENT_DATE,'INSCRITO');
